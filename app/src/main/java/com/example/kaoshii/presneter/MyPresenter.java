package com.example.kaoshii.presneter;

import com.example.kaoshii.beans.NewsData;
import com.example.kaoshii.modlue.MainModlue;
import com.example.kaoshii.view.MainView;

import java.util.List;
import java.util.Map;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public class MyPresenter implements MainPresenter, MainModlue.HttpFish {
    private MainModlue mMainModlue;
    private MainView mMainView;

    public MyPresenter(MainModlue mainModlue, MainView mainView) {
        mMainModlue = mainModlue;
        mMainView = mainView;
    }

    @Override
    public void set(Map<String,Object> map) {
        if (mMainView != null){
            mMainModlue.show(map,this);
        }
    }

    @Override
    public void setShowList(List<NewsData.RESULTBean.NewsListBean> t1371543208049Beans) {
        if (mMainView != null){
            mMainView.showList(t1371543208049Beans);
        }
    }

    @Override
    public void setShowError(String error) {
        if (mMainView != null){
            mMainView.showError(error);
        }
    }
}
