package com.avjlabs.marketpulsedemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CriteriaData {

    @SerializedName("criteria")
    private ArrayList<Criteria> criteriaArrayList;

    public ArrayList<Criteria> getCriteriaArrayList() {
        return criteriaArrayList;
    }

    public void setCriteriaArrayList(ArrayList<Criteria> criteriaArrayList) {
        this.criteriaArrayList = criteriaArrayList;
    }
}
