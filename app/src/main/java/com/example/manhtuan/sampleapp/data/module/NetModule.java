package com.example.manhtuan.sampleapp.data.module;

import com.example.manhtuan.sampleapp.data.NetworkScope;
import com.example.manhtuan.sampleapp.net.ApiService;
import com.example.manhtuan.sampleapp.util.AppConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Provides
    @NetworkScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @NetworkScope
    @Named("client")
    OkHttpClient provideOkhttpClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(AppConstants.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor);
        return client.build();
    }


    @Provides
    @NetworkScope
    @Named("api_call")
    Retrofit provideRetrofit(Gson gson, @Named("client") OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(AppConstants.BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @NetworkScope
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @NetworkScope
    ApiService provideApiService(@Named("api_call") Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
