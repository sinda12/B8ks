/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.entities;

import java.util.ArrayList;
import java.util.Objects;



/**
 *
 * @author sinda
 */
public class Cart {
    private int cart_id;
    private int user_id;
    private ArrayList<Integer> quantity= new ArrayList<>();
    private ArrayList<Book> books= new ArrayList<>();

    public Cart() {
    }

    public Cart(int cart_id, int user_id) {
        this.cart_id = cart_id;
        this.user_id = user_id;
    }

    public Cart(int user_id) {
        this.user_id = user_id;
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

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.cart_id;
        hash = 59 * hash + this.user_id;
        hash = 59 * hash + Objects.hashCode(this.quantity);
        hash = 59 * hash + Objects.hashCode(this.books);
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
        final Cart other = (Cart) obj;
        if (this.cart_id != other.cart_id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.books, other.books)) {
            return false;
        }
        return true;
    }
    
    public void addBook(Book book,int quantity){
        books.add(book);
        this.quantity.add(quantity);
    }
    



   
    
}
