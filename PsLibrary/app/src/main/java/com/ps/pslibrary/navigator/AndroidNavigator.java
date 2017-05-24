package com.ps.pslibrary.navigator;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import pslibrary.booksactivity.BooksActivity;
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
}
