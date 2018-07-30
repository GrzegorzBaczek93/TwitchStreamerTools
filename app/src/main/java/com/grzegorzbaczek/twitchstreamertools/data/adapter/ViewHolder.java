package com.grzegorzbaczek.twitchstreamertools.data.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.grzegorzbaczek.twitchstreamertools.BR;

import io.reactivex.annotations.NonNull;

public class ViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding dataBinding;

    public ViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.dataBinding = binding;
    }

    public void bind(@NonNull Object object) {
        dataBinding.setVariable(BR.dataObject, object);
        dataBinding.executePendingBindings();
    }
}
