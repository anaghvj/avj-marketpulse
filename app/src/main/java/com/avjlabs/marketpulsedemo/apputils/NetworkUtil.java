package com.avjlabs.marketpulsedemo.apputils;

import com.avjlabs.marketpulsedemo.models.NetworkResponse;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkUtil {

    public static final String TAG = "Network-Util";

    /*
     * @todo: only support GET request now will add other support later
     *   */
    @Nullable
    public static HashMap<String, NetworkResponse> makeRequest(
            OkHttpClient okHttpClient,
            String url,
            String requestType,
            HashMap<String, String> requestParam,
            HashMap<String, String> requestHeaders) throws IOException {
        if (requestType.toUpperCase().equals(AppUtiils.REQUEST_TYPE_GET)) {
            String queryData = "";
            if (requestParam != null) {
                if (!requestParam.isEmpty()) {
                    queryData = AppUtiils.mapToQueryBuilder(requestParam);
                }
            }

            Request.Builder builder = new Request.Builder();
            if (queryData.trim().isEmpty()) {
                builder.url(url);
            } else {
                builder.url(url + "?" + queryData);
            }

            if (requestHeaders != null) {
                if (!requestHeaders.isEmpty()) {
                    for (Map.Entry<String, String> param : requestHeaders.entrySet()) {
                        if (param.getKey() != null && param.getValue() != null) {
                            builder.addHeader(param.getKey(), param.getValue());
                        }
                    }
                }
            }

            Request request = builder.build();
            Response response = okHttpClient.newCall(request).execute();

            HashMap<String, NetworkResponse> respMap = new HashMap<>();
            NetworkResponse responseData = new NetworkResponse();
            JSONObject responseJsonObject = null;
            String responseBody = response.body().string();
            try {
                responseJsonObject = new JSONObject(responseBody);
            } catch (JSONException e) {
                responseJsonObject = new JSONObject();
            }
            responseData = new NetworkResponse(response.code(), responseJsonObject);
            response.body().close();

            respMap.put(AppUtiils.KEY_NETWORK_CLASS_RESPONSE, responseData);
            return respMap;
        }
        return null;
    }
}


