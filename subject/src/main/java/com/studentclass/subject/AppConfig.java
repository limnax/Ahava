package com.studentclass.subject;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @LoadBalanced
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
