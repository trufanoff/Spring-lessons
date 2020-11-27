package ru.gb.lesson1;

import org.springframework.context.annotation.Bean;

public class JavaConfig {

    @Bean
    public CameraRoll cameraRoll(){
        return new BlackAndWhiteRoll();
    }

    @Bean
    public Camera camera(){
        return new Camera(cameraRoll());
    }
}
