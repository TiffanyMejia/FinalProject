package com.launchcode.gamersunite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class SpringSecurityConfig implements WebMvcConfigurer{
    @Bean
    public Authentication authentication() {
        return new Authentication();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new MappedInterceptor(new String[]{"/**"}, new String[]{"/images/**"}, authentication()) );
    }
    }


