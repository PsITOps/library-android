package com.ps.pslibrary.injectionmodules;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.ps.pslibrary.BuildConfig;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class NetworkModule {

    public NetworkModule() {
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            return new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
        } else {
            return new OkHttpClient.Builder().build();
        }
    }
}
