package com.ps.pslibrary.injectionmodules;

import com.ps.pslibrary.application.LibraryApplication;

import dagger.Module;

@Module
public class AppModule {

    private LibraryApplication application;

    public AppModule(LibraryApplication application) {
        this.application = application;
    }
}
