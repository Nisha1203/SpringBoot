package com.luv2code.springcoredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements  Coach{
    @Override
    public String gerDailyWorkout() {
        return "primary: Practice fast bowling?....??";
    }
}
