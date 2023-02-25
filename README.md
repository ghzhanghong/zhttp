# Android 基于Rxjava3+Retrofit2+Okhttp3的简单封装
> 本文以wanandroid 开放的API为例   
> 参考链接 [https://www.wanandroid.com/blog/show/2](https://www.wanandroid.com/blog/show/2)   
> 示例API [首页文章列表](https://www.wanandroid.com/article/list/1/json)
## 第一步：引入依赖
```gradle
//rx
    implementation "io.reactivex.rxjava3:rxjava:3.1.2"
    implementation "io.reactivex.rxjava3:rxandroid:3.0.0"
    //gson
    implementation 'com.google.code.gson:gson:2.9.0'
    //http
    implementation 'com.squareup.okhttp3:okhttp:3.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.9.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava3:2.9.0'
```
## 第二步：封装http请求
### 1.根据API返回结构定义ResultData
玩Android的API返回的基本结构是这样的
```json
{
    "data": ...,
    "errorCode": 0,
    "errorMsg": ""
}
```
那我们按照此结构定义好ResultData
```java
public class ResultData<T> {
    public int errorCode;
    public String errorMsg;
    public T data;
}
```

### 2.创建网络接口类
```java
public interface WanAndroidApiInterface {
    @GET("/article/list/{page}/json")
    Flowable<ResultData<BaseListData<ArticleEntity>>> getHomeList(@Path("page") int page);
}
```
### 3.创建http请求客户端   

需要做4件事

- 实例化网络接口
- 使用网络接口去封装好具体请求方法
- 返回baseurl
- 返回拦截器列表
``` Java
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
```
```java
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder builder = original.newBuilder();
        builder.addHeader("Content-Type","application/json");
        //添加其它的header
        return chain.proceed(builder.build());
    }
}
```

## 第三步：使用
> 由于使用方一般不关心返回数据的基础结构，只关心请求成功或者失败。所以我们可以进一步封装返回数据，使用Rxjava 订阅者对原始数据进行处理

```
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
```

**具体使用如下**

```java 
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private MyHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new MyHttpClient();
        findViewById(R.id.tv_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client.getHomeList(0)
                        .subscribe(new HttpResultSubscriber<BaseListData<ArticleEntity>>() {

                            @Override
                            public void onSuccess(BaseListData<ArticleEntity> data) {
                            }

                            @Override
                            public void onFail(Throwable throwable) {

                            }
                        });
            }
        });
    }
}
```


