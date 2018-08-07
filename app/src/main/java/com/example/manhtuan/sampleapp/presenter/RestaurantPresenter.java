package com.example.manhtuan.sampleapp.presenter;

import android.app.Application;
import android.util.Log;

import com.example.manhtuan.sampleapp.View.RestaurantFragmentView;
import com.example.manhtuan.sampleapp.model.Response;
import com.example.manhtuan.sampleapp.net.ApiService;
import com.example.manhtuan.sampleapp.util.AppConstants;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RestaurantPresenter implements RestaurantFragmentView.Presenter {

    private static final String TAG = RestaurantPresenter.class.getSimpleName();

    RestaurantFragmentView.View view;

    private Application application;

    private ApiService apiService;

    @Inject
    public RestaurantPresenter(Application application, ApiService apiService, RestaurantFragmentView.View view) {
        this.apiService = apiService;
        this.application = application;
        this.view = view;
    }

    @Override
    public void loadRestaurant(String pageToken) {
        view.showLoading();

        apiService.getRestaurant(AppConstants.LOCATION, AppConstants.RADIUS, AppConstants.TYPE, AppConstants.KEY, pageToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response response) {
                        if (response.getStatus().equalsIgnoreCase("OK")) {
                            view.showRestaurant(response.getResultList(), response.getNextPageToken());
                        } else {
                            view.showErrorMessage(response.getErrorMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showErrorMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.hideLoading();
                    }
                });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
