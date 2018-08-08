package com.grzegorzbaczek.twitchstreamertools.ui.account;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grzegorzbaczek.twitchstreamertools.R;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;
import com.grzegorzbaczek.twitchstreamertools.databinding.FragmentAddAccountBinding;

import androidx.navigation.Navigation;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddAccountFragment extends Fragment {

    private AddAccountViewModel viewModel;
    private FragmentAddAccountBinding fragmentBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupBinding(inflater, container);
        setupConnectButtonListener();

        return fragmentBinding.getRoot();
    }

    private void setupBinding(LayoutInflater inflater, ViewGroup container) {
        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_account, container, false);
        viewModel = ViewModelProviders.of(this).get(AddAccountViewModel.class);
        fragmentBinding.setViewModel(viewModel);
    }

    private void setupConnectButtonListener() {
        fragmentBinding.connectButton.setOnClickListener(this::insertItem);
    }

    private void insertItem(View view) {
        viewModel.insertSocialMediaItem(new SocialMediaEntry())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Navigation.findNavController(view).popBackStack(R.id.listFragment, false);
                        //TODO: Obsluga bledow, nawigacja postepu, dokonczenie odpowiedniego flow apki
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
