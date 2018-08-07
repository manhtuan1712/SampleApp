package com.example.manhtuan.sampleapp.data.module;

import com.example.manhtuan.sampleapp.View.RestaurantFragmentView;
import com.example.manhtuan.sampleapp.data.SampleAppScope;
import com.example.manhtuan.sampleapp.data.base.BaseFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseFragmentModule {

    private RestaurantFragmentView.View view;

    public BaseFragmentModule(RestaurantFragmentView.View view) {
        this.view = view;
    }

    @Provides
    @SampleAppScope
    RestaurantFragmentView.View providesRestaurantFragmentView() {
        return view;
    }

}
