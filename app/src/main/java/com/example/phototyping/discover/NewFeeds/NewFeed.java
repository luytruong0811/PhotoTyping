package com.example.phototyping.discover.NewFeeds;

public class NewFeed {
    private int image;
    private int avt;
    private String name;
    private String email;

    public NewFeed(int image, int avt, String name, String email) {
        this.image = image;
        this.avt = avt;
        this.name = name;
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
