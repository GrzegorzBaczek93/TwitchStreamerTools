package com.grzegorzbaczek.twitchstreamertools.ui.list;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.grzegorzbaczek.twitchstreamertools.R;
import com.grzegorzbaczek.twitchstreamertools.data.adapter.SocialMediaAdapter;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;
import com.grzegorzbaczek.twitchstreamertools.databinding.FragmentListBinding;

import java.util.List;

import androidx.navigation.Navigation;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListFragment extends Fragment {

    private ListViewModel viewModel;
    private FragmentListBinding fragmentBinding;
    private SocialMediaAdapter dataAdapter;

    private Disposable listDisposable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupBinding(inflater, container);
        setupOverlayListener();
        setupAdapter();

        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.list_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_account_item) {
            openAddAccountView(getView());
            return true;
        }

        return false;
    }

    private void setupBinding(LayoutInflater inflater, ViewGroup container) {
        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        fragmentBinding.setViewModel(viewModel);
    }

    private void setupOverlayListener() {
        fragmentBinding.emptyListOverlay.setOnClickListener(this::openAddAccountView);
    }

    private void openAddAccountView(View view) {
        Navigation.findNavController(view).navigate(R.id.action_listFragment_to_selectAccountTypeFragment);
    }

    private void setupAdapter() {
        dataAdapter = new SocialMediaAdapter(R.layout.social_media_list_row);
        dataAdapter.setOnItemClickListener(this::removeItem);
        LinearLayoutManager ll = new LinearLayoutManager(getContext());
        DividerItemDecoration decoration = new DividerItemDecoration(fragmentBinding.socialMediaRecyclerView.getContext(), ll.getOrientation());
        fragmentBinding.socialMediaRecyclerView.addItemDecoration(decoration);
        fragmentBinding.socialMediaRecyclerView.setLayoutManager(ll);
        fragmentBinding.socialMediaRecyclerView.setAdapter(dataAdapter);
    }

    private void removeItem(int itemId) {
        viewModel.removeSocialMediaItem(itemId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    private void swapData(List<SocialMediaEntry> entryList) {
        if (entryList.isEmpty()) {
            setListOverlayVisible(true);

        } else {
            setListOverlayVisible(false);
            dataAdapter.setData(entryList);
        }
    }

    private void setListOverlayVisible(boolean visible) {
        fragmentBinding.emptyListOverlay.setVisibility(visible ? View.VISIBLE : View.GONE );
        fragmentBinding.socialMediaRecyclerView.setVisibility(visible ? View.GONE : View.VISIBLE);
    }

    private void subscribeToData() {
        listDisposable = viewModel.getSocialMediaList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::swapData);
    }

    private void unsubscribeFromData() {
        if (!listDisposable.isDisposed()) {
            listDisposable.dispose();
        }
    }
}
