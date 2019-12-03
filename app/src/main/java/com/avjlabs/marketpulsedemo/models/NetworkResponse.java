package com.avjlabs.marketpulsedemo.models;

import org.json.JSONObject;

public class NetworkResponse {

    private int statuscode = -1;
    private JSONObject jsonObjectResponse;

    public NetworkResponse() {
    }

    public NetworkResponse(
            int statuscode,
            JSONObject jsonObjectResponse
    ) {
        this.statuscode = statuscode;
        this.jsonObjectResponse = jsonObjectResponse;

    }

    public JSONObject getJsonObjectResponse() {
        return jsonObjectResponse;
    }

    public void setJsonObjectResponse(JSONObject jsonObjectResponse) {
        this.jsonObjectResponse = jsonObjectResponse;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }
}
