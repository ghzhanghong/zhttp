package com.zh.jm.http;

import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;

public abstract class HttpResultSubscriber<T> implements FlowableSubscriber<ResultData<T>> {
    @Override
    public void onSubscribe(@NonNull Subscription s) {

    }

    @Override
    public void onNext(ResultData<T> tResultData) {
        if(tResultData.errorCode == 0){//errorCode = 0 代表执行成功，不建议依赖任何非0的 errorCode. 根据文档接口文档写
            onSuccess(tResultData.data);
        }else {
            onFail(new Throwable(tResultData.errorMsg));//一般情况下不根据errorCode 处理成功以外的业务，如果需要就不使用此订阅者了
        }
    }

    @Override
    public void onError(Throwable t) {
        onFail(t);
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T data);
    public abstract void onFail(Throwable throwable);
}
