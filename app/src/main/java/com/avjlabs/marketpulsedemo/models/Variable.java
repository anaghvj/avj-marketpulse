package com.avjlabs.marketpulsedemo.models;

import java.util.ArrayList;

public class Variable {

    private String type;
    private ArrayList<Integer> values;
    private String study_type;
    private String parameter_name;
    private int min_value;
    private int max_value;
    private int default_value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }

    public String getStudy_type() {
        return study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }

    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public int getMin_value() {
        return min_value;
    }

    public void setMin_value(int min_value) {
        this.min_value = min_value;
    }

    public int getMax_value() {
        return max_value;
    }

    public void setMax_value(int max_value) {
        this.max_value = max_value;
    }

    public int getDefault_value() {
        return default_value;
    }

    public void setDefault_value(int default_value) {
        this.default_value = default_value;
    }
}
