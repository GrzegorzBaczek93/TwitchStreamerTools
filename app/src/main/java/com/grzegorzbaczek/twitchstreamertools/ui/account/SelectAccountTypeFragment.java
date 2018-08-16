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

    Button twitterButton;
    Button twitchButton;
    Button facebookButton;

    public SelectAccountTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_select_account_type, container, false);

        setupButtons(rootView);
        setupListeners();

        return rootView;
    }

    private void setupListeners() {
        twitterButton.setOnClickListener(view -> openAddAccountView(0));
        twitchButton.setOnClickListener(view -> openAddAccountView(1));
        facebookButton.setOnClickListener(view -> openAddAccountView(2));
    }

    private void setupButtons(View rootView) {
        twitterButton = rootView.findViewById(R.id.SignInTwitterButton);
        twitchButton = rootView.findViewById(R.id.SignInTwitchButton);
        facebookButton = rootView.findViewById(R.id.SignInFacebookButton);
    }

    private void openAddAccountView(int type) {
        SelectAccountTypeFragmentDirections.ActionSelectAccountTypeFragmentToAddAccountFragment action = SelectAccountTypeFragmentDirections.actionSelectAccountTypeFragmentToAddAccountFragment();
        action.setAccountType(type);
        Navigation.findNavController(getView()).navigate(action);
    }
}
