package com.grzegorzbaczek.twitchstreamertools.dagger;

import com.grzegorzbaczek.twitchstreamertools.data.repository.SocialMediaRepository;
import com.grzegorzbaczek.twitchstreamertools.ui.account.AddAccountViewModel;
import com.grzegorzbaczek.twitchstreamertools.ui.list.ListViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(SocialMediaRepository socialMediaRepository);

    void inject(ListViewModel listViewModel);
    void inject(AddAccountViewModel addAccountViewModel);
}
