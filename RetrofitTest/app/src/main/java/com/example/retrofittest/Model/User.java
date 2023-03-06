package com.example.retrofittest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("volnum")
    @Expose
    private int volnum;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public int getVolnum() {
        return volnum;
    }

    public String getLink() {
        return link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setVolnum(int volnum) {
        this.volnum = volnum;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "User{" +
                "volnum=" + volnum +
                ", link='" + link + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
