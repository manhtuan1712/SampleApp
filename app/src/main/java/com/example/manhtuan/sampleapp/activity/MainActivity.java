package com.example.manhtuan.sampleapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manhtuan.sampleapp.R;
import com.example.manhtuan.sampleapp.fragment.RestaurantFragment;
import com.example.manhtuan.sampleapp.util.CommonUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CommonUtil.replaceFragmentToActivity(getSupportFragmentManager(),
                RestaurantFragment.newInstance(), R.id.frmContainer, RestaurantFragment.TAG);
    }
}
