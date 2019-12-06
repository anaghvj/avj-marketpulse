package com.avjlabs.marketpulsedemo;

import android.os.Bundle;
import android.os.Debug;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Debug.waitForDebugger();
        setContentView(R.layout.activity_main);
//        Gson gson = new Gson();
//
//        Type dataType =
//                new TypeToken<ArrayList<AnalyticalData>>(){}.getType();
//
//        ArrayList<AnalyticalData> amountCurrency =
//                gson.fromJson(Json, dataType);

    }
}
