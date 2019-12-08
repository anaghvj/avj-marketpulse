package com.avjlabs.marketpulsedemo.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.avjlabs.marketpulsedemo.R;
import com.avjlabs.marketpulsedemo.models.AnalyticalData;
import com.avjlabs.marketpulsedemo.viewmodels.MainViewModel;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    RecyclerView mainRecyclerView;
    LinearLayout noDataView;
    LinearLayout loadingView;
    SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  Debug.waitForDebugger();
        setContentView(R.layout.activity_main);
        swipeRefresh = findViewById(R.id.swipeRefresh);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainRecyclerView = findViewById(R.id.recyclerViewMain);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(mainViewModel.getAdapter());
        mainRecyclerView.addItemDecoration(new DividerItemDecoration(mainRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL));
        noDataView = findViewById(R.id.noDataView);
        loadingView = findViewById(R.id.loadingView);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainViewModel.getDataFromApi();
            }
        });
        mainViewModel.getAnalyticalDataArrayList().observe(this,
                new Observer<ArrayList<AnalyticalData>>() {
                    @Override
                    public void onChanged(ArrayList<AnalyticalData> analyticalData) {
                        mainViewModel.getAdapter().notifyDataSetChanged();
                    }
                });
        mainViewModel.getLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    loadingView.setVisibility(View.VISIBLE);
                    mainRecyclerView.setVisibility(View.GONE);
                    swipeRefresh.setRefreshing(true);
                } else {
                    loadingView.setVisibility(View.GONE);
                    mainRecyclerView.setVisibility(View.VISIBLE);
                    swipeRefresh.setRefreshing(false);
                }
            }
        });
        mainViewModel.getShowEmpty().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    noDataView.setVisibility(View.VISIBLE);
                    mainRecyclerView.setVisibility(View.GONE);
                } else {
                    noDataView.setVisibility(View.GONE);
                    mainRecyclerView.setVisibility(View.VISIBLE);
                }


            }
        });

    }
}
