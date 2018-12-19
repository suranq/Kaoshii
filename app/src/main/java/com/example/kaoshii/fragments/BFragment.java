package com.example.kaoshii.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.kaoshii.R;
import com.example.kaoshii.beans.NewsData;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {

    @BindView(R.id.wv)
    WebView mWv;
    @BindView(R.id.bt)
    Button mBt;
    Unbinder unbinder;
    private NewsData.RESULTBean.NewsListBean mData;
    private int page = 0;
    private String mNewsImg;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        unbinder = ButterKnife.bind(this, view);

        WebSettings settings = mWv.getSettings();
        settings.setJavaScriptEnabled(true);
        if (page == 0){
            mWv.loadUrl("http://3g.163.com/news/18/1124/18/E1D9IANF0001899N.html");
        }else if (page == 1){
            mWv.loadUrl("http://3g.163.com/news/18/1124/17/E1D46Q730001875P.html");
        }
        page++;

        return view;
    }

    public void setData(NewsData.RESULTBean.NewsListBean data) {
        mData = data;
        mNewsImg = mData.getNewsImg();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bt)
    public void onViewClicked() {
        UMWeb web = new UMWeb("http://cms-bucket.nosdn.127.net/2018/11/24/44c70d0e68254e13a9ff6c187398af5c.jpeg");
        web.setTitle("是幡动?是风动？");
        web.setThumb(new UMImage(getContext(), R.drawable.aaa));
        web.setDescription("史新东");
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.SINA).withMedia(web).setCallback(new UMShareListener() {

            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onResult(SHARE_MEDIA share_media) {

            }

            @Override
            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {

            }
        }).open();
    }
}
