package com.example.kaoshii.modlue;

import com.example.kaoshii.beans.News;

import java.util.List;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public interface MaiModlue {

    interface HttpFish{
        void setShow(List<News.T1371543208049Bean> t1371543208049Beans);
    }

    void show(int page,HttpFish httpFish);

}
