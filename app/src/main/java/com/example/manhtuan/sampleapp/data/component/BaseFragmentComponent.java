package com.example.manhtuan.sampleapp.data.component;

import com.example.manhtuan.sampleapp.data.SampleAppScope;
import com.example.manhtuan.sampleapp.data.module.BaseFragmentModule;
import com.example.manhtuan.sampleapp.fragment.RestaurantFragment;

import dagger.Component;

@SampleAppScope
@Component(dependencies = NetComponent.class, modules = BaseFragmentModule.class)
public interface BaseFragmentComponent {
    void inject(RestaurantFragment restaurantFragment);
}
