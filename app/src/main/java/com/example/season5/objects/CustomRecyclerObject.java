package com.example.season5.objects;

public class CustomRecyclerObject {

    private String singerName;
    private String songName;
    private int like;
    private int view;
    private int comment;
    private String date;

    public CustomRecyclerObject() {
    }

    public CustomRecyclerObject(String singerName, String songName, int like, int view, int comment, String date) {
        this.singerName = singerName;
        this.songName = songName;
        this.like = like;
        this.view = view;
        this.comment = comment;
        this.date = date;
    }


    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
