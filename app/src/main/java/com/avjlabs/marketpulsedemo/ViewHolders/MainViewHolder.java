package com.avjlabs.marketpulsedemo.ViewHolders;

import android.widget.TextView;

import com.avjlabs.marketpulsedemo.BR;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;


public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView textViewHead;
    TextView textViewSubHead;
    ViewDataBinding binding;

    public MainViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(ViewModel viewModel, Integer position) {
        binding.setVariable(com.avjlabs.marketpulsedemo.BR.viewModel, viewModel);
        binding.setVariable(BR.position, position);
        binding.executePendingBindings();
    }
}
