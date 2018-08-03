package com.grzegorzbaczek.twitchstreamertools.ui.message;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grzegorzbaczek.twitchstreamertools.R;
import com.grzegorzbaczek.twitchstreamertools.databinding.FragmentMessageBinding;

public class MessageFragment extends Fragment {

    private MessageViewModel viewModel;
    private FragmentMessageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       setupBinding(inflater, container);

        return binding.getRoot();
    }

    private void setupBinding(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false);
        viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        binding.setViewModel(viewModel);
    }

}
