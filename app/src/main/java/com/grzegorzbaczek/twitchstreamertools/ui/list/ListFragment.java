package com.grzegorzbaczek.twitchstreamertools.ui.list;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grzegorzbaczek.twitchstreamertools.R;
import com.grzegorzbaczek.twitchstreamertools.data.adapter.SocialMediaAdapter;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;
import com.grzegorzbaczek.twitchstreamertools.databinding.FragmentListBinding;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ListFragment extends Fragment {

    public static final String TAG = "ListFragment";

    private ListViewModel viewModel;
    private FragmentListBinding fragmentBinding;
    private SocialMediaAdapter dataAdapter;

    private Disposable listDisposable;
    private Consumer<Throwable> errorConsumer;
    private Consumer<List<SocialMediaEntry>> dataConsumer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupBinding(inflater, container);
        setupAdapter();
        setupObserver();

        return fragmentBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        subscribeToData();
    }

    @Override
    public void onStop() {
        unsubscribeFromData();
        super.onStop();
    }

    private void setupBinding(LayoutInflater inflater, ViewGroup container) {
        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        fragmentBinding.setViewModel(viewModel);
    }

    private void setupAdapter() {
        dataAdapter = new SocialMediaAdapter(R.layout.social_media_list_row);
        fragmentBinding.socialMediaRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentBinding.socialMediaRecyclerView.setAdapter(dataAdapter);
    }

    private void setupObserver() {
        dataConsumer = this::swapData;
        errorConsumer = error -> Log.d(TAG, "Msg: " + error);
    }

    private void swapData(List<SocialMediaEntry> entryList) {
        dataAdapter.setData(entryList);
    }

    private void subscribeToData() {
        listDisposable = viewModel.getSubject()
                .subscribeOn(Schedulers.computation())
                .subscribe(dataConsumer, errorConsumer);
    }

    private void unsubscribeFromData() {
        if (!listDisposable.isDisposed()) {
            listDisposable.dispose();
        }
    }
}
