package com.ab.demonewsapp.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ab.demonewsapp.R;
import com.ab.demonewsapp.model.Articles;
import com.ab.demonewsapp.utils.AppConstant;
import com.bumptech.glide.Glide;

/*
 * This class is used for Details of news.
 */
public class DetailsActivity  extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView newsImage = findViewById(R.id.news_image);
        TextView newsTitle = findViewById(R.id.news_title);
        TextView newsAuthor = findViewById(R.id.news_author);
        TextView newsDec = findViewById(R.id.news_desc);

        // Get data from Intent
        Articles articles;
        articles = (Articles) getIntent().getSerializableExtra(AppConstant.SELECTED_DATA);

        assert articles != null;
        Glide.with(this).load(articles.getUrlToImage()).into(newsImage); // Glide lib to use set image on imageView

        newsTitle.setText(articles.getTitle());
        newsAuthor.setText(articles.getAuthor());
        newsDec.setText(articles.getDescription());




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);

    }
}