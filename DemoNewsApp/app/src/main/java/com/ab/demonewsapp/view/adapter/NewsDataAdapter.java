package com.ab.demonewsapp.view.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ab.demonewsapp.R;
import com.ab.demonewsapp.model.Articles;
import com.ab.demonewsapp.utils.AppConstant;
import com.ab.demonewsapp.view.activity.DetailsActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 * This class is used set news data to adapter
 */
public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.CustomViewHolder> {

    private List<Articles> mNewDataList;

    public NewsDataAdapter(List<Articles> dataList) {
        this.mNewDataList = dataList;
    }

    /*
     * This inner class to bind the data with view
     */
    static class CustomViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView mTitle;
        ImageView mImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            mTitle = mView.findViewById(R.id.news_title);
            mImage = mView.findViewById(R.id.news_image);

        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listing_row_item, parent, false);
        return new CustomViewHolder(view);
    }

    /*
     * This method is used for set data one by on in view
     */
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.mTitle.setText(mNewDataList.get(position).getTitle());
        Glide.with(holder.mImage).load(mNewDataList.get(position).getUrlToImage()).into(holder.mImage);

        holder.mView.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), DetailsActivity.class);
            i.putExtra(AppConstant.SELECTED_DATA, mNewDataList.get(position));
            v.getContext().startActivity(i);
        });

    }


    /*
     * This method is used for to return the list size of news data
     */
    @Override
    public int getItemCount() {
        return mNewDataList.size();
    }

}

