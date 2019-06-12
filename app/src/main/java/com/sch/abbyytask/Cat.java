package com.sch.abbyytask;


import java.io.Serializable;

/**
 * Котятка
 */

public class Cat implements Serializable {

    private String name;
    private String imageURL;

    public Cat(String content, String imageURL) {
        this.name = content;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
}
