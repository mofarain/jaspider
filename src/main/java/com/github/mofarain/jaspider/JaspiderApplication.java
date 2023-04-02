package com.github.mofarain.jaspider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JaspiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaspiderApplication.class, args);
    }

}
