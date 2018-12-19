package com.example.kaoshii.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kaoshii.R;
import com.example.kaoshii.beans.NewsData;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public class MyXrlvAdaper extends XRecyclerView.Adapter{
    private List<NewsData.RESULTBean.NewsListBean> mData;
    private final Context mContext;
    private OnItemListener mListener;

    public MyXrlvAdaper(List<NewsData.RESULTBean.NewsListBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(mContext).load(mData.get(position).getNewsImg()).apply(requestOptions).into(holder1.mIv);
        holder1.mTv1.setText(mData.get(position).getTitle());
        holder1.mTv2.setText(mData.get(position).getSource());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.OnItemListener(mData.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mData == null){
            return 0;
        }
        return mData.size();
    }

    class MyViewHolder extends XRecyclerView.ViewHolder {

        private final TextView mTv1;
        private final TextView mTv2;
        private final ImageView mIv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTv1 = itemView.findViewById(R.id.tv1);
            mTv2 = itemView.findViewById(R.id.tv2);
            mIv = itemView.findViewById(R.id.iv);
        }
    }

    public void setData(List<NewsData.RESULTBean.NewsListBean> t1371543208049Beans, int page) {
        if (page == 0){
            mData.clear();
        }
        mData.addAll(t1371543208049Beans);
        notifyDataSetChanged();
    }

    public interface OnItemListener{

        void OnItemListener(NewsData.RESULTBean.NewsListBean newsListBean);

    }

    public void setOnItemListener(OnItemListener listener){
        mListener = listener;
    }
}
