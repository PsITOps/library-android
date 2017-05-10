package com.ps.pslibrary.injectionmodules;

import com.ps.pslibrary.application.ApplicationScheduler;
import com.ps.pslibrary.navigator.Navigator;

import dagger.Module;
import dagger.Provides;
import pslibrary.api.login.LoginApi;
import pslibrary.api.signup.SignUpApi;
import pslibrary.loginactivity.LoginPresenter;
import pslibrary.registeractivity.RegisterPresenter;

@Module
public class PresenterModule {

    public PresenterModule() {
    }

    @Provides
    public LoginPresenter providesLoginPresenter(LoginApi loginApi,
                                                 Navigator navigator,
                                                 ApplicationScheduler applicationScheduler) {
        return new LoginPresenter(loginApi, navigator, applicationScheduler);
    }

    @Provides
    public RegisterPresenter providesRegisterPresenter(SignUpApi signUpApi,
                                                       ApplicationScheduler applicationScheduler) {
        return new RegisterPresenter(signUpApi, applicationScheduler);
    }
}
