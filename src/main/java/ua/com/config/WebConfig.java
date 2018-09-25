package ua.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.*")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/pages/");
        resolver.setSuffix(".jsp");
//        resolver.setCache(true);
        return resolver;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/views/js/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/views/img/");
        registry.addResourceHandler("/style/**")
                .addResourceLocations("/views/style/");

    }

@Bean
public JavaMailSenderImpl javaMailSender(){
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    javaMailSender.setHost("smtp.gmail.com");
    javaMailSender.setPort(587);
//    enter email and pass
    javaMailSender.setUsername("4pasha.com@gmail.com");
    javaMailSender.setPassword("pashapasha");
    Properties properties = javaMailSender.getJavaMailProperties();
    properties.put("mail.transport.protocol","smtp");
    properties.put("mail.smtp.auth","true");
    properties.put("mail.smtp.starttls.enable","true");
    properties.put("mail.debug","true");
    return javaMailSender;
}
}
