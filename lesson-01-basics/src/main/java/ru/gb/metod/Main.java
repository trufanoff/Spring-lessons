package ru.gb.metod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        HelloMan man = context.getBean("helloMan", HelloMan.class);
        System.out.println(man.getName());
    }
}
