package com.example.administrator.secondlinecode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/1.
 */

public class NewsContentFragment extends Fragment {
    private View mView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.news_content_fragment,container,false);
        return mView;
    }


    public void refresh(String newsTitle,String newsContent){
        TextView newsTitleTv = (TextView) mView.findViewById(R.id.news_content_tv);
        newsTitleTv.setText(newsTitle);
        TextView newsContentTv = (TextView) mView.findViewById(R.id.news_title_tv);
        newsContentTv.setText(newsContent);
    }
}
