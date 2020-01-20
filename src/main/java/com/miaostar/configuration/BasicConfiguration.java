package com.miaostar.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfiguration {

    @Bean
    public Module hibernate5Module() {
        return new Hibernate5Module();
    }

    @Bean
    public Module javaTimeModule() {
        return new JavaTimeModule();
    }


}
