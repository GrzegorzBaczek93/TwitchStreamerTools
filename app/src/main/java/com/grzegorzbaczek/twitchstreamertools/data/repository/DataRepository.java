package com.grzegorzbaczek.twitchstreamertools.data.repository;

import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;
import com.grzegorzbaczek.twitchstreamertools.rx.MyPublishSubject;

import java.util.List;

public interface DataRepository {

   MyPublishSubject<List<SocialMediaEntry>> getListSubject();
}
