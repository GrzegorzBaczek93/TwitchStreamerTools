package com.grzegorzbaczek.twitchstreamertools.data.repository;

import com.grzegorzbaczek.twitchstreamertools.Application;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaDatabase;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;
import com.grzegorzbaczek.twitchstreamertools.rx.MyPublishSubject;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SocialMediaRepository implements DataRepository {

    @Inject
    SocialMediaDatabase database;

    private MyPublishSubject<List<SocialMediaEntry>> listSubject;

    public SocialMediaRepository() {
        Application.applicationComponent.inject(this);
        setupSubject();
    }

    private void setupSubject() {
        listSubject = new MyPublishSubject<List<SocialMediaEntry>>() {
            @Override
            public void onSubscribeHandler() {
                loadItems();
            }
        };
    }

    @Override
    public MyPublishSubject<List<SocialMediaEntry>> getListSubject() {
        return listSubject;
    }

    private void loadItems() {
        Single<List<SocialMediaEntry>> single = database.socialMediaDao().getItems();
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        list -> listSubject.onNext(list),
                        throwable -> listSubject.onError(throwable)
                );
    }
}
