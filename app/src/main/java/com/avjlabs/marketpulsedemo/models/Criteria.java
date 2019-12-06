package com.avjlabs.marketpulsedemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Criteria {

    @SerializedName("type")
    private String type;
    @SerializedName("text")
    private String text;
    @SerializedName("variable")
    private HashMap<String, Variable> variable;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HashMap<String, Variable> getVariable() {
        return variable;
    }

    public void setVariable(HashMap<String, Variable> variable) {
        this.variable = variable;
    }
}
