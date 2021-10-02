package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(){
        for (Subscriber sub: subscribers){
            sub.update();
        }
    }
}
