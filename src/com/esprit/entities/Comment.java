package com.esprit.entities;

public class Comment {
    private int id;
    private String text;
    private int user_id;
    private int blog_id;

    public Comment() {
    }

    public Comment(int id, String text, int user_id, int blog_id) {
        this.id = id;
        this.text = text;
        this.user_id = user_id;
        this.blog_id = blog_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }
}
