package com.avjlabs.marketpulsedemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.avjlabs.marketpulsedemo.models.Criteria;
import com.avjlabs.marketpulsedemo.models.Variable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        StringBuilder stringBuilder = new StringBuilder();
        Gson gson = new Gson();
        Type dataType = new TypeToken<ArrayList<Criteria>>() { }.getType();
        ArrayList<Criteria> criteriaArrayList = gson.fromJson(getIntent().getStringExtra("data"),
                dataType);
        Log.i("intent", "size : " + criteriaArrayList.size());
        for (int i = 0; i < criteriaArrayList.size(); i++) {
            if (criteriaArrayList.get(i).getType().equals("plain_text")) {
                if (criteriaArrayList.get(i) != null) {
                    stringBuilder.append(criteriaArrayList.get(i).getText());
                }

            } else if (criteriaArrayList.get(i).getType().equals("variable")) {
                // stringBuilder.append(criteriaArrayList.get(i).getText());
                HashMap<String, Variable> hashMap = criteriaArrayList.get(i).getVariable();
                int num = hashMap.size();
                String str = criteriaArrayList.get(i).getText();
                for (Map.Entry<String, Variable> entry : hashMap.entrySet()) {
                    if (entry.getValue().getType().equals("value")) {
                        str = str.replace(entry.getKey(),
                                String.valueOf(entry.getValue().getValues().get(0)));
                        /*stringBuilder.append(
                                criteriaArrayList.get(i).getText().replace(
                                        "\\" + entry.getKey(),
                                        String.valueOf(entry.getValue().getValues().get(0))
                                )
                        );*/
                    } else if (entry.getValue().getType().equals("indicator")) {
                        str = str.replace(entry.getKey(),
                                String.valueOf(entry.getValue().getDefault_value()));
                       /* stringBuilder.append(
                                criteriaArrayList.get(i).getText().replaceAll(
                                        "\\" + entry.getKey(),
                                        String.valueOf(entry.getValue().getDefault_value())
                                )
                        );*/
                    }

                }
                stringBuilder.append(str);

            }
            if (i < (criteriaArrayList.size() - 1)) {
                stringBuilder.append("\n\n\t\tand\n\n");
            }
        }
        TextView textViewCriteria = findViewById(R.id.textViewCriteria);
        textViewCriteria.setText(stringBuilder.toString());

    }
}
