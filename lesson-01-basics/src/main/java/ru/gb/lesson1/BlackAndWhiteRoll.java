package ru.gb.lesson1;

import org.springframework.stereotype.Component;

@Component
public class BlackAndWhiteRoll implements CameraRoll {

    public void processing() {
        System.out.println("-1 ч/б кадр");
    }
}
