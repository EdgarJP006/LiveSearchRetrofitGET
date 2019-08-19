package com.haerul.livesearchretrofitget.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haerul on 17/03/18.
 */

public class Contact {

    @SerializedName("seriestitle") private int seriestitle;
    @SerializedName("title") private String title;
    @SerializedName("author") private String author;

    public int getSeriestitle() {
        return seriestitle;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
