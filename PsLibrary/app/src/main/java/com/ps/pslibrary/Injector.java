package com.ps.pslibrary;

import com.ps.pslibrary.application.LibraryApplication;
import com.ps.pslibrary.injectionmodules.AppModule;
import com.ps.pslibrary.injectionmodules.NetworkModule;
import com.ps.pslibrary.injectionmodules.PresenterModule;
import com.ps.pslibrary.injectionmodules.ServicesModule;
import com.ps.pslibrary.injectionmodules.UserModule;

@SuppressWarnings({"deprecation"})
public class Injector {

    public UIDependencies uiDependencies;

    public Injector(LibraryApplication application) {
        getUIDependencies(application);
    }

    private void getUIDependencies(LibraryApplication application) {
        uiDependencies = DaggerUIDependencies.builder()
                .appModule(new AppModule(application))
                .servicesModule(new ServicesModule(application))
                .networkModule(new NetworkModule())
                .presenterModule(new PresenterModule())
                .userModule(new UserModule())
                .build();
    }
}
