package com.example.manhtuan.sampleapp.data.module;

import android.app.Application;

import com.example.manhtuan.sampleapp.data.NetworkScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @NetworkScope
    Application provideApplication() {
        return application;
    }
}
