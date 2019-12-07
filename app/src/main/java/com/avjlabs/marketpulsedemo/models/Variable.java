package com.avjlabs.marketpulsedemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Variable implements Parcelable {

    @Nullable private String type;
    private ArrayList<Double> values;
    @Nullable private String study_type;
    @Nullable private String parameter_name;
    private double min_value;
    private double max_value;
    private double default_value;

    public static final Creator<Variable> CREATOR = new Creator<Variable>() {
        @Override
        public Variable createFromParcel(Parcel in) {
            return new Variable(in);
        }

        @Override
        public Variable[] newArray(int size) {
            return new Variable[size];
        }
    };

    protected Variable(Parcel in) {
        type = in.readString();
        values = new ArrayList<Double>();
        in.readList(values, Double.class.getClassLoader());
        study_type = in.readString();
        parameter_name = in.readString();
        min_value = in.readDouble();
        max_value = in.readDouble();
        default_value = in.readDouble();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeList(values);
        parcel.writeString(study_type);
        parcel.writeString(parameter_name);
        parcel.writeDouble(min_value);
        parcel.writeDouble(max_value);
        parcel.writeDouble(default_value);

    }

}
