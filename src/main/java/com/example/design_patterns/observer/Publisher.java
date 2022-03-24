package com.example.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher { //Obiekt obserwowany / publisher
    private List<Subscriber> subscriberList = new ArrayList<>();

    void register(Subscriber observer) {
        subscriberList.add(observer);
    }

    void unRegister(Subscriber observer) {
        subscriberList.remove(observer);
    }

    void notifySubscribers() {
        for (Subscriber subscriber : subscriberList) {
            subscriber.update();
        }
        //    void notifyObservers(teoretycznie tutaj moge przesylac stan, ale wtedy mam kruche api);
    }
}
