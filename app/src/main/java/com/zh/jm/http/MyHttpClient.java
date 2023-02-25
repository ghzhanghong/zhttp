package com.zh.jm.http;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyHttpClient extends AbstractHttpClient {
    public static final String TAG = "MyHttpClient";

    private WanAndroidApiInterface wanAndroidApiInterface;

    public MyHttpClient() {
        wanAndroidApiInterface = retrofit.create(WanAndroidApiInterface.class);
    }

    public Flowable<ResultData<BaseListData<ArticleEntity>>> getHomeList(int page) {
        return wanAndroidApiInterface
                .getHomeList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public String getBaseUrl() {
        return "https://www.wanandroid.com";
    }

    @Override
    public List<Interceptor> getApplicationInterceptors() {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderInterceptor());
        interceptors.add(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG, message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY));
        return interceptors;
    }
}
