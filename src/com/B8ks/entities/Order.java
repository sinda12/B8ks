package com.B8ks.entities;

public class Order {
    private int order_id;
    private int cart_id;
    private User user;
    private String status;
    private float totalPrice;

    public Order() {
    }

    public Order(int cart_id, User user, String status, float totalPrice) {
        this.cart_id = cart_id;
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
    }

 
    

    public Order(int cart_id, User user, String status) {
        this.cart_id = cart_id;
        this.user = user;
        this.status = status;
    }

    
    public Order(int order_id,  int cart_id,User user, String status, float totalPrice) {
        this.order_id = order_id;
        this.cart_id = cart_id;
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
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
        final Order other = (Order) obj;
        if (this.order_id != other.order_id) {
            return false;
        }
        if (this.cart_id != other.cart_id) {
            return false;
        }
        return Double.doubleToLongBits(this.totalPrice) == Double.doubleToLongBits(other.totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", cart_id=" + cart_id + ", user=" + user + ", status=" + status + ", totalPrice=" + totalPrice + '}';
    }






    
    
    
    
    
}