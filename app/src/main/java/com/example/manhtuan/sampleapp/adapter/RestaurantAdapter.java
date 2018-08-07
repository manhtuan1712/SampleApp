package com.example.manhtuan.sampleapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.manhtuan.sampleapp.R;
import com.example.manhtuan.sampleapp.model.Photo;
import com.example.manhtuan.sampleapp.model.Result;
import com.example.manhtuan.sampleapp.util.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Result> resultList;

    private Context context;

    public RestaurantAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    public void updateList(List<Result> resultList) {
        this.resultList.addAll(resultList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = resultList.get(position);

        if (result != null) {
            holder.tvAddressRestaurant.setText(result.getAddress());
            holder.tvNameRestaurant.setText(result.getName());
            Photo photo = result.getPhotoList().get(0);
            if (photo != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.mipmap.placholder);
                Glide.with(context)
                        .load(AppConstants.PHOTO_URL + "?maxwidth=1024"
                                + "&photoreference=" + photo.getPhotoReference() + "&key=" + AppConstants.KEY)
                        .apply(requestOptions)
                        .into(holder.imgRestaurant);
            }
        }
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvAddressRestaurant)
        TextView tvAddressRestaurant;

        @BindView(R.id.tvNameRestaurant)
        TextView tvNameRestaurant;

        @BindView(R.id.imgRestaurant)
        ImageView imgRestaurant;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
