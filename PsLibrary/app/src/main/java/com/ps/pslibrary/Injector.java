package com.ps.pslibrary;

import com.ps.pslibrary.application.LibraryApplication;
import com.ps.pslibrary.injectionmodules.AppModule;
import com.ps.pslibrary.injectionmodules.NetworkModule;

public class Injector {

    public UIDependencies uiDependencies;

    public Injector(LibraryApplication application) {
        getUIDependencies(application);
    }

    private void getUIDependencies(LibraryApplication application) {
        uiDependencies = DaggerUIDependencies.builder()
//                .presentersModule(new PresentersModule())
                .appModule(new AppModule(application))
//                .convertersModule(new ConvertersModule())
                .networkModule(new NetworkModule())
                .build();
//                .servicesModule(new ServicesModule(application))
//                .build();
    }
}
