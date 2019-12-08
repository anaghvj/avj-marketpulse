package com.avjlabs.marketpulsedemo.models;

import android.view.View;
import android.widget.TextView;

import com.avjlabs.marketpulsedemo.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CriteriaViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewData;

    public CriteriaViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewData = itemView.findViewById(R.id.textViewData);
    }
}
