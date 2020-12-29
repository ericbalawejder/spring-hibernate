package com.springboot.demo.demoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DemoRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return coachName + " coaches da " + teamName;
    }

}
