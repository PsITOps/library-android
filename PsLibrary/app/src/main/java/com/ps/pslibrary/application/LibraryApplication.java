package com.ps.pslibrary.application;

import android.support.multidex.MultiDexApplication;

import com.ps.pslibrary.Injector;
import com.ps.pslibrary.UIDependencies;

public class LibraryApplication extends MultiDexApplication {

    private Injector injector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDaggerDependencies();
    }

    protected void initializeDaggerDependencies() {
        injector = createInjector();
        injector.uiDependencies.inject(this);
    }

    protected Injector createInjector() {
        return new Injector(this);
    }

    public UIDependencies getUIDependencies() {
        return injector.uiDependencies;
    }
}
