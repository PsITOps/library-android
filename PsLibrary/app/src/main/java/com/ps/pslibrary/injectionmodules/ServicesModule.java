package com.ps.pslibrary.injectionmodules;

import com.ps.pslibrary.application.LibraryApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import pslibrary.api.signup.SignUpApi;
import pslibrary.api.signup.SignUpBackendApi;
import pslibrary.api.signup.service.SignUpService;
import pslibrary.api.signup.service.SignUpServiceFeed;

@Module
public class ServicesModule {

    private LibraryApplication application;

    public ServicesModule(LibraryApplication application) {
        this.application = application;
    }

    //Sign up components

    @Provides
    @Singleton
    public SignUpBackendApi providesSignUpBackendApi(OkHttpClient client) {
        return new SignUpServiceFeed(client);
    }

    @Provides
    @Singleton
    public SignUpApi provideSignUpService(SignUpBackendApi signUpBackendApi) {
        return new SignUpService(signUpBackendApi);
    }
}
