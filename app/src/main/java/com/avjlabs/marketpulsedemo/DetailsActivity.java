package com.avjlabs.marketpulsedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.avjlabs.marketpulsedemo.models.Criteria;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();

        ArrayList<Criteria> criteriaArrayList = (ArrayList<Criteria>) getIntent().getSerializableExtra(
                "data");
        Log.i("intent", "size : " + criteriaArrayList.size());
    }
}
