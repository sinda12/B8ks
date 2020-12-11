/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gar4a
 */
public class Category {
  private int id;
    private String title_cat;
    private String desc;
    private Book boo;
    private List <Book> lb = new ArrayList<Book>();

    public Category(int id, String title_cat, Book boo) {
        this.id = id;
        this.title_cat = title_cat;
        this.boo = boo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Category(int id, String title_cat, String desc) {
        this.id = id;
        this.title_cat = title_cat;
        this.desc = desc;
    }

    public Category(String title_cat, String desc) {
        this.title_cat = title_cat;
        this.desc = desc;
    }

    public Category(String title_cat) {
        this.title_cat = title_cat;
    }
    
    public Category(int id) {
        this.id = id;
    }

    public Category(int id, String title_cat) {
        this.id = id;
        this.title_cat = title_cat;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_cat() {
        return title_cat;
    }

    public void setTitle_cat(String title_cat) {
        this.title_cat = title_cat;
    }

    public Book getBoo() {
        return boo;
    }

    public void setBoo(Book boo) {
        this.boo = boo;
    }

    public List<Book> getLb() {
        return lb;
    }

    public void setLb(List<Book> lb) {
        this.lb = lb;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", title_cat=" + title_cat + ", desc=" + desc + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.title_cat, other.title_cat)) {
            return false;
        }
        return true;
    }

    

    
}
