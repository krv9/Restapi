package com.tcs.krishna.restapi.configuration;

import com.tcs.krishna.restapi.DB;
import com.tcs.krishna.restapi.DevDB;
import com.tcs.krishna.restapi.ProDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "Development")
    public DB getDevDb(){
    return  new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "Production")
    public DB getProDB(){
        return new ProDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
