package com.grzegorzbaczek.twitchstreamertools.ui.account;

import android.arch.lifecycle.ViewModel;

import com.grzegorzbaczek.twitchstreamertools.Application;
import com.grzegorzbaczek.twitchstreamertools.data.repository.DataRepository;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import javax.inject.Inject;

import io.reactivex.Completable;

public class AddAccountViewModel extends ViewModel {

    @Inject
    DataRepository socialMediaRepository;

    public AddAccountViewModel() {
        Application.applicationComponent.inject(this);
    }

    public Completable insertSocialMediaItem(SocialMediaEntry socialMediaEntry) {
        return socialMediaRepository.insertSocialMediaItem(socialMediaEntry);
    }
}
