package com.ps.pslibrary;

import com.ps.pslibrary.application.LibraryApplication;
import com.ps.pslibrary.injectionmodules.AppModule;
import com.ps.pslibrary.injectionmodules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,
        AppModule.class})
public interface UIDependencies {

    void inject(LibraryApplication application);

    void inject(LoginActivity activity);
}
