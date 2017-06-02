package com.ps.pslibrary.injectionmodules;

import com.ps.pslibrary.application.ApplicationScheduler;
import com.ps.pslibrary.navigator.Navigator;

import dagger.Module;
import dagger.Provides;
import pslibrary.addbookactivity.AddBookPresenter;
import pslibrary.api.books.BooksApi;
import pslibrary.api.login.LoginApi;
import pslibrary.api.signup.SignUpApi;
import pslibrary.bookinformationactivity.BookInformationPresenter;
import pslibrary.booksactivity.BooksPresenter;
import pslibrary.customview.DialogProvider;
import pslibrary.loginactivity.LoginPresenter;
import pslibrary.mybooksactivity.MyBooksPresenter;
import pslibrary.registeractivity.RegisterPresenter;
import pslibrary.user.UserProvider;

@Module
public class PresenterModule {

    public PresenterModule() {
    }

    @Provides
    public LoginPresenter providesLoginPresenter(LoginApi loginApi,
                                                 Navigator navigator,
                                                 ApplicationScheduler applicationScheduler,
                                                 DialogProvider dialogProvider,
                                                 UserProvider userProvider) {
        return new LoginPresenter(loginApi, navigator, applicationScheduler, dialogProvider, userProvider);
    }

    @Provides
    public RegisterPresenter providesRegisterPresenter(SignUpApi signUpApi,
                                                       ApplicationScheduler applicationScheduler,
                                                       DialogProvider dialogProvider) {
        return new RegisterPresenter(signUpApi, applicationScheduler, dialogProvider);
    }

    @Provides
    public BooksPresenter providesBooksPresenter(BooksApi booksApi,
                                                 Navigator navigator,
                                                 ApplicationScheduler applicationScheduler,
                                                 DialogProvider dialogProvider,
                                                 UserProvider userProvider) {
        return new BooksPresenter(booksApi, navigator, applicationScheduler, dialogProvider, userProvider);
    }

    @Provides
    public MyBooksPresenter providesMyBooksPresenter(BooksApi booksApi,
                                                     Navigator navigator,
                                                     ApplicationScheduler applicationScheduler,
                                                     DialogProvider dialogProvider,
                                                     UserProvider userProvider) {
        return new MyBooksPresenter(booksApi, navigator, applicationScheduler, dialogProvider, userProvider);
    }

    @Provides
    public BookInformationPresenter providesBookInformationPresenter(BooksApi booksApi,
                                                                     DialogProvider dialogProvider,
                                                                     ApplicationScheduler applicationScheduler,
                                                                     UserProvider userProvider) {
        return new BookInformationPresenter(booksApi, applicationScheduler, dialogProvider, userProvider);
    }

    @Provides
    public AddBookPresenter providesAddBookPresentet(BooksApi booksApi,
                                                     DialogProvider dialogProvider,
                                                     ApplicationScheduler applicationScheduler,
                                                     UserProvider userProvider) {
        return new AddBookPresenter(booksApi, applicationScheduler, dialogProvider, userProvider);
    }
}
