package ru.gb.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ru.gb.demo"})
public class UserApplicationConfig {

    @Bean
    public Square square(){
        return new Square(10);
    }
}
