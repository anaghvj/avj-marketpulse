package com.avjlabs.marketpulsedemo;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.avjlabs.marketpulsedemo.models.Criteria;
import com.avjlabs.marketpulsedemo.models.Variable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Gson gson = new Gson();
        Type dataType = new TypeToken<ArrayList<Criteria>>() { }.getType();
        ArrayList<Criteria> criteriaArrayList = gson.fromJson(getIntent().getStringExtra("data"),
                dataType);

        SpannableStringBuilder spanText = new SpannableStringBuilder();

        for (int i = 0; i < criteriaArrayList.size(); i++) {
            if (criteriaArrayList.get(i).getType().equals("plain_text")) {
                if (criteriaArrayList.get(i) != null) {

                    spanText.append(criteriaArrayList.get(i).getText());
                }

            } else if (criteriaArrayList.get(i).getType().equals("variable")) {

                HashMap<String, Variable> hashMap = criteriaArrayList.get(i).getVariable();
                int varCount = 0;
                String str = criteriaArrayList.get(i).getText();

                for (Map.Entry<String, Variable> entry : hashMap.entrySet()) {
                    String[] strAray = str.split("(\\" + entry.getKey() + ")");
                    Log.i("split", Arrays.toString(strAray));
                    if (entry.getValue().getType().equals("value")) {

                        spanText.append(strAray[0]);
                        spanText.append(String.valueOf(entry.getValue().getValues().get(0)));
                        spanText.setSpan(new ClickableSpan() {
                                             @Override
                                             public void onClick(@NonNull View view) {
                                                 //to click

                                             }

                                             @Override
                                             public void updateDrawState(@NonNull TextPaint textPaint) {
                                                 super.updateDrawState(textPaint);
                                                 textPaint.setColor(textPaint.linkColor);
                                                 textPaint.setUnderlineText(true);
                                             }
                                         },
                                spanText.length() - String.valueOf(
                                        entry.getValue().getValues().get(0)).length(),
                                spanText.length(), 0);
                        varCount++;
                        if (strAray.length > 1) {
                            str = strAray[1];
                            if (varCount == hashMap.size()) {
                                spanText.append(strAray[1]);
                            }

                        }

                    } else if (entry.getValue().getType().equals("indicator")) {

                        spanText.append(strAray[0]);
                        spanText.append(String.valueOf(entry.getValue().getDefault_value()));
                        spanText.setSpan(new ClickableSpan() {
                                             @Override
                                             public void onClick(@NonNull View view) {
                                                 //to click
                                             }

                                             @Override
                                             public void updateDrawState(@NonNull TextPaint textPaint) {
                                                 super.updateDrawState(textPaint);
                                                 textPaint.setColor(textPaint.linkColor);
                                                 textPaint.setUnderlineText(true);
                                             }
                                         },
                                spanText.length() - String.valueOf(
                                        entry.getValue().getDefault_value()).length(),
                                spanText.length(), 0);

                        varCount++;
                        if (strAray.length > 1) {
                            str = strAray[1];
                            if (varCount == hashMap.size()) {
                                spanText.append(strAray[1]);
                            }

                        }
                    }
                }
            }
            if (i < (criteriaArrayList.size() - 1)) {

                spanText.append("\n\n\t\tand\n\n");
            }
        }
        TextView textViewCriteria = findViewById(R.id.textViewCriteria);
        textViewCriteria.setMovementMethod(LinkMovementMethod.getInstance());
        textViewCriteria.setText(spanText, TextView.BufferType.SPANNABLE);

    }
}
