package com.example.manhtuan.sampleapp.data.component;

import com.example.manhtuan.sampleapp.activity.MainActivity;
import com.example.manhtuan.sampleapp.data.SampleAppScope;
import com.example.manhtuan.sampleapp.data.module.BaseActivityModule;

import dagger.Component;

@SampleAppScope
@Component(dependencies = NetComponent.class, modules = BaseActivityModule.class)
public interface BaseActivityComponent {

    void inject(MainActivity mainActivity);

}
