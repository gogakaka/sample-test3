package com.gogakaka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.gogakaka", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value={Controller.class}))
public class ServletConfiguration implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setOrder(2);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //System.out.println("[DEBUG] Add InternalResourceViewResolver");

        return resolver;
    }
    /*
    @Bean
    public MappingJackson2JsonView jsonResolver() {

        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setContentType("application/json;charset=UTF-8");

        return view;

    }

     */
}
