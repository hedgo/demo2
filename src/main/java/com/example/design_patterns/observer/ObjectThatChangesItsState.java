package com.example.design_patterns.observer;

public class ObjectThatChangesItsState {
    private String myChangingState = "Tutaj są zmiany stanu";
    Publisher publisher = new Publisher();//normalnie to bylby singleton springa wstrzykniety

    public String getState() {
        return myChangingState;
    }

    public void stateChanged(){
        //todo: tutaj jakos mutuj myChangingState
        publisher.notifySubscribers();
    }
}
