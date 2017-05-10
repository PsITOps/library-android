package com.ps.pslibrary.navigator;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

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
}
