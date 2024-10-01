package com.luv2code.springcoredemo;

public class SwimCoach implements Coach{

    public SwimCoach()
    {
        System.out.println("In constructor"+getClass().getSimpleName());
    }
    @Override
    public String gerDailyWorkout() {
        return "Swin 100m as a warm up";
    }
}
