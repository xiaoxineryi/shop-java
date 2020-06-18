package com.xiaoxin.ac.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String root = "E:\\Grade_2\\WEB\\ac\\src\\main\\resources\\imgs\\";

        registry.addResourceHandler("/img/**").addResourceLocations("file:"+root);

    }
}
