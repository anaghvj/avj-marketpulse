package com.avjlabs.marketpulsedemo.Adapters;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avjlabs.marketpulsedemo.R;
import com.avjlabs.marketpulsedemo.models.Criteria;
import com.avjlabs.marketpulsedemo.models.CriteriaViewHolder;
import com.avjlabs.marketpulsedemo.models.PatternMatch;
import com.avjlabs.marketpulsedemo.models.Variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class CriteriaAdapter extends Adapter<CriteriaViewHolder> {

    Context context;
    ArrayList<Criteria> criteriaArrayList;
    ArrayList<ArrayList<String>> arrayListMappings;

    public CriteriaAdapter(
            Context context,
            ArrayList<Criteria> criteriaArrayList) {
        this.context = context;
        this.criteriaArrayList = criteriaArrayList;
    }

    @NonNull
    @Override
    public CriteriaViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_critera_data,
                null);
        return new CriteriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CriteriaViewHolder holder, int position) {
        holder.textViewData.setTag(position);
        int i = position;
     /*   Pattern pattern_updated = Pattern.compile("\\(([^)]+)\\)");
        ArrayList<PatternMatch> list_updated = new ArrayList<>();
        Matcher matcher_updated = pattern_updated.matcher(((TextView) view).getText());*/

        Pattern pattern_master = Pattern.compile("(\\$\\d+)");
        ArrayList<String> list_master = new ArrayList<>();
        Matcher matcher_master = pattern_master.matcher(criteriaArrayList.get(i).getText());
        while (matcher_master.find()) {
            list_master.add(matcher_master.group());
        }
        arrayListMappings.add(list_master);

        final SpannableStringBuilder spanText = new SpannableStringBuilder();
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
                    spanText.append("(" + entry.getValue().getValues().get(0) +
                            ")");
                    spanText.setSpan(new ClickableSpan() {
                                         @Override
                                         public void onClick(@NonNull View view) {
                                             //to click
                                             processData(view);
                                         }

                                         @Override
                                         public void updateDrawState(@NonNull TextPaint textPaint) {
                                             super.updateDrawState(textPaint);
                                             textPaint.setColor(textPaint.linkColor);
                                             textPaint.setUnderlineText(false);
                                         }
                                     },
                            spanText.length() - String.valueOf(
                                    entry.getValue().getValues().get(0)).length() - 2,
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
                    spanText.append("(" + entry.getValue().getDefault_value() +
                            ")");
                    spanText.setSpan(new ClickableSpan() {
                                         @Override
                                         public void onClick(@NonNull View view) {
                                             processData(view);
                                         }

                                         @Override
                                         public void updateDrawState(@NonNull TextPaint textPaint) {
                                             super.updateDrawState(textPaint);
                                             textPaint.setColor(textPaint.linkColor);
                                             textPaint.setUnderlineText(false);
                                         }
                                     },
                            spanText.length() - String.valueOf(
                                    entry.getValue().getDefault_value()).length() - 2,
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
        holder.textViewData.setMovementMethod(LinkMovementMethod.getInstance());
        holder.textViewData.setText(spanText, TextView.BufferType.SPANNABLE);
    }


    @Override
    public int getItemCount() {
        return criteriaArrayList.size();
    }

    public void showValueDialog(ArrayList<Double> values) {

    }

    public void showIndicatorDialog(
            String study_type,
            double default_value,
            String parameter_name, double min_value, double max_value) {

    }

    public void processData(View view) {
        int isn = (int) view.getTag();
        Spanned spanned = (Spanned) ((TextView) view).getText();
        int spanStartIndex = spanned.getSpanStart(this);
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
        ArrayList<PatternMatch> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(((TextView) view).getText());
        int posAt = 0;
        while (matcher.find()) {
            PatternMatch patternMatch = new PatternMatch();
            patternMatch.setText(matcher.group());
            patternMatch.setStart(matcher.start());
            patternMatch.setEnd(matcher.end());
            list.add(patternMatch);
            if (spanStartIndex == matcher.start()) {
                posAt = list.size() - 1;
            }

        }
        String variable = arrayListMappings.get(isn).get(posAt);

        criteriaArrayList.get(isn).getVariable().get(variable).getType();
        switch (criteriaArrayList.get(isn)
                .getVariable()
                .get(variable)
                .getType()) {
            case "value":
                showValueDialog(criteriaArrayList.get(isn)
                        .getVariable()
                        .get(variable)
                        .getValues());
                break;
            case "indicator":
                Variable variableObj =
                        criteriaArrayList.get(isn).getVariable().get(variable);
                showIndicatorDialog(variableObj.getStudy_type(),
                        variableObj.getDefault_value(),
                        variableObj.getParameter_name(),
                        variableObj.getMin_value(),
                        variableObj.getMax_value()
                );
                break;
        }

    }
}
