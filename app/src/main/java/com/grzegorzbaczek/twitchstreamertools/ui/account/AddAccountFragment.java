package com.grzegorzbaczek.twitchstreamertools.ui.account;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grzegorzbaczek.twitchstreamertools.R;
import com.grzegorzbaczek.twitchstreamertools.databinding.FragmentAddAccountBinding;

public class AddAccountFragment extends Fragment {

    private AddAccountViewModel viewModel;
    private FragmentAddAccountBinding fragmentBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupBinding(inflater, container);

        return inflater.inflate(R.layout.fragment_add_account, container, false);
    }

    private void setupBinding(LayoutInflater inflater, ViewGroup container) {
        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_account, container, false);
        viewModel = ViewModelProviders.of(this).get(AddAccountViewModel.class);
        fragmentBinding.setViewModel(viewModel);
    }

}
