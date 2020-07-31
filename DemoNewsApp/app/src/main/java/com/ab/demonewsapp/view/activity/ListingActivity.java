package com.ab.demonewsapp.view.activity;


import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ab.demonewsapp.R;
import com.ab.demonewsapp.connectivity.APIClient;
import com.ab.demonewsapp.connectivity.NewsService;
import com.ab.demonewsapp.model.Articles;
import com.ab.demonewsapp.model.NewsData;
import com.ab.demonewsapp.view.adapter.NewsDataAdapter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * This class is used for show full listing of data
 */
public class ListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        getDataFromAPI();
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Articles> articlesList) {
        RecyclerView mNewsRecyclerView = findViewById(R.id.news_list);
        NewsDataAdapter mAdapter = new NewsDataAdapter(articlesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListingActivity.this);
        mNewsRecyclerView.setLayoutManager(layoutManager);
        mNewsRecyclerView.setAdapter(mAdapter);
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void getDataFromAPI() {

        /*Create handle for the RetrofitInstance interface*/
        NewsService service = APIClient.getRetrofitInstance().create(NewsService.class);

        Call<NewsData> call = service.getAllNewsData();
        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse( Call<NewsData> call, Response<NewsData> response) {
                assert response.body() != null;
                generateDataList(response.body().getArticles());
            }

            @Override
            public void onFailure( Call<NewsData> call, Throwable t) {
                Toast.makeText(ListingActivity.this, R.string.something_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }
}