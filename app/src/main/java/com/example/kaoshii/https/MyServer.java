package com.example.kaoshii.https;

import com.example.kaoshii.beans.News;
import com.example.kaoshii.beans.NewsData;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public interface MyServer {

    //http://c.m.163.com/nc/article/list/T1371543208049/0-20.html
    //http://api.shujuzhihui.cn/api/news/list

    String URl = "http://api.shujuzhihui.cn/api/news/";
    @GET("list")
    Observable<NewsData> getData (@QueryMap Map<String,Object>map);

    String URL = "http://c.m.163.com/nc/article/list/T1371543208049/";
    @GET("{page}-20.html")
    Observable<News> get(@Path("page")int page);

}
