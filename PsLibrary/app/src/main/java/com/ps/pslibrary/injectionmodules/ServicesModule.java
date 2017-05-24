package com.ps.pslibrary.injectionmodules;

import com.ps.pslibrary.application.AndroidScheduler;
import com.ps.pslibrary.application.ApplicationScheduler;
import com.ps.pslibrary.application.LibraryApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import pslibrary.api.books.BooksApi;
import pslibrary.api.books.BooksBackendApi;
import pslibrary.api.books.service.BooksService;
import pslibrary.api.books.service.BooksServiceFeed;
import pslibrary.api.login.LoginApi;
import pslibrary.api.login.LoginBackendApi;
import pslibrary.api.login.service.LoginService;
import pslibrary.api.login.service.LoginServiceFeed;
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

    @Provides
    ApplicationScheduler providesApplicationScheduler() {
        return new AndroidScheduler(AndroidSchedulers.mainThread(), Schedulers.io());
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

    //Login components

    @Provides
    @Singleton
    public LoginBackendApi providesLoginBackendApi(OkHttpClient client) {
        return new LoginServiceFeed(client);
    }

    @Provides
    @Singleton
    public LoginApi providesLoginService(LoginBackendApi loginBackendApi) {
        return new LoginService(loginBackendApi);
    }

    // Books components

    @Provides
    @Singleton
    public BooksBackendApi providesBooksBackendApi(OkHttpClient client) {
        return new BooksServiceFeed(client);
    }

    @Provides
    @Singleton
    public BooksApi provideBooksService(BooksBackendApi booksBackendApi) {
        return new BooksService(booksBackendApi);
    }
}
