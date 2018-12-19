package com.example.kaoshii.modlue;

import android.util.Log;

import com.example.kaoshii.beans.News;
import com.example.kaoshii.https.MyServer;

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

public class Mmodlue implements MaiModlue {

    @Override
    public void show(int page, final HttpFish httpFish) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyServer.URL)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<News> newsObservable = myServer.get(page);
        newsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<News>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(News value) {
                        httpFish.setShow(value.getT1371543208049());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("555",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
