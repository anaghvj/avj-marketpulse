package com.avjlabs.marketpulsedemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnalyticalData {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("tag")
    private String tag;
    @SerializedName("color")
    private String color;
    @SerializedName("criteria")
    private ArrayList<Criteria> criteriaData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Criteria> getCriteriaData() {
        return criteriaData;
    }

    public void setCriteriaData(ArrayList<Criteria> criteriaData) {
        this.criteriaData = criteriaData;
    }
}
