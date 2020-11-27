package ru.gb.lesson1;

import org.springframework.stereotype.Component;

@Component
public class Camera {
    private CameraRoll cameraRoll;

    public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }
    public void doPhoto(){
        System.out.println("Щелк!");
        cameraRoll.processing();
    }

}
