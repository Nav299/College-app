package com.example.kgrcet;

public class certificate {

    private String name;
    private int imageResId;

    public certificate(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

}
