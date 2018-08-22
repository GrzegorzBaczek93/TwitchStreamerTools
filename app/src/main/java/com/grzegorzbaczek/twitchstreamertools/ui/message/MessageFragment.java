package com.grzegorzbaczek.twitchstreamertools.ui.message;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.grzegorzbaczek.twitchstreamertools.R;
import com.grzegorzbaczek.twitchstreamertools.databinding.FragmentMessageBinding;

import static android.app.Activity.RESULT_OK;

public class MessageFragment extends Fragment {

    private static final int FILE_REQUEST_CODE = 1;
    public static final String MESSAGE_TEXT_KEY = "message_text_key";
    public static final String SHARED_PREFERENCES_NAME = "shared_preferences";

    private MessageViewModel viewModel;
    private FragmentMessageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupBinding(inflater,container);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences prefs = getActivity().getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        binding.messageTextView.setText(prefs.getString(MESSAGE_TEXT_KEY, ""));
    }

    @Override
    public void onStop() {
        SharedPreferences.Editor prefs = getActivity().getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        prefs.putString(MESSAGE_TEXT_KEY, binding.messageTextView.getText().toString());
        prefs.apply();
        super.onStop();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.message_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.send_message_item:
                    displaySendItemAlertDialog();
                return true;
            case R.id.attach_file_item:
                    startActivityForFile();
                return true;
        }
        return false;
    }

    private void displaySendItemAlertDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this.getContext())
                .setTitle(R.string.send_item_dialog_title)
                .setMessage(R.string.send_item_dialog_message)
                .setPositiveButton(R.string.dialog_confirm_label, (dialogInterface, i) -> {
                    //TODO: Zaimplementować wysyłanie wiadomości
                })
                .setNegativeButton(R.string.dialog_cancel_label, (dialogInterface, i) -> dialogInterface.dismiss())
                .create();

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private void setupBinding(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false);
        viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        binding.setViewModel(viewModel);
    }

    private void startActivityForFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, FILE_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            viewModel.imageData.set(data.getData());
        }
    }
}
