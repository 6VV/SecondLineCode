package com.example.administrator.secondlinecode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/1.
 */

public class NewsTitleFragment extends Fragment {

    private boolean mIsTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_fragment,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new NewsAdapter(getNews()));

        return view;
    }

    private List<News> getNews(){
        List<News> newsList=new ArrayList<>();
        for (int i=0;i<=50;++i){
            News news=new News();
            news.setTitle("title "+i);
            news.setContent("content " + i);
            newsList.add(news);
        }

        return newsList;
    }
    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        private List<News> mNewsList;

        NewsAdapter(List<News> newses){
            mNewsList=newses;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final ViewHolder viewHolder=new ViewHolder(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news=mNewsList.get(viewHolder.getAdapterPosition());
                    if (mIsTwoPane){
                        NewsContentFragment fragment= (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        fragment.refresh(news.getTitle(),news.getContent());
                    }
                    else{
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });

            return  viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news=mNewsList.get(position);
            holder.mNewsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView mNewsTitleText;
            public ViewHolder(View itemView) {
                super(itemView);
                mNewsTitleText= (TextView) itemView.findViewById(R.id.news_title);
            }
        }
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout)!=null){
            mIsTwoPane=true;
        }else{
            mIsTwoPane=false;
        }


    }
}
