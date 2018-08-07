package com.example.manhtuan.sampleapp.data.component;

import android.app.Application;

import com.example.manhtuan.sampleapp.data.NetworkScope;
import com.example.manhtuan.sampleapp.data.module.AppModule;
import com.example.manhtuan.sampleapp.data.module.NetModule;
import com.example.manhtuan.sampleapp.net.ApiService;

import dagger.Component;

@NetworkScope
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    ApiService getApiService();

    Application getApplication();
}
