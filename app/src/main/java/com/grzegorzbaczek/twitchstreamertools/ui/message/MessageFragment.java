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

    private static final String ITEM_ID = "itemId";

    private MessageViewModel viewModel;
    private FragmentMessageBinding binding;

    private int itemId;

    public static MessageFragment getInstance(int itemId) {
        MessageFragment fragment = new MessageFragment();

        Bundle args = new Bundle();
        args.putInt(ITEM_ID, itemId);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            itemId = getArguments().getInt(ITEM_ID);
        }

        setupBinding(inflater, container);

        return binding.getRoot();
    }

    private void setupBinding(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false);
        viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        binding.setViewModel(viewModel);
    }

}
