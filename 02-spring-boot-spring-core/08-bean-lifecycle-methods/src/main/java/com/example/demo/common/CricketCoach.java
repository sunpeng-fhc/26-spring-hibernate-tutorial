package com.example.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


//
// @Component  annotation marks the class as a Spring bean
//
@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("---> In constructor CricketCoach(): " + getClass().getSimpleName());
    }



//    define init method
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("---> In PostConstruct doStartupStuff() : "  + getClass().getSimpleName());
    }


//    define destroy method
    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("---> In PreDestroy doCleanupStuff() : "  + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return " Practice fast bowling for 15 minutes . ";
    }
}




















