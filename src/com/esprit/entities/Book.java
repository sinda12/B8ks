
package com.esprit.entities ;
import java.util.*;


public class Book {
  private int id;
  private String title;
  private String publisher;
  private String cat;
  private String descr;
  private String publishdDate;
  private double price;
  private String img;
  private List <Category> lc = new ArrayList<Category>();

    public Book() {
    }

    public Book(String title, String publisher, String cat, String descr, String publishdDate, double price, String img) {
        this.title = title;
        this.publisher = publisher;
        this.cat = cat;
        this.descr = descr;
        this.publishdDate = publishdDate;
        this.price = price;
        this.img = img;
    }

    public Book(int id, String title, String publisher, String cat, String descr, String publishdDate, double price, String img) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.cat = cat;
        this.descr = descr;
        this.publishdDate = publishdDate;
        this.price = price;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Book(String title, String publisher, String descr, String publishdDate, double price) {
        this.title = title;
        this.publisher = publisher;
        this.descr = descr;
        this.publishdDate = publishdDate;
        this.price = price;
    }

    public Book(int id, String title, String publisher, String cat, String descr, String publishdDate, double price) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.cat = cat;
        this.descr = descr;
        this.publishdDate = publishdDate;
        this.price = price;
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String title, String publisher, String descr, String publishdDate, double price) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.descr = descr;
        this.publishdDate = publishdDate;
        this.price = price;
    }

    public Book(String title, String publisher, String cat, String descr, String publishdDate, double price) {
        this.title = title;
        this.publisher = publisher;
        this.cat = cat;
        this.descr = descr;
        this.publishdDate = publishdDate;
        this.price = price;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPublishdDate() {
        return publishdDate;
    }

    public void setPublishdDate(String publishdDate) {
        this.publishdDate = publishdDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Category> getLc() {
        return lc;
    }

    public void setLc(List<Category> lc) {
        this.lc = lc;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", publisher=" + publisher + ", cat=" + cat + ", descr=" + descr + ", publishdDate=" + publishdDate + ", price=" + price + ", lc=" + lc + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        return true;
    }

    
    

    
    
  
 
    

    
    
  
  
}
