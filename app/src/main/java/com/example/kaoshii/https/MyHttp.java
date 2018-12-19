package com.example.kaoshii.https;

import android.util.Log;

import com.example.kaoshii.beans.NewsData;
import com.example.kaoshii.modlue.MainModlue;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public class MyHttp {

    private static MyHttp sMyHttp;

    private MyHttp() {
    }

    public static MyHttp getInsh() {
        if (sMyHttp == null) {
            synchronized (MyHttp.class) {
                if (sMyHttp == null) {
                    sMyHttp = new MyHttp();
                }
            }
        }
        return sMyHttp;
    }

    public void get(Map<String,Object>map, final MainModlue.HttpFish httpFish){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.URl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<NewsData> data = myServer.getData(map);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsData value) {
//                        Log.e("22222",value.getT1371543208049().get(2).getTitle());
                        httpFish.setShowList(value.getRESULT().getNewsList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("33333333",e.getMessage());
                        httpFish.setShowError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
