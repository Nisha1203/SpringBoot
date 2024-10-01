package com.luv2code.springcoredemo;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements  Coach{
    @Override
    public String gerDailyWorkout() {
        return "primary: Practice fast bowling?....??";
    }
}
