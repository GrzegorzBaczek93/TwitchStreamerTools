package com.grzegorzbaczek.twitchstreamertools.ui.list;

import android.arch.lifecycle.ViewModel;

import com.grzegorzbaczek.twitchstreamertools.Application;
import com.grzegorzbaczek.twitchstreamertools.data.repository.DataRepository;
import com.grzegorzbaczek.twitchstreamertools.rx.MyPublishSubject;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import java.util.List;

import javax.inject.Inject;

public class ListViewModel extends ViewModel {

    @Inject
    DataRepository socialMediaRepository;

    public ListViewModel() {
        Application.applicationComponent.inject(this);
    }

    public MyPublishSubject<List<SocialMediaEntry>> getSubject() {
        return socialMediaRepository.getListSubject();
    }
}
