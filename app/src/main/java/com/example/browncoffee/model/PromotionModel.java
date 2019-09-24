package com.example.browncoffee.model;

import java.io.Serializable;

public class PromotionModel implements Serializable {
    private String title;
    private int image, detail;

    public PromotionModel(String title, int image,int detail) {
        this.title = title;
        this.image = image;
        this.detail=detail;
    }

    public int getDetail() { return detail; }

    public void setDetail(int detail) { this.detail = detail; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public int getImage() { return image; }

    public void setImage(int image) { this.image = image; }
}

