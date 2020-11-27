package ru.gb.metod;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan("ru.gb.metod")
public class JavaConfig {

    @Bean(name = "helloMan")
    public HelloMan helloMan(@Value("Yuri1") String name) {
        HelloMan helloMan = new HelloManOnceSay(name);
        return helloMan;
    }
}
