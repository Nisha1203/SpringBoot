package com.luv2code.springcoredemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{

    //define init method
    @PostConstruct
    public  void doMystartup()
    {
        System.out.println("In doMystartup"+getClass().getSimpleName());
    }

    //define our destroy method
    @PreDestroy
    public  void doMycleanup()
    {
        System.out.println("In doMycleanup"+getClass().getSimpleName());
    }

    @Override
    public String gerDailyWorkout() {
        return "primary: Practice fast bowling?....??";
    }
}
