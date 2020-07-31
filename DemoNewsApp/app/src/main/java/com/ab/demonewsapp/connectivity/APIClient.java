package com.ab.demonewsapp.connectivity;

import com.ab.demonewsapp.utils.AppConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*
 * Singleton class for retrofit instance
 */
public class APIClient {
    private  static Retrofit retrofitInstance = null;
    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new retrofit2.Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URl) // To set the base URL of application
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
}


