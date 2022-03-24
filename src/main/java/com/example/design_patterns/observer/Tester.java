package com.example.design_patterns.observer;

public class Tester {

    public static void main(String[] args) {
        ObjectThatChangesItsState objectThatChangesItsState = new ObjectThatChangesItsState();
        objectThatChangesItsState.publisher.register(new EmailSubscriber());
        objectThatChangesItsState.publisher.register(new SMSSubscriber());

        objectThatChangesItsState.stateChanged();
        objectThatChangesItsState.stateChanged();
        objectThatChangesItsState.stateChanged();
    }
}
