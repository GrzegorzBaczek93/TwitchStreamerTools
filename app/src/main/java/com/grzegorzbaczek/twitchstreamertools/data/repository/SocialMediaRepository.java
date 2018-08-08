package com.grzegorzbaczek.twitchstreamertools.data.repository;

import com.grzegorzbaczek.twitchstreamertools.Application;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaDatabase;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class SocialMediaRepository implements DataRepository {

    @Inject
    SocialMediaDatabase database;

    public SocialMediaRepository() {
        Application.applicationComponent.inject(this);
    }

    @Override
    public Single<List<SocialMediaEntry>> getSocialMediaList() {
        return database.socialMediaDao().getItems();
    }

    @Override
    public Single<SocialMediaEntry> getSocialMediaItem(int socialMediaItemId) {
        return database.socialMediaDao().getItemById(socialMediaItemId);
    }

    @Override
    public Completable insertSocialMediaItem(SocialMediaEntry socialMediaEntry) {
        return Completable.fromAction(() ->
                database.socialMediaDao().saveItem(socialMediaEntry)
        );
    }

    @Override
    public Completable removeSocialMediaItem(int socialMediaItemId) {
        return Completable.fromAction(() ->
                database.socialMediaDao().removeById(socialMediaItemId)
        );
    }
}
