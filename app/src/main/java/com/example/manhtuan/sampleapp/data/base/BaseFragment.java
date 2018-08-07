package com.example.manhtuan.sampleapp.data.base;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public abstract BasePresenter getPresenter();

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().pause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().destroy();
        }
    }



}
