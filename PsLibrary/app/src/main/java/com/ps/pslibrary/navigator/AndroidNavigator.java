package com.ps.pslibrary.navigator;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import pslibrary.addbookactivity.AddBookActivity;
import pslibrary.api.books.model.Book;
import pslibrary.bookinformationactivity.BookInformationActivity;
import pslibrary.booksactivity.BooksActivity;
import pslibrary.mybooksactivity.MyBooksActivity;
import pslibrary.registeractivity.RegisterActivity;

public class AndroidNavigator implements Navigator {

    private Application applicationContext;

    public AndroidNavigator(Application applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void openRegisterActivity(Context context) {
        Intent intent = RegisterActivity.createIntent(context);
        context.startActivity(intent);
    }

    @Override
    public void openBooksActivity(Context context) {
        Intent intent = BooksActivity.createIntent(context);
        context.startActivity(intent);
    }

    @Override
    public void openMyBooksActivity(Context context) {
        Intent intent = MyBooksActivity.createIntent(context);
        context.startActivity(intent);
    }

    @Override
    public void openBookInformationActivity(Context context, Book book, boolean isFromMyBooks) {
        Intent intent = BookInformationActivity.createIntent(context, book, isFromMyBooks);
        context.startActivity(intent);
    }

    @Override
    public void openAddBookActivity(Context context) {
        Intent intent = AddBookActivity.createIntent(context);
        context.startActivity(intent);
    }
}
