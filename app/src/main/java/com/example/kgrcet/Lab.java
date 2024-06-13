package com.example.kgrcet;

public class Lab {
    private String name;
    private int imageResId;

    public Lab(String name, int imageResId) {
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
