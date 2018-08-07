package com.example.manhtuan.sampleapp;

import android.app.Application;

import com.example.manhtuan.sampleapp.data.component.DaggerNetComponent;
import com.example.manhtuan.sampleapp.data.component.NetComponent;
import com.example.manhtuan.sampleapp.data.module.AppModule;

public class SampleApplication extends Application {

    private static SampleApplication instance;

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public static SampleApplication getInstance() {
        return instance;
    }
}
