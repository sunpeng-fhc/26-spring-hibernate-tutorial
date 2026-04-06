package com.springboot.demo.mycoolapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private  String coachName;

    @Value("${teame.name}")
    private String teamName;


//    expose new endpoint for "teamInfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + " , Team Name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello Word!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5K!!!!!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day.";
    }





}
