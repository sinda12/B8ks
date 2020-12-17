/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities ;

import java.util.Objects;

/**
 *
 * @author sinda
 */
public class Carts {
       Book books=new Book();
    private int ref;
    private int cart_id;
    private int user_id;
    private int book_id=books.getId();
    private String book=books.getTitle();
    private double price=books.getPrice();
    private int quantity;

    public Carts() {
    }

    public Carts(int ref, int cart_id, int user_id, int quantity) {
        this.ref = ref;
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
    }

    public Carts(int cart_id, int user_id, int quantity) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
    }

    public Carts(int cart_id, int user_id) {
        this.cart_id = cart_id;
        this.user_id = user_id;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart_user{" + "books=" + books + ", ref=" + ref + ", cart_id=" + cart_id + ", user_id=" + user_id + ", book_id=" + book_id + ", book=" + book + ", price=" + price + ", quantity=" + quantity + '}';
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
        final Carts other = (Carts) obj;
        if (this.cart_id != other.cart_id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.book_id != other.book_id) {
            return false;
        }
        return true;
    }


    
    
    
    
    
    
    
}
