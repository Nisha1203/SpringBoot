package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach{
    @Override
    public String gerDailyWorkout() {
        return "Spend  30 minutes in batting pratice";
    }
}
