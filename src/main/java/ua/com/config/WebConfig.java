package ua.com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
//import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.*")
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public StandardServletMultipartResolver resolver() {
//        return new StandardServletMultipartResolver();
//    }
    @Bean (name = "multipartResolver")
    public CommonsMultipartResolver filterMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("utf-8");
//        resolver.setMaxUploadSize(10000);
        return resolver;
    }

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

//    public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
//        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
//
//        ObjectMapper mapper = new ObjectMapper();
//        //Registering Hibernate4Module to support lazy objects
//        mapper.registerModule(new Hibernate5Module());
//
//        messageConverter.setObjectMapper(mapper);
//        return messageConverter;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //Here we add our custom-configured HttpMessageConverter
//        converters.add(jacksonMessageConverter());
//        super.configureMessageConverters(converters);
//    }
}
