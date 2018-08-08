package com.grzegorzbaczek.twitchstreamertools.data.repository;

import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DataRepository {

   Single<List<SocialMediaEntry>> getSocialMediaList();

   Single<SocialMediaEntry> getSocialMediaItem(int socialMediaItemId);

   Completable insertSocialMediaItem(SocialMediaEntry socialMediaEntry);

   Completable removeSocialMediaItem(int socialMediaItemId);
}
