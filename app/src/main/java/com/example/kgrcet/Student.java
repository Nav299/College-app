package com.example.kgrcet;

import java.io.Serializable;

public class Student implements Serializable {

    private int rollNo;
    private String fullName;
    private int imageResourceId;



    public Student(int rollNo, String fullName, int imageResourceId, int certificateResourceId) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.imageResourceId = imageResourceId;

    }



    public int getRollNo() {
        return rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
