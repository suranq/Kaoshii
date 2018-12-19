package com.example.kaoshii.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaoshii.MainActivity;
import com.example.kaoshii.R;
import com.example.kaoshii.adapters.MyXrlvAdaper;
import com.example.kaoshii.beans.News;
import com.example.kaoshii.beans.NewsData;
import com.example.kaoshii.modlue.Mmodlue;
import com.example.kaoshii.modlue.MyModlue;
import com.example.kaoshii.presneter.MPresenter;
import com.example.kaoshii.presneter.MyPresenter;
import com.example.kaoshii.view.MaiView;
import com.example.kaoshii.view.MainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements MainView,MaiView {


    @BindView(R.id.xrlv)
    XRecyclerView mXrlv;
    Unbinder unbinder;
    private MyPresenter mMyPresenter;
    private int mPage = 0;
    private MyXrlvAdaper mMyXrlvAdaper;
    private List<NewsData.RESULTBean.NewsListBean> mData = new ArrayList<>();

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        unbinder = ButterKnife.bind(this, view);

        MPresenter mPresenter = new MPresenter(new Mmodlue(), this);
        mPresenter.page(0);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mXrlv.setLayoutManager(manager);
        mXrlv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        mMyXrlvAdaper = new MyXrlvAdaper(mData,getContext());
        mXrlv.setAdapter(mMyXrlvAdaper);

        mMyXrlvAdaper.setOnItemListener((MainActivity)getActivity());

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            mMyPresenter = new MyPresenter(new MyModlue(), this);
            Map<String,Object> map = new HashMap<>();
            map.put("appKey","4f359e9003324dd0a6cff75e229ebbc3");
            map.put("category","财经");
            map.put("page","1");
            mMyPresenter.set(map);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showList(List<NewsData.RESULTBean.NewsListBean> t1371543208049Beans) {
        Log.e("11111111",t1371543208049Beans.get(1).getTitle());
        mMyXrlvAdaper.setData(t1371543208049Beans,mPage);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void show(List<News.T1371543208049Bean> t1371543208049Beans) {
        Log.e("4444444",t1371543208049Beans.get(2).getTitle());
    }
}
