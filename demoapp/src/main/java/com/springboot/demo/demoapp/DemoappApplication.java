package com.springboot.demo.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Command line run:
// $ gradle build
// $ java -jar ./build/libs/demoapp-0.0.1-SNAPSHOT.war

// Gradle Spring Boot plugin:
// $ gradle bootRun

@SpringBootApplication
public class DemoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoappApplication.class, args);
    }

}
