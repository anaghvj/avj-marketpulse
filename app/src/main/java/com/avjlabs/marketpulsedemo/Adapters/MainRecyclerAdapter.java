package com.avjlabs.marketpulsedemo.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.avjlabs.marketpulsedemo.R;
import com.avjlabs.marketpulsedemo.ViewHolders.MainViewHolder;
import com.avjlabs.marketpulsedemo.models.AnalyticalData;
import com.avjlabs.marketpulsedemo.viewmodels.MainViewModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainViewHolder> {

    LiveData<ArrayList<AnalyticalData>> analyticalData;
    MainViewModel viewModel;

    public MainRecyclerAdapter(
            LiveData<ArrayList<AnalyticalData>> analyticalData,
            MainViewModel viewModel) {
        this.analyticalData = analyticalData;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        /*View view =
                layoutInflater.inflate(R.layout.item_analytical_data,
                        parent, false);*/
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_analytical_data, parent, false);
        MainViewHolder mainViewHolder = new MainViewHolder(binding);

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bind(viewModel, position);

    }

    @Override
    public int getItemCount() {
        return analyticalData.getValue() == null ? 0 : analyticalData.getValue().size();
    }


}
