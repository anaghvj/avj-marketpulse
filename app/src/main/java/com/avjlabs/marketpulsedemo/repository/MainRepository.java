package com.avjlabs.marketpulsedemo.repository;

import com.avjlabs.marketpulsedemo.models.AnalyticalData;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import androidx.lifecycle.MutableLiveData;

public class MainRepository {
    private static MainRepository mainRepositoryInstance;

    public static MainRepository getInstance() {
        if (mainRepositoryInstance == null) {
            mainRepositoryInstance = new MainRepository();
        }
        return mainRepositoryInstance;
    }

    public MutableLiveData<ArrayList<AnalyticalData>> getDataFromApi() throws ExecutionException,
            InterruptedException {

        return null;
    }
}
