package com.avjlabs.marketpulsedemo;

import android.app.Application;

import com.avjlabs.marketpulsedemo.apputils.AppUtiils;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

public class ApplicationSingleton extends Application {

    private OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        setOkHttpClient(initOkhttpClient());
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    private OkHttpClient initOkhttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(30, 120, TimeUnit.SECONDS))
                .connectTimeout(AppUtiils.TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .writeTimeout(AppUtiils.TIMEOUT_WRITE, TimeUnit.SECONDS)
                .readTimeout(AppUtiils.TIMEOUT_READ, TimeUnit.SECONDS)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .build();
        return okHttpClient;
    }
}
