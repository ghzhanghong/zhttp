package com.zh.jm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zh.jm.http.ArticleEntity;
import com.zh.jm.http.BaseListData;
import com.zh.jm.http.HttpResultSubscriber;
import com.zh.jm.http.MyHttpClient;

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