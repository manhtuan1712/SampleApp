package com.example.manhtuan.sampleapp.data.module;

import com.example.manhtuan.sampleapp.View.MainActivityView;
import com.example.manhtuan.sampleapp.data.SampleAppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    private MainActivityView.View view;

    public BaseActivityModule(MainActivityView.View view) {
        this.view = view;
    }

    @Provides
    @SampleAppScope
    MainActivityView.View providesMainActivityView() {
        return view;
    }
}
