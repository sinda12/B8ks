/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.entities;

import java.util.Objects;

/**
 *
 * @author sinda
 */
public class Cart_user {
    User user=new User();
    int cart_id;
    int user_id;

    public Cart_user() {
    }

    public Cart_user(int cart_id, int user_id) {
        this.cart_id = cart_id;
        this.user_id = user_id=user.getId();
    }

    public Cart_user(int user_id) {
        this.user_id =user_id=user.getId();
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
        final Cart_user other = (Cart_user) obj;
        if (this.cart_id != other.cart_id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cart_user{" + "user=" + user + ", cart_id=" + cart_id + ", user_id=" + user_id + '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    
    
 
}
