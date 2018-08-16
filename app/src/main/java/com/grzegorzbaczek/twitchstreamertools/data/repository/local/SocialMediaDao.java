package com.grzegorzbaczek.twitchstreamertools.data.repository.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface SocialMediaDao {

    @Query("SELECT * FROM socialMediaItems")
    Flowable<List<SocialMediaEntry>> getItems();

    @Query("SELECT * FROM socialMediaItems WHERE id = :id")
    Single<SocialMediaEntry> getItemById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveItem(SocialMediaEntry socialMediaEntry);

    @Query("DELETE FROM socialMediaItems WHERE id = :id")
    int removeById(int id);
}
