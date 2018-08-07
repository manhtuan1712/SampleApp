package com.example.manhtuan.sampleapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("name")
    private String name;

    @SerializedName("vicinity")
    private String address;

    @SerializedName("photos")
    private List<Photo> photoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
