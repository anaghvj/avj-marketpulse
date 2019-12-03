package com.avjlabs.marketpulsedemo.models;

import org.json.JSONObject;

public class Criteria {

    private String type;
    private String text;
    private JSONObject variable;

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

    public JSONObject getVariable() {
        return variable;
    }

    public void setVariable(JSONObject variable) {
        this.variable = variable;
    }
}
