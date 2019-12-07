package com.avjlabs.marketpulsedemo.models;

import org.json.JSONArray;

public class NetworkResponse {

    private int statuscode = -1;
    private JSONArray jsonObjectResponse;

    public NetworkResponse() {
    }

    public NetworkResponse(
            int statuscode,
            JSONArray jsonObjectResponse
    ) {
        this.statuscode = statuscode;
        this.jsonObjectResponse = jsonObjectResponse;

    }

    public JSONArray getJsonObjectResponse() {
        return jsonObjectResponse;
    }

    public void setJsonObjectResponse(JSONArray jsonObjectResponse) {
        this.jsonObjectResponse = jsonObjectResponse;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }
}
