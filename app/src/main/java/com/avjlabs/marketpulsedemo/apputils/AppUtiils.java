package com.avjlabs.marketpulsedemo.apputils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class AppUtiils {

    /*Constants*/
    public static final long TIMEOUT_CONNECT = 600;
    public static final long TIMEOUT_WRITE = 600;
    public static final long TIMEOUT_READ = 600;
    public static final String KEY_NETWORK_CLASS_RESPONSE = "response";
    public static final String REQUEST_TYPE_GET = "GET";

    /*APIs*/
    public static final String DATA_API_URI = "https://mp-android-challenge.herokuapp.com/data";

    public static String mapToQueryBuilder(HashMap<String, String> queryMap) throws
            UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        for (HashMap.Entry<String, String> e : queryMap.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(URLEncoder.encode(e.getKey(), "UTF-8"))
                    .append('=')
                    .append(/*URLEncoder.encode(*/e.getValue()/*, "UTF-8")*/);
        }
        return stringBuilder.toString();

    }
}
