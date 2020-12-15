/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.entities;

import com.B8ks.entities.Book;

/**
 *
 * @author sinda
 */
public class CartTable {
    Book books=new Book();
    private int ref;
    private int cart_id;
    private int user_id;
    private int book_id=books.getId();
    private String book=books.getTitle();
    private double price=books.getPrice();
    private int quantity;

    public CartTable() {
    }

    public CartTable(int cart_id, int user_id, int quantity,int book_id) {
        
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.book_id=book_id;
    }
    public CartTable( int user_id, int quantity,int book_id) {
        

        this.user_id = user_id;
        this.quantity = quantity;
        this.book_id=book_id;
    }

    public CartTable(int cart_id, int quantity) {
        this.cart_id = cart_id;
        this.quantity = quantity;
    }


    public CartTable(String book, double price, int quantity) {
        this.book = book;
        this.price = price;
        this.quantity = quantity;
    }
    public CartTable(String book, double price, int quantity, int cart_id) {
        this.book = book;
        this.price = price;
        this.quantity = quantity;
        this.cart_id=cart_id;
    }

    public CartTable(String book, double price, int quantity, int cart_id,int book_id) {
        this.book = book;
        this.price = price;
        this.quantity = quantity;
        this.cart_id=cart_id;
        this.book_id=book_id;
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

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
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

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    @Override
    public String toString() {
        return "CartTable{" + "book=" + book + ", price=" + price + ", quantity=" + quantity + '}';
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
        final CartTable other = (CartTable) obj;
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.book_id != other.book_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return true;
    }
   /* public int Q(CartTable c){
        if(c.equals(c))
                
       return this.quantity+1;        
        
    }*/
    
    
    
}
