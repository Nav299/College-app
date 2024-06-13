package com.example.kgrcet;

public class Investor {

    private String name;
    private int imageResource;

    public Investor(String name, int imageResource){
        this.name=name;
        this.imageResource=imageResource;
    }

    public String getName(){
        return name;
    }
    public int getImageResource(){
        return imageResource;
    }
}
