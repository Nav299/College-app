package com.example.kgrcet;

import android.graphics.Bitmap;

public class post {

    private Bitmap image;
    private String description;
    private long timestamp;

    public post(Bitmap image, String description, long timestamp) {
        this.image = image;
        this.description = description;
        this.timestamp=timestamp;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
    public long getTimestamp(){
        return timestamp;
    }

}
