package com.example.kaoshii.modlue;

import com.example.kaoshii.beans.NewsData;

import java.util.List;
import java.util.Map;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public interface MainModlue {

    interface HttpFish{

        void setShowList(List<NewsData.RESULTBean.NewsListBean> t1371543208049Beans);

        void setShowError(String error);

    }

    void show(Map<String,Object>map, HttpFish httpFish);

}
