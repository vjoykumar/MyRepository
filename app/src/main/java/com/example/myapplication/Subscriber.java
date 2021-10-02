package com.example.myapplication;

public class Subscriber {
    private Channel channel = new Channel();
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(){
        System.out.println("Video uploaded.");
    }

    public void subscribeToChannel(Channel channel){
        this.channel = channel;
    }
}
