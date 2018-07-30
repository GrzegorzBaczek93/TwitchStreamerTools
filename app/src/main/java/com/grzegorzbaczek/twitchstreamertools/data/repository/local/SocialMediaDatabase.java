package com.grzegorzbaczek.twitchstreamertools.data.repository.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {SocialMediaEntry.class}, version = 1)
public abstract class SocialMediaDatabase extends RoomDatabase {

    public abstract SocialMediaDao socialMediaDao();
}
