package com.example.kgrcet;

public class LessonItem {

    private String name;
    private int imageResId;
    private String lessonType;
    private String pdfRawResourceId;



    public LessonItem(String name, int imageResId, String lessonType, String pdfRawResourceId) {
        this.name = name;
        this.imageResId = imageResId;
        this.lessonType=lessonType;
        this.pdfRawResourceId=pdfRawResourceId;


    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getPdfRawResourceId(){
        return pdfRawResourceId;
    }

    public String getLessonType(){return lessonType;}



}
