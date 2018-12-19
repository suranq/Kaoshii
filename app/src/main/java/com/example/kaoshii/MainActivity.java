package com.example.kaoshii;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kaoshii.adapters.MyFragmentAdapter;
import com.example.kaoshii.adapters.MyXrlvAdaper;
import com.example.kaoshii.beans.NewsData;
import com.example.kaoshii.fragments.AFragment;
import com.example.kaoshii.fragments.BFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyXrlvAdaper.OnItemListener {

    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    private BFragment mBFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTab.addTab(mTab.newTab().setText("首页"));
        mTab.addTab(mTab.newTab().setText("网络"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        ArrayList<Fragment> fragments = new ArrayList<>();
        mBFragment = new BFragment();
        fragments.add(new AFragment());
        fragments.add(mBFragment);
        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));
    }

    @Override
    public void OnItemListener(NewsData.RESULTBean.NewsListBean newsListBean) {
        mBFragment.setData(newsListBean);
        mVp.setCurrentItem(1);
    }
}
