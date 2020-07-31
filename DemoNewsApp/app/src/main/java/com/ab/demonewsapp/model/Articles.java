package com.ab.demonewsapp.model;

import java.io.Serializable;

/*
 * This class is used set and get article data
 */
public class Articles implements Serializable {

    private String author;
    private String title;
    private String description;
    private String urlToImage;

    public Articles(String author, String title, String description, String urlToImage) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
    }


    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUrlToImage() {
        return this.urlToImage;
    }

}
