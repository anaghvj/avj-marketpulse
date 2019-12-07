package com.avjlabs.marketpulsedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.avjlabs.marketpulsedemo.models.AnalyticalData;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    RecyclerView mainRecyclerView;
    LinearLayout noDataView;
    LinearLayout loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  Debug.waitForDebugger();
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainRecyclerView = findViewById(R.id.recyclerViewMain);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(mainViewModel.getAdapter());
        noDataView = findViewById(R.id.noDataView);
        loadingView = findViewById(R.id.loadingView);
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
                } else {
                    loadingView.setVisibility(View.GONE);
                    mainRecyclerView.setVisibility(View.VISIBLE);
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
