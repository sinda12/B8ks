/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.entities;



/**
 *
 * @author sinda
 */
public class Cart {
    private int cart_id;
    private int user_id;
    private int quantity;
    private int book_id;

    public Cart() {
    }

    public Cart(int user_id, int quantity, int book_id) {
        this.user_id = user_id;
        this.quantity = quantity;
        this.book_id = book_id;
    }

    public Cart(int cart_id, int user_id, int quantity, int book_id) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.book_id = book_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.cart_id;
        hash = 29 * hash + this.user_id;
        hash = 29 * hash + this.quantity;
        hash = 29 * hash + this.book_id;
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
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.book_id != other.book_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cart{" + "cart_id=" + cart_id + ", user_id=" + user_id + ", quantity=" + quantity + ", book_id=" + book_id + '}';
    }

   
    
}
