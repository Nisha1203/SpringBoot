package com.luv2code.springcoredemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String gerDailyWorkout() {
        return "Run a hard 5k";
    }
}
