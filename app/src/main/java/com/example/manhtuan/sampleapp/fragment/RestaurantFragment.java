package com.example.manhtuan.sampleapp.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.manhtuan.sampleapp.R;
import com.example.manhtuan.sampleapp.SampleApplication;
import com.example.manhtuan.sampleapp.View.RestaurantFragmentView;
import com.example.manhtuan.sampleapp.adapter.RestaurantAdapter;
import com.example.manhtuan.sampleapp.custom.EndlessScrollListener;
import com.example.manhtuan.sampleapp.data.base.BaseFragment;
import com.example.manhtuan.sampleapp.data.base.BasePresenter;
import com.example.manhtuan.sampleapp.data.component.DaggerBaseFragmentComponent;
import com.example.manhtuan.sampleapp.data.module.BaseFragmentModule;
import com.example.manhtuan.sampleapp.model.Result;
import com.example.manhtuan.sampleapp.presenter.RestaurantPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RestaurantFragment extends BaseFragment implements RestaurantFragmentView.View {

    @BindView(R.id.rcvRestaurant)
    RecyclerView rcvRestaurant;

    public static final String TAG = RestaurantFragment.class.getSimpleName();

    private Unbinder unbinder;

    private ProgressDialog progressDialog;

    private EndlessScrollListener endlessScrollListener;

    private String pageToken = "";

    private List<Result> resultList = new ArrayList<>();

    private RestaurantAdapter restaurantAdapter;

    @Inject
    RestaurantPresenter restaurantPresenter;

    public static RestaurantFragment newInstance() {

        Bundle args = new Bundle();

        RestaurantFragment fragment = new RestaurantFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerBaseFragmentComponent.builder()
                .netComponent(SampleApplication.getInstance().getNetComponent())
                .baseFragmentModule(new BaseFragmentModule(this))
                .build().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvRestaurant.setLayoutManager(layoutManager);
        endlessScrollListener = new EndlessScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (pageToken == null) {
                    showErrorMessage("No page to load more");
                } else {
                    restaurantPresenter.loadRestaurant(pageToken);
                }
            }
        };
        rcvRestaurant.addOnScrollListener(endlessScrollListener);
        restaurantAdapter = new RestaurantAdapter(getContext(), resultList);
        rcvRestaurant.setAdapter(restaurantAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        restaurantPresenter.loadRestaurant(pageToken);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public BasePresenter getPresenter() {
        return restaurantPresenter;
    }

    @Override
    public void showRestaurant(List<Result> resultList, String nextPageToken) {
        pageToken = nextPageToken;
        restaurantAdapter.updateList(resultList);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showLoading(String msg) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
        }
        progressDialog.setCancelable(false);
        String message = msg != null ? msg : getResources().getString(R.string.text_wait);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
