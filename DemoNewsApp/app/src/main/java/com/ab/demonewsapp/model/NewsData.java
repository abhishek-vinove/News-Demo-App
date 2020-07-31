package com.ab.demonewsapp.model;

import java.util.List;

/*
 * This class is used set and get root data of news
 */
public class NewsData {

    private List<Articles> articles;

    public NewsData(List<Articles> articles) {
        this.articles = articles;
    }
    public List<Articles> getArticles(){
        return this.articles;
    }
}
