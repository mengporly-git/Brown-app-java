package com.example.browncoffee.model;

import java.io.Serializable;

public class StoreModel implements Serializable {
    private int image, facebook;
    private String store, address, number;

    public StoreModel(int image, int facebook, String store, String address, String number) {
        this.image = image;
        this.facebook = facebook;
        this.store = store;
        this.address = address;
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFacebook() {
        return facebook;
    }

    public void setFacebook(int facebook) {
        this.facebook = facebook;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
