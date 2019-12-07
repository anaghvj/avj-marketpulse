package com.avjlabs.marketpulsedemo;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import com.avjlabs.marketpulsedemo.Adapters.MainRecyclerAdapter;
import com.avjlabs.marketpulsedemo.models.AnalyticalData;
import com.avjlabs.marketpulsedemo.repository.MainRepository;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<Boolean> loading;
    public MutableLiveData<Boolean> showEmpty;
    LiveData<ArrayList<AnalyticalData>> analyticalDataArrayList;
    MainRecyclerAdapter mainRecyclerAdapter;

    public MainViewModel() {
        loading = MainRepository.getInstance().isLoading();
        showEmpty = MainRepository.getInstance().isEmptydata();

        analyticalDataArrayList = MainRepository.getInstance().getDataFromApi();
        mainRecyclerAdapter = new MainRecyclerAdapter(analyticalDataArrayList, this);
    }

    public void getDataFromApi() {
        analyticalDataArrayList = MainRepository.getInstance().getDataFromApi();
    }

    public MainRecyclerAdapter getAdapter() {
        return mainRecyclerAdapter;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<Boolean> getShowEmpty() {
        return showEmpty;
    }

    public LiveData<ArrayList<AnalyticalData>> getAnalyticalDataArrayList() {
        return analyticalDataArrayList;
    }

    public AnalyticalData getDataAt(Integer index) {
        if (index != null && analyticalDataArrayList != null &&
                analyticalDataArrayList.getValue().size() > index) {
            return analyticalDataArrayList.getValue().get(index);
        }
        return null;

    }

    public int getColor(String color) {
        if (color.equals("green")) {
            return Color.GREEN;
        } else if (color.equals("red")) {
            return Color.RED;
        } else {
            return Color.WHITE;
        }
    }

    public void onItemClick(int index, View view) {
        Log.d("ClickItem", "clicked " + index);
        Intent intent = new Intent(view.getContext(), DetailsActivity.class);
        intent.putExtra("data", analyticalDataArrayList.getValue().get(index).getCriteriaData());
        view.getContext().startActivity(intent);
    }
}
