package com.ps.pslibrary.injectionmodules;

import dagger.Module;
import dagger.Provides;
import pslibrary.api.login.LoginApi;
import pslibrary.loginactivity.LoginPresenter;

@Module
public class PresenterModule {

    public PresenterModule() {
    }

    @Provides
    public LoginPresenter providesLoginPresenter(LoginApi loginApi) {
        return new LoginPresenter(loginApi);
    }
}
