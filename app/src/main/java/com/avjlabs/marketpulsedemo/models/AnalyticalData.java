package com.avjlabs.marketpulsedemo.models;

import java.util.ArrayList;

public class AnalyticalData {

    private int id;
    private String name;
    private String tag;
    private String color;
    private ArrayList<CriteriaData> criteriaData;

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

    public ArrayList<CriteriaData> getCriteriaData() {
        return criteriaData;
    }

    public void setCriteriaData(ArrayList<CriteriaData> criteriaData) {
        this.criteriaData = criteriaData;
    }
}
