package com.grzegorzbaczek.twitchstreamertools.data.repository;

import com.grzegorzbaczek.twitchstreamertools.Application;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaDatabase;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class SocialMediaRepository implements DataRepository {

    @Inject
    SocialMediaDatabase database;

    private BehaviorSubject<List<SocialMediaEntry>> listBehaviorSubject = BehaviorSubject.create();

    public SocialMediaRepository() {
        Application.applicationComponent.inject(this);
        loadItems();
    }

    @Override
    public BehaviorSubject<List<SocialMediaEntry>> getSubject() {
        return listBehaviorSubject;
    }

    @Override
    public SocialMediaEntry loadItem(int id) {
        return null;
    }

    @Override
    public void saveItem(SocialMediaEntry entry) {
        Completable.fromAction(() -> database.socialMediaDao().saveItem(entry))
                .subscribeOn(Schedulers.io())
                .subscribe(() -> loadItems());
    }

    @Override
    public int removeItem(int id) {
        return 0;
    }

    private void loadItems() {
        Single<List<SocialMediaEntry>> single = database.socialMediaDao().getItems();
        single.subscribeOn(Schedulers.io())
                .subscribe(list -> listBehaviorSubject.onNext(list),
                        throwable -> listBehaviorSubject.onError(throwable));

    }
}
