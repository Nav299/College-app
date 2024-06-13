package com.example.kgrcet;

public class ClassItem {

    private String className;
    private int imageResourceId;

    public ClassItem(String className, int imageResourceId) {
        this.className = className;
        this.imageResourceId = imageResourceId;
    }

    public String getClassName() {
        return className;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
