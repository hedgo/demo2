package com.example.design_patterns.observer;

public class SMSSubscriber implements Subscriber {
    @Override
    public void update() {
        System.out.println("SMS updated");
    }
}
