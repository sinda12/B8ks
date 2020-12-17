package com.esprit.entities;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private int id;
    private String title;
    private String category;
    private String text;
    private int report;
    private int likes;
    private int dislikes;
    private String date;
    private User user;
    private List<Comment> list= new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getList() {
        return list;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

    public Blog(String title, String category, String text,String date) {
        this.title = title;
        this.category = category;
        this.text = text;
        this.date=date;
    }

    public Blog(int id,int report, int likes, int dislikes) {
        this.report = report;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Blog(int id, String title, String category, String text, int report, int likes, int dislikes, String date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.text = text;
        this.report = report;
        this.likes = likes;
        this.dislikes = dislikes;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Blog() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Blog(String text, int report, int likes, int dislikes) {

        this.text = text;
        this.report = report;
        this.likes = likes;
        this.dislikes = dislikes;
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

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", text='" + text + '\'' +
                ", report=" + report +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}
