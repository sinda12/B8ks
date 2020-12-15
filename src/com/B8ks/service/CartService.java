/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.service;

import com.B8ks.entities.CartTable;
import com.B8ks.entities.Book;
import com.B8ks.entities.Cart;
import com.B8ks.entities.Carts;
import com.B8ks.entities.User;
import com.B8ks.utils.DataSource;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sinda
 */

public class CartService {
      Connection cnx = DataSource.getInstance().getCnx();


public void supprimerC(Cart c) {
       
         try {
            
              String req="DELETE from cart where cart_id="+ c.getCart_id();
          cnx.createStatement().executeUpdate(req);
            System.out.println("panier est supprimée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    }  
//**********************************************new
    public ObservableList getCart(int user_id) {
        ObservableList<Cart> list = FXCollections.observableArrayList();
        String req="SELECT * from cart where user_id=?";
       
         try {
              
              
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            st.setInt(1,user_id);
            ResultSet res = st.executeQuery();
            while (res.next()){
                Cart cart=new Cart();
                cart.setCart_id (res.getInt(1));
                cart.setUser_id(res.getInt(2));
                cart.addBook(new Book(res.getInt(4)),res.getInt(3));
                list.add(cart);
               
            }
             System.out.println("liste panier recupere");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;
    }

    
//***************************************************************used**** supprission
   /*public void supprimerCControllerdef(int user_id,CartTable c) {
       
         try {
            
          String req="DELETE from cart where user_id=? and book_id=?";
          
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            st.setInt(1,user_id);
            st.setInt(2,c.getBook_id());
             System.out.println(c.getBook_id());
            ResultSet res = st.executeQuery();
            System.out.println("panier est supprimée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    } 
   
    
        public void supprimerCControllerID(int user_id,int book_id) {
       
         try {
            
          String req="DELETE from cart where user_id="+user_id+"and book_id="+ book_id;
          cnx.createStatement().executeUpdate(req);
             System.out.println(book_id);
            System.out.println("panier est supprimée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    }  */
    
    
           
    public void supprimerCController(CartTable c) {
       
         try {
            
          String req="DELETE from cart where cart_id="+ c.getCart_id();
          cnx.createStatement().executeUpdate(req);
             System.out.println(c.getBook_id());
            System.out.println("panier est supprimée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    } 
    //***********************ajout quantitè
        public void plusquantity(CartTable c) {
       
         try {
           
          String req="update cart SET quantity=quantity+1 where cart_id="+ c.getCart_id();
          cnx.createStatement().executeUpdate(req);
            System.out.println("quantitè +");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    }
        public void moinquantity(CartTable c) {
       
         try {
           
          String req="update cart SET quantity=quantity-1 where cart_id="+ c.getCart_id();
          cnx.createStatement().executeUpdate(req);
            System.out.println("quantitè -");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    }    
        
        
    public void deleteCartOrdred(int user_id) {
       
         try {
            
          String req="DELETE from cart where user_id="+user_id;
          cnx.createStatement().executeUpdate(req);
            System.out.println("panier vide");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    } 
  //******************new --- 
    public void ajouterC(CartTable c) {
       
         try {
              String req="INSERT INTO cart (user_id,quantity,book_id) values(?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            //c.getUser.getUser_id(
            pst.setInt(1, c.getUser_id());
            pst.setInt(2, c.getQuantity());
            pst.setInt(3, c.getBook_id());
            pst.executeUpdate();
            System.out.println("Panier ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }
    //**************************
   /* public void addBookToCart_copy(int user_id,int b,double p) {
       
         try {
              String req="INSERT INTO cart_copy (user_id,book_id,price) values(?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            //c.getUser.getUser_id(
            pst.setInt(1, user_id);
            pst.setInt(2, b);
            pst.setDouble(3, p);
            pst.executeUpdate();
            System.out.println("Panier ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }*/
    public void addBookToCart(int user_id,int b,double p) {
       
         try {
              String req="INSERT INTO cart (user_id,book_id,price) values(?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            //c.getUser.getUser_id(
            pst.setInt(1, user_id);
            pst.setInt(2, b);
            pst.setDouble(3, p);
            pst.executeUpdate();
            System.out.println("Panier ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }
   
   /* public void addBookToCart(int user_id) {
       
         try {
              String req="INSERT INTO cart (user_id,book_id,quantity,price) select DISTINCT user_id,book_id,sum(quantity),price from cart_copy where user_id="+user_id+" group by book_id";
            PreparedStatement pst = cnx.prepareStatement(req);
            //c.getUser.getUser_id(
            pst.executeUpdate();
            System.out.println("Panier ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }*/
    
    


    public Cart afficherC(Cart cart) {
        List<Cart> list = new ArrayList<>();
       
         try {
              String req="SELECT * from cart where cart_id=?";
              
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            st.setInt(1,cart.getCart_id());
            ResultSet res = st.executeQuery();
            while (res.next()){
                cart.setCart_id(res.getInt(1));
                cart.setUser_id(res.getInt(2));
                cart.addBook(new Book(res.getInt(4)),res.getInt(3));
            }
             System.out.println("Panier affichée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return cart ;
    }
    //******************* try -- useeeed
            
    public List<CartTable> afficherCController(int user_id) {
        List<CartTable> list = new ArrayList<>();
       
         try {
            String req="SELECT DISTINCT b.title,b.price,sum(c.quantity),c.cart_id,c.book_id from cart c,book b where b.book_id=c.book_id and c.user_id=? group by c.book_id";
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            st.setInt(1,user_id);
            ResultSet res = st.executeQuery();
            while (res.next()){
                list.add(new CartTable(res.getString(1), res.getDouble(2),res.getInt(3),res.getInt(4),res.getInt(5)));
            }
             System.out.println("Panier affichée");
             
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;
    }
    //*********** Archive
    public List<CartTable> afficheArchive(int user_id) {
        List<CartTable> list = new ArrayList<>();
       
         try {
            String req="SELECT b.title,b.price,c.quantity,c.cart_id from Archive c,book b where b.book_id=c.book_id and c.user_id=?";
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            st.setInt(1,user_id);
            ResultSet res = st.executeQuery();
            while (res.next()){
                list.add(new CartTable(res.getString(1), res.getDouble(2),res.getInt(3),res.getInt(4)));
            }
             System.out.println("Panier affichée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;
    }
    
    
       public void addToArchive(int user_id) {
       
         try {
              String req="INSERT INTO archive(cart_id,user_id,quantity,book_id,price,totalprice) select * from cart where user_id="+user_id;
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Archive ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    } 
    
    
    public String prixTotale(int user_id){
        
        double t=0;
        try {
        String req="SELECT sum(totalprice) from cart where user_id=?";
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
        st.setInt(1,user_id);

        ResultSet res = st.executeQuery();
        
         while (res.next()){
        t=res.getDouble(1);}
        
                     System.out.println("prix totale affichée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          } 
        
        return  Double.toString(t);
    }
    
  //*************************calcule panier
    
    public String nbPanier(int user_id){
        
        int t=0;
        try {
        String req="SELECT sum(quantity) from cart where user_id=?";
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
        st.setInt(1,user_id);

        ResultSet res = st.executeQuery();
        
         while (res.next()){
        t=res.getInt(1);}
        
                     System.out.println("panier");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          } 
        
        return  Integer.toString(t);
    }
    
    
  //***************************useeeeeeeed
    
    
    
    
    /*public void modifierC(Cart c) {
       
         try {
              String req="UPDATE Cart SET user_id=?,quantity=? WHERE cart_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setInt(3, c.getCart_id());
            pst.setInt(1, c.getUser_id());
            pst.setInt(2, c.getQuantity());

            
            pst.executeUpdate();
            System.out.println("Panier modifiée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }  */

    
    
    
    /*    public void addCart_ToUser(int user_id) {
        try {
            PreparedStatement st =cnx.prepareStatement("INSERT into cart_user(user_id) values (?)");
            st.setInt(1,user_id);
            
            st.executeUpdate();
            System.out.println("Panier affectè");

        } catch (SQLException e) {
            System.out.println("not working");
            e.printStackTrace();
        }

    } */       
     /* public void ajouterC(Cart c) {
       
         try {
              String req="INSERT INTO cart (user_id,quantity) values(?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            //c.getUser.getUser_id(
            pst.setInt(1, c.getUser_id());
            pst.setInt(2, c.getQuantity());
            pst.executeUpdate();
            System.out.println("Panier ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }
    

    
    
    */

    
    
    
}

