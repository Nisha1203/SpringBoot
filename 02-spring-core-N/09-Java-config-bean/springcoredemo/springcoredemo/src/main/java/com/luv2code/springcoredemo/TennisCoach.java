package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String gerDailyWorkout() {
        return "Practice your backhand valleyn8f";
    }
}
