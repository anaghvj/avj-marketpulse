package com.avjlabs.marketpulsedemo.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.avjlabs.marketpulsedemo.Adapters.CriteriaAdapter;
import com.avjlabs.marketpulsedemo.R;
import com.avjlabs.marketpulsedemo.models.Criteria;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView criteriaRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Gson gson = new Gson();
        Type dataType = new TypeToken<ArrayList<Criteria>>() { }.getType();
        ArrayList<Criteria> criteriaArrayList = gson.fromJson(getIntent().getStringExtra("data"),
                dataType);

       /* final SpannableStringBuilder spanText = new SpannableStringBuilder();

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
                        spanText.append("("+String.valueOf(entry.getValue().getValues().get(0))+
                                ")");
                        spanText.setSpan(new ClickableSpan() {
                                             @Override
                                             public void onClick(@NonNull View view) {
                                                 //to click


                                                 Toast.makeText(DetailsActivity.this, "variable",
                                                         Toast.LENGTH_SHORT).show();


                                             }


                                             @Override
                                             public void updateDrawState(@NonNull TextPaint textPaint) {
                                                 super.updateDrawState(textPaint);
                                                 textPaint.setColor(textPaint.linkColor);
                                                 textPaint.setUnderlineText(false);
                                             }
                                         },
                                spanText.length() - String.valueOf(
                                        entry.getValue().getValues().get(0)).length()-2,
                                spanText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        varCount++;
                        if (strAray.length > 1) {
                            str = strAray[1];
                            if (varCount == hashMap.size()) {
                                spanText.append(strAray[1]);
                            }

                        }

                    } else if (entry.getValue().getType().equals("indicator")) {

                        spanText.append(strAray[0]);
                        spanText.append("("+String.valueOf(entry.getValue().getDefault_value())+
                                ")");
                        spanText.setSpan(new ClickableSpan() {
                                             @Override
                                             public void onClick(@NonNull View view) {
                                                 //to click


                                                 Toast.makeText(DetailsActivity.this, "Indicator",
                                                         Toast.LENGTH_SHORT).show();
                                             }

                                             @Override
                                             public void updateDrawState(@NonNull TextPaint textPaint) {
                                                 super.updateDrawState(textPaint);
                                                 textPaint.setColor(textPaint.linkColor);
                                                 textPaint.setUnderlineText(false);
                                             }
                                         },
                                spanText.length() - String.valueOf(
                                        entry.getValue().getDefault_value()).length()-2,
                                spanText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

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
        textViewCriteria.setText(spanText, TextView.BufferType.SPANNABLE);*/
        TextView textViewCriteria = findViewById(R.id.textViewCriteria);
        textViewCriteria.setVisibility(View.GONE);
        criteriaRecyclerView = findViewById(R.id.criteriaRecyclerView);
        criteriaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        criteriaRecyclerView.setAdapter(new CriteriaAdapter(this, criteriaArrayList));

    }
}
