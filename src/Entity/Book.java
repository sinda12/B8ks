/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gar4a
 */
public class Book {
    private int id;
  private String title;
  private String desc;
  private String publisher;
  private Date publishdDate;
  private double price;
  private List <Category> lc = new ArrayList<Category>();

    public Book() {
    }

    public Book(int id, String title, String desc, String publisher, Date publishdDate, double price) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.publisher = publisher;
        this.publishdDate = publishdDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", desc=" + desc + ", publisher=" + publisher + ", publishdDate=" + publishdDate + ", price=" + price + ", lc=" + lc + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

  
  
}
