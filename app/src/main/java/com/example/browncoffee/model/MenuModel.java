package com.example.browncoffee.model;

public class MenuModel {
    private String name, rPrice, lPrice, gPrice;
    private int image;

    public MenuModel(String name, String rPrice, String lPrice, String gPrice, int image) {
        this.name = name;
        this.rPrice = rPrice;
        this.lPrice = lPrice;
        this.gPrice = gPrice;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getrPrice() { return rPrice; }

    public void setrPrice(String rPrice) {
        this.rPrice = rPrice;
    }

    public String getlPrice() {
        return lPrice;
    }

    public void setlPrice(String lPrice) {
        this.lPrice = lPrice;
    }

    public String getgPrice() {
        return gPrice;
    }

    public void setgPrice(String gPrice) {
        this.gPrice = gPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
