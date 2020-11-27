package ru.gb.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserApplicationConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.printAllUsers();

        Box box1 = context.getBean("box", Box.class);
        Box box2 = context.getBean("box", Box.class);
        System.out.println(box1.color);
        System.out.println(box2.color);
        box1.color = "Green";
        box2.color = "White";
        System.out.println(box1.color);
        System.out.println(box2.color);

        Square square = context.getBean("square", Square.class);
        System.out.println(square.getArea());
    }
}
