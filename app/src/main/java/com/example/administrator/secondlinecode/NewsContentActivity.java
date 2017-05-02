package com.example.administrator.secondlinecode;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {
    private static String EXTRA_TITLE="news_title";
    private static String EXTRA_CONTENT="news_content";

    public static void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra(EXTRA_TITLE,newsTitle);
        intent.putExtra(EXTRA_CONTENT,newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        String newsTitle = getIntent().getStringExtra(EXTRA_TITLE);
        String newsContent = getIntent().getStringExtra(EXTRA_CONTENT);

        NewsContentFragment fragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        fragment.refresh(newsTitle,newsContent);
    }
}
