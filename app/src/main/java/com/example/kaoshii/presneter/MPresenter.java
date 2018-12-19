package com.example.kaoshii.presneter;

import com.example.kaoshii.beans.News;
import com.example.kaoshii.modlue.MaiModlue;
import com.example.kaoshii.view.MaiView;

import java.util.List;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public class MPresenter implements MaiPresenter, MaiModlue.HttpFish {
    private MaiModlue mMaiModlue;
    private MaiView mMaiView;

    public MPresenter(MaiModlue maiModlue, MaiView maiView) {
        mMaiModlue = maiModlue;
        mMaiView = maiView;
    }

    @Override
    public void page(int page) {
        if (mMaiView != null){
            mMaiModlue.show(page,this);
        }
    }

    @Override
    public void setShow(List<News.T1371543208049Bean> t1371543208049Beans) {
        if (mMaiView != null){
            mMaiView.show(t1371543208049Beans);
        }
    }
}
