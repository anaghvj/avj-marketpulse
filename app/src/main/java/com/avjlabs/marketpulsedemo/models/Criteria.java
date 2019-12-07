package com.avjlabs.marketpulsedemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Criteria implements Parcelable {

    @SerializedName("type")
    private String type;
    @SerializedName("text")
    private String text;
    @SerializedName("variable")
    private HashMap<String, Variable> variable;


    public static final Creator<Criteria> CREATOR = new Creator<Criteria>() {
        @Override
        public Criteria createFromParcel(Parcel in) {
            return new Criteria(in);
        }

        @Override
        public Criteria[] newArray(int size) {
            return new Criteria[size];
        }
    };

    protected Criteria(Parcel in) {
        type = in.readString();
        text = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeString(this.text);
        parcel.writeMap(this.variable);

    }

  /*  private Criteria(Parcel in) {

        variable = new HashMap<String, Variable>();
        in.readHashMap(variable, Criteria.CREATOR);
    }*/

//    public static final Parcelable.Creator<Criteria> CREATOR = new Parcelable.Creator<Criteria>() {
//        public Criteria createFromParcel(Parcel in) {
//            return new Criteria(in);
//        }
//
//        @Override
//        public Criteria[] newArray(int i) {
//            return new Criteria[i];
//        }
//
//    };
}
