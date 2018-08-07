package com.example.manhtuan.sampleapp.View;

import com.example.manhtuan.sampleapp.data.base.BasePresenter;
import com.example.manhtuan.sampleapp.data.base.BaseView;
import com.example.manhtuan.sampleapp.model.Result;

import java.util.List;

public interface RestaurantFragmentView {

    interface View extends BaseView {
        void showRestaurant(List<Result> resultList, String nextPageToken);
    }

    interface Presenter extends BasePresenter {
        void loadRestaurant(String pageToken);
    }
}
