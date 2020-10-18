package ua.com.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import ua.com.method.filter.MyFilter;
//import ua.com.method.filter.SubCategoryDeserializer;

import java.util.List;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.*")

public class WebConfig extends WebMvcConfigurerAdapter {




//@Autowired
////    MyFilter myFilter;
//    SubCategoryDeserializer subCategoryDeserializer;
////
//    @Bean
//    public FilterRegistrationBean myFilterRegistrationBean() {
//        FilterRegistrationBean regBean = new FilterRegistrationBean();
//        regBean.setFilter(subCategoryDeserializer);
//        regBean.setOrder(1);
//        regBean.addUrlPatterns("/myFilteredURLPattern");
//        return regBean;
//    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver filterMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(10485760); // 10MB
//        multipartResolver.setMaxUploadSizePerFile(1048576); // 1MB
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
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        //    enter email and pass
//        javaMailSender.setUsername("pashatest.com@gmail.com");
        javaMailSender.setUsername("suzuki.auto.ria@gmail.com");

//        javaMailSender.setPassword("pashapasha");
        javaMailSender.setPassword("super1234super");
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "false");
        return javaMailSender;
    }

//    @Bean
//    public HandlerInstantiator handlerInstantiator(ApplicationContext applicationContext) {
//        return new SpringHandlerInstantiator(applicationContext.getAutowireCapableBeanFactory());
//    }
//
//    @Bean
//    public Jackson2ObjectMapperBuilder objectMapperBuilder(HandlerInstantiator handlerInstantiator) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.handlerInstantiator(handlerInstantiator);
//        return builder;
//    }

}
