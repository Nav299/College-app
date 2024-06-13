package com.example.kgrcet;

public class FacultyModel {

    private String name;
    private int imageResId;
    private String subject;

    public FacultyModel(String name, int imageResId, String subject) {
        this.name = name;
        this.imageResId = imageResId;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getSubject() {
        return subject;
    }
}
