package com.ps.pslibrary;

import com.ps.pslibrary.application.LibraryApplication;
import com.ps.pslibrary.injectionmodules.AppModule;
import com.ps.pslibrary.injectionmodules.NetworkModule;
import com.ps.pslibrary.injectionmodules.PresenterModule;
import com.ps.pslibrary.injectionmodules.ServicesModule;
import com.ps.pslibrary.injectionmodules.UserModule;

import javax.inject.Singleton;

import dagger.Component;
import pslibrary.addbookactivity.AddBookActivity;
import pslibrary.bookinformationactivity.BookInformationActivity;
import pslibrary.booksactivity.BooksActivity;
import pslibrary.mybooksactivity.MyBooksActivity;
import pslibrary.registeractivity.RegisterActivity;

@Singleton
@Component(modules = {
        NetworkModule.class,
        AppModule.class,
        ServicesModule.class,
        PresenterModule.class,
        UserModule.class
})
public interface UIDependencies {

    void inject(LibraryApplication application);

    void inject(LoginActivity activity);

    void inject(RegisterActivity activity);

    void inject(BooksActivity activity);

    void inject(MyBooksActivity activity);

    void inject(BookInformationActivity activity);

    void inject(AddBookActivity activity);
}
