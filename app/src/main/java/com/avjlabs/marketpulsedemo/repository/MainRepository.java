package com.avjlabs.marketpulsedemo.repository;

public class MainRepository {

    private static MainRepository mainRepositoryInstance;

    public static MainRepository getInstance() {
        if (mainRepositoryInstance == null) {
            mainRepositoryInstance = new MainRepository();
        }
        return mainRepositoryInstance;
    }

}
