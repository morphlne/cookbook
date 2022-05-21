package io.pan.openapi.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        new SpringApplication(UserApplication.class).run(args);
    }

}
