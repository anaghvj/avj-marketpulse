package com.avjlabs.marketpulsedemo.models;

import java.util.ArrayList;

public class Variable {

    private String type;
    private ArrayList<Double> values;
    private String study_type;
    private String parameter_name;
    private double min_value;
    private double max_value;
    private double default_value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setValues(ArrayList<Double> values) {
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

    public double getMin_value() {
        return min_value;
    }

    public void setMin_value(double min_value) {
        this.min_value = min_value;
    }

    public double getMax_value() {
        return max_value;
    }

    public void setMax_value(double max_value) {
        this.max_value = max_value;
    }

    public double getDefault_value() {
        return default_value;
    }

    public void setDefault_value(double default_value) {
        this.default_value = default_value;
    }
}
