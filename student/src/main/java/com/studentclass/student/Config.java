package com.studentclass.student;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    @LoadBalanced
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
