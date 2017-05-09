package com.ps.pslibrary.injectionmodules;

import com.ps.pslibrary.application.ApplicationScheduler;

import dagger.Module;
import dagger.Provides;
import pslibrary.api.login.LoginApi;
import pslibrary.loginactivity.LoginPresenter;

@Module
public class PresenterModule {

    public PresenterModule() {
    }

    @Provides
    public LoginPresenter providesLoginPresenter(LoginApi loginApi,
                                                 ApplicationScheduler applicationScheduler) {
        return new LoginPresenter(loginApi, applicationScheduler);
    }
}
