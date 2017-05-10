package com.ps.pslibrary.injectionmodules;

import com.ps.pslibrary.application.LibraryApplication;
import com.ps.pslibrary.navigator.AndroidNavigator;
import com.ps.pslibrary.navigator.Navigator;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private LibraryApplication application;

    public AppModule(LibraryApplication application) {
        this.application = application;
    }

    @Provides
    Navigator provideNavigator() {
        return new AndroidNavigator(application);
    }
}
