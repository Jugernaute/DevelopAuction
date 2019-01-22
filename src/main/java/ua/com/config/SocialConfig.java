package ua.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.google.security.GoogleAuthenticationService;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SocialAuthenticationProvider;
import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.facebook.security.FacebookAuthenticationService;
import org.springframework.social.security.*;

import javax.sql.DataSource;
@Configuration
@EnableSocial
@PropertySource("classpath:config.properties")
public class SocialConfig implements SocialConfigurer {
    @Autowired
    Environment environment;
    @Autowired
    DataSource dataSource;
    @Autowired
    ConnectionSignUp connectionSignUp;

    @Autowired
    SocialUserDetailsService socialUserDetailsService;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
                                       Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                environment.getProperty("facebook.app.id"),
                environment.getProperty("facebook.app.secret")));
        connectionFactoryConfigurer.addConnectionFactory(new GoogleConnectionFactory(
              environment.getProperty("google.app.id"),
                environment.getProperty("google.app.secret")));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
                dataSource,
                connectionFactoryLocator, Encryptors.noOpText());
        repository.setConnectionSignUp(connectionSignUp); // change for social
        return repository;
    }



    @Bean
    ConnectionFactoryLocator factoryLocator(){
        SocialAuthenticationServiceRegistry factoryLocator = new SocialAuthenticationServiceRegistry();
        factoryLocator.addAuthenticationService(new FacebookAuthenticationService(
                environment.getProperty("facebook.app.id"),
                environment.getProperty("facebook.app.secret"),
               environment.getProperty("facebook.app.namespace")
        ));

       factoryLocator.addAuthenticationService(new GoogleAuthenticationService(
               environment.getProperty("google.app.id"),
             environment.getProperty("google.app.secret")));


        return factoryLocator;
    }

    @Bean
    public SocialAuthenticationProvider socialAuthenticationProvider(){
        SocialAuthenticationProvider socialAuthenticationProvider = new SocialAuthenticationProvider(
                getUsersConnectionRepository(factoryLocator()),
                socialUserDetailsService
        );
        return socialAuthenticationProvider;
    }


}
