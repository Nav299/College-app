package com.example.kgrcet;

public class Units {
    private String name;
    private int imageResId;

    public Units(String name, int imageResId) {
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
