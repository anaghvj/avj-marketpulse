package com.avjlabs.marketpulsedemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnalyticalData implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("tag")
    private String tag;
    @SerializedName("color")
    private String color;
    public static final Creator<AnalyticalData> CREATOR = new Creator<AnalyticalData>() {
        @Override
        public AnalyticalData createFromParcel(Parcel in) {
            return new AnalyticalData(in);
        }

        @Override
        public AnalyticalData[] newArray(int size) {
            return new AnalyticalData[size];
        }
    };
    @SerializedName("criteria")
    private ArrayList<Criteria> criteria;

    protected AnalyticalData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        tag = in.readString();
        color = in.readString();
        criteria = in.createTypedArrayList(Criteria.CREATOR);
    }

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
        return criteria;
    }

    public void setCriteriaData(ArrayList<Criteria> criteriaData) {
        this.criteria = criteriaData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(tag);
        parcel.writeString(color);
        parcel.writeTypedList(criteria);
    }
}
