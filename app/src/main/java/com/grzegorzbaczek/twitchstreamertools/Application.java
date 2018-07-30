package com.grzegorzbaczek.twitchstreamertools;

import android.support.multidex.MultiDexApplication;

import com.grzegorzbaczek.twitchstreamertools.dagger.ApplicationComponent;
import com.grzegorzbaczek.twitchstreamertools.dagger.ApplicationModule;
import com.grzegorzbaczek.twitchstreamertools.dagger.DaggerApplicationComponent;

public class Application extends MultiDexApplication {

    public static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
