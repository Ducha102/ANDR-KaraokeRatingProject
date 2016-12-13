package com.android.havietduc.karaokerating.model;

import java.io.Serializable;

/**
 * Created by havietduc on 12/13/16.
 */

public class Song implements Serializable{
    private String id;
    private String name;
    private String singer;
    private boolean isLike;

    public Song() {
    }

    public Song(String id, String name, String singer, boolean isLike) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.isLike = isLike;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}

