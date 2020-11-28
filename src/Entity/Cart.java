/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author sinda
 */
public class Cart {
    private int cart_id;
    private int user_id;
    private int quantity;
    private List<Book> books = new ArrayList<Book>() ;

    public Cart() {
    }

    public Cart(int cart_id, int user_id, int quantity) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
        final Cart other = (Cart) obj;
        if (this.cart_id != other.cart_id) {
            return false;
        }
        return this.user_id == other.user_id;
    }



    @Override
    public String toString() {
        return "Cart{" + "Cart_id=" + cart_id + ", user_id=" + user_id + ", quantity=" + quantity + ", books=" + books + '}';
    }
    

   
    
}
