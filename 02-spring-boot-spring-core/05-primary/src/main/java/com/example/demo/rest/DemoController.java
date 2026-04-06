package com.example.demo.rest;

import com.example.demo.common.Coach;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    // define a private field for the dependency
    private Coach myCoach;


// define a constructor for dependency injection

//    @Qualifier  More specific ; Higher priority   @Qualifier("cricketCoach")
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}































