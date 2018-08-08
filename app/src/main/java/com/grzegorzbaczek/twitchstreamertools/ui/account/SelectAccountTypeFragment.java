package com.grzegorzbaczek.twitchstreamertools.ui.account;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.grzegorzbaczek.twitchstreamertools.R;

import androidx.navigation.Navigation;

public class SelectAccountTypeFragment extends Fragment {


    public SelectAccountTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_select_account_type, container, false);

        Button button = rootView.findViewById(R.id.SignInTwitterButton);
        button.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_selectAccountTypeFragment_to_addAccountFragment);
        });

        return rootView;
    }

}
