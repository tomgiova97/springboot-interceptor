package com.tomgiova.springinterceptor.config;

import com.tomgiova.springinterceptor.services.AuthenticationService;
import com.tomgiova.springinterceptor.services.AuthenticationServiceImpl;
import com.tomgiova.springinterceptor.utils.InterceptorUtils;
import com.tomgiova.springinterceptor.RequestProcessingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Map;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    final List<Map<String,String>> unprotectedURIs = InterceptorUtils.unprotectedURIs();

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestProcessingInterceptor(unprotectedURIs,authenticationService())).addPathPatterns("/**");
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationServiceImpl();
    }
}
