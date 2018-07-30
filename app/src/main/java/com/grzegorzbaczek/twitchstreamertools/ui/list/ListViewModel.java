package com.grzegorzbaczek.twitchstreamertools.ui.list;

import android.arch.lifecycle.ViewModel;

import com.grzegorzbaczek.twitchstreamertools.Application;
import com.grzegorzbaczek.twitchstreamertools.data.repository.DataRepository;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.subjects.BehaviorSubject;

public class ListViewModel extends ViewModel {

    @Inject
    DataRepository socialMediaRepository;

    public ListViewModel() {
        Application.applicationComponent.inject(this);
    }

    public BehaviorSubject<List<SocialMediaEntry>> getSubject() {
        return socialMediaRepository.getSubject();
    }
}
