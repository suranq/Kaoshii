package com.example.kaoshii.view;

import com.example.kaoshii.beans.NewsData;

import java.util.List;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public interface MainView {
    void showList(List<NewsData.RESULTBean.NewsListBean> t1371543208049Beans);
    void showError(String error);
}
