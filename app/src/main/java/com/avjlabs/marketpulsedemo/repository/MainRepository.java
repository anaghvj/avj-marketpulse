package com.avjlabs.marketpulsedemo.repository;

import android.os.AsyncTask;
import android.util.Log;

import com.avjlabs.marketpulsedemo.apputils.AppUtiils;
import com.avjlabs.marketpulsedemo.apputils.NetworkUtil;
import com.avjlabs.marketpulsedemo.models.AnalyticalData;
import com.avjlabs.marketpulsedemo.models.NetworkResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;

public class MainRepository {

    MutableLiveData<ArrayList<AnalyticalData>> responsedataX = new MutableLiveData<>();
    private static MainRepository mainRepositoryInstance;
    MutableLiveData<Boolean> loading = new MutableLiveData<>();
    MutableLiveData<Boolean> emptydata = new MutableLiveData<>();

    public MutableLiveData<Boolean> isLoading() {
        return loading;
    }

    public MutableLiveData<Boolean> isEmptydata() {
        return emptydata;
    }

    public static MainRepository getInstance() {
        if (mainRepositoryInstance == null) {
            mainRepositoryInstance = new MainRepository();
        }
        return mainRepositoryInstance;
    }

    public LiveData<ArrayList<AnalyticalData>> getDataFromApi() {
        Log.i("api", "fetching data...");
        new AsyncTask<Void, Void, ArrayList<AnalyticalData>>() {
            @Override
            protected ArrayList<AnalyticalData> doInBackground(Void... voids) {
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        //.connectionPool(new ConnectionPool(30, 120, TimeUnit.SECONDS))
                        .connectTimeout(AppUtiils.TIMEOUT_CONNECT, TimeUnit.SECONDS)
                        .writeTimeout(AppUtiils.TIMEOUT_WRITE, TimeUnit.SECONDS)
                        .readTimeout(AppUtiils.TIMEOUT_READ, TimeUnit.SECONDS)
                        // .followSslRedirects(true)
                        // .retryOnConnectionFailure(true)
                        .build();
                try {
                    HashMap<String, NetworkResponse> response = NetworkUtil.makeRequest(
                            okHttpClient,
                            AppUtiils.DATA_API_URI,
                            AppUtiils.REQUEST_TYPE_GET, null, null);
                    if (response != null) {
                        if (response.get(AppUtiils.KEY_NETWORK_CLASS_RESPONSE).getStatuscode()
                                == 200) {
                            Gson gson = new Gson();
                            Type dataType = new TypeToken<ArrayList<AnalyticalData>>() { }.getType();
                            ArrayList<AnalyticalData> responseData =
                                    gson.fromJson(String.valueOf(
                                            response.get(AppUtiils.KEY_NETWORK_CLASS_RESPONSE)
                                                    .getJsonObjectResponse()), dataType);
                            return responseData;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading.postValue(true);
                emptydata.postValue(false);
            }

            @Override
            protected void onPostExecute(ArrayList<AnalyticalData> analyticalData) {
                super.onPostExecute(analyticalData);
                loading.postValue(false);
                if (analyticalData != null) {
                    responsedataX.postValue(analyticalData);
                    if ((analyticalData.size() == 0)) {
                        emptydata.postValue(true);
                    } else {
                        emptydata.postValue(false);
                    }
                } else {
                    emptydata.postValue(true);
                }
            }
        }.execute();

        return responsedataX;
    }
}
