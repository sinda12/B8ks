package com.B8ks.entities;

public class Order {
    Book books=new Book();
    private int order_id;
    private int cart_id;
    private User user;
    private String status;
    private double totalPrice;
    private int quantity;
    private int user_id;
    
    private String book; //=books.getTitle();
    private double price; //=books.getPrice();
    
    
    

    public Order() {
    }

    public Order(String book, double price, int quantity,int order_id) {
        this.order_id = order_id;
        this.quantity = quantity;
        this.book = book;
        this.price = price;
    }

    public Order(int order_id, int cart_id, int user_id, String status, double totalPrice) {
        this.order_id = order_id;
        this.cart_id = cart_id;
        this.status = status;
        this.totalPrice = totalPrice;
        this.user_id = user_id;
    }
   

    public Order(String book, double price, int quantity, String status) {
        this.book = book;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        
    }

    public Order(int cart_id, User user, String status, double totalPrice) {
        this.cart_id = cart_id;
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
        
    }

    public Order(int cart_id, double totalPrice, int user_id) {
        this.cart_id = cart_id;
        this.totalPrice = totalPrice;
        this.user_id = user_id;
    }

    public Order(int order_id, int cart_id, User user, String status, double totalPrice, int quantity, int user_id, String book, double price) {
        this.order_id = order_id;
        this.cart_id = cart_id;
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.user_id = user_id;
        this.book = book;
        this.price = price;
    }

 
    

    public Order(int cart_id, User user, String status) {
        this.cart_id = cart_id;
        this.user = user;
        this.status = status;
    }

    
    public Order(int order_id,  int cart_id,User user, String status, double totalPrice) {
        this.order_id = order_id;
        this.cart_id = cart_id;
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return "Order{" + "status=" + status + ", quantity=" + quantity + ", book=" + book + ", price=" + price + '}';
    }










    
    
    
    
    
}