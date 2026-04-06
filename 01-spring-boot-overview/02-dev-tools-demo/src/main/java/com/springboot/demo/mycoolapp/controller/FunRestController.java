package com.springboot.demo.mycoolapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

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
