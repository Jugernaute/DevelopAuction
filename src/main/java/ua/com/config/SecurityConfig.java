package ua.com.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.social.UserIdSource;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
@ComponentScan("ua.com.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
    UserIdSource userIdSource;//social


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryConfigurer() {
        return new InMemoryUserDetailsManagerConfigurer<>();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,
                                @Qualifier("authenticationProvider") AuthenticationProvider provider) {
        try {
            inMemoryConfigurer()
                    .withUser("admin")
                    .password("admin")
                    .authorities("ROLE_ADMIN")
                    .and()
                    .configure(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        auth.authenticationProvider(provider);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/protected").authenticated()//social
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/ok")
                .failureUrl("/error")
                .and()
                .logout()
                .logoutRequestMatcher( new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .apply(new SpringSocialConfigurer().alwaysUsePostLoginUrl(true).userIdSource(userIdSource).signupUrl("/"))//social
                .and()
                .csrf().disable();
    }
}
