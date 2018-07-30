package com.grzegorzbaczek.twitchstreamertools.dagger;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.grzegorzbaczek.twitchstreamertools.data.repository.DataRepository;
import com.grzegorzbaczek.twitchstreamertools.data.repository.SocialMediaRepository;
import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public DataRepository provideDataRepository() {
        return new SocialMediaRepository();
    }

    @Provides
    @Singleton
    public SocialMediaDatabase provideSocialMediaDatabase() {
        return Room.databaseBuilder(context.getApplicationContext(), SocialMediaDatabase.class, "SocialMediaDatabase.db").build();
    }
}
