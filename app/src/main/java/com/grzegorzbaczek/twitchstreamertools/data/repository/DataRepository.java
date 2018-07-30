package com.grzegorzbaczek.twitchstreamertools.data.repository;

import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import java.util.List;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

public interface DataRepository {

   BehaviorSubject<List<SocialMediaEntry>> getSubject();
   SocialMediaEntry loadItem(int id);
   void saveItem(SocialMediaEntry entry);
   int removeItem(int id);
}
