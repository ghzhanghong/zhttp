package com.zh.jm.http;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WanAndroidApiInterface {
    @GET("/article/list/{page}/json")
    Flowable<ResultData<BaseListData<ArticleEntity>>> getHomeList(@Path("page") int page);
}
