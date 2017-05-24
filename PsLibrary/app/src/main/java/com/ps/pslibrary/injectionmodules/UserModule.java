package com.ps.pslibrary.injectionmodules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pslibrary.user.UserProfileProvider;
import pslibrary.user.UserProvider;

@Module
public class UserModule {

    @Provides
    @Singleton
    UserProvider providesUserProfile() {
        return new UserProfileProvider();
    }
}
