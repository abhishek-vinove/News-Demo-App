package com.ab.demonewsapp.connectivity;

import com.ab.demonewsapp.model.NewsData;
import com.ab.demonewsapp.utils.AppConstant;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NewsService {
    @GET(AppConstant.PATH + AppConstant.GOOGLE_API_KEY)
    Call<NewsData> getAllNewsData();
}
