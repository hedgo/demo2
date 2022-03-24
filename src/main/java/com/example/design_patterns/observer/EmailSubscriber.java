package com.example.design_patterns.observer;

public class EmailSubscriber implements Subscriber {
    @Override
    public void update() {
        System.out.println("Email updeted");
    }
}
