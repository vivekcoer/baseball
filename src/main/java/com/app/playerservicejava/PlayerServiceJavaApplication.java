package com.app.playerservicejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlayerServiceJavaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PlayerServiceJavaApplication.class, args);
        Object dataSource = context.getBean("dataSource");
        System.out.println(dataSource);
    }

}
