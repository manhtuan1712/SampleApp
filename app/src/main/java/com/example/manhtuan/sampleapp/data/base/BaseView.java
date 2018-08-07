package com.example.manhtuan.sampleapp.data.base;

public interface BaseView {

    void showLoading();

    void showLoading(String message);

    void hideLoading();

    void showErrorMessage(String message);

    void showMessage(String message);
}
