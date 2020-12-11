/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.service;

import com.B8ks.cache.UserCache;
import com.B8ks.entities.Order;
import com.B8ks.entities.User;
import com.B8ks.utils.DataSource;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;



/**
 *
 * @author sinda
 */
public class ServiceOrder{
    Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouterO(Order o) {
       
         try {
              String req="INSERT INTO bookorder (cart_id,user_id,status,totalPrice) values(?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, o.getCart_id());
            pst.setInt(2,UserCache.id);
            pst.setString(3, o.getStatus());
            pst.setFloat(4, (float) o.getTotalPrice());
            pst.executeUpdate();
            System.out.println("Commande ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }
    public void supprimerO(Order o) {
       
         try {
             //int id=o.getOrder_id();
              String req="DELETE from bookorder where order_id="+ o.getOrder_id();
          cnx.createStatement().executeUpdate(req);
            System.out.println("Commande supprimée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }
//****************************affichage admin    
    public List<Order> afficherO() {
        
        
        
        List<Order> list = new ArrayList<>();
         try {
       
             { String req="SELECT * from bookorder";
            java.sql.Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()){
                list.add(new Order(res.getInt(1), res.getInt(2),res.getInt(3),res.getString(4),res.getDouble(5)));
            }
             System.out.println("Commande afficher");}
             
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;}
    public List<Order> GetByIDuser(int user_id) {
        
        List<Order> list = new ArrayList<>();
         try {
       
             { String req="SELECT * from bookorder where user_id="+user_id;
            java.sql.Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()){
                list.add(new Order(res.getInt(1), res.getInt(2),res.getInt(3),res.getString(4),res.getDouble(5)));
            }
             System.out.println("Commande afficher");}
             
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;}
//----------------------------------------show orders client
    public List<Order> getOrdersClient(int user_id) {
        List<Order> list = new ArrayList<>();
         try 
             { String req="SELECT b.title,c.price,c.quantity,o.status from bookorder o,Archive c,book b where b.book_id=c.book_id and o.cart_id=c.cart_id and c.user_id="+user_id;
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            
            ResultSet res = st.executeQuery();
            while (res.next()){
                list.add(new Order(res.getString(1), res.getDouble(2),res.getInt(3),res.getString(4)));
                
            }
             System.out.println("commandes affichées");
             System.out.println(list);
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;}
    
    //-------------------order pdf
     public List<Order> getOrderID(int user_id) {
        List<Order> list = new ArrayList<>();
         try 
             { String req="SELECT b.title,c.price,c.quantity,o.order_id from bookorder o,Archive c,book b where b.book_id=c.book_id and o.cart_id=c.cart_id and c.user_id="+user_id;
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            
            ResultSet res = st.executeQuery();
            while (res.next()){
                list.add(new Order(res.getString(1), res.getDouble(2),res.getInt(3),res.getInt(4)));
                
            }
             
             System.out.println(list);
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;}
 //----------------------------------USER ADRESS
  

    public String UserDetails(int user_id){
        
        String t="";
        try {
        String req="SELECT nom,prenom,adresse,mobile from user where user_id=?";
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
        st.setInt(1,user_id);

        ResultSet res = st.executeQuery();
        
         while (res.next()){
            t=res.getString(1)+" "+res.getString(2)+"\n"+res.getString(3)+"\n"+res.getInt(4);}
        
                     System.out.println("details affichée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          } 
        
        return  t;
    }
//*******************************************
    public void addO(int user_id) {
     
       
         try {
              String req="INSERT INTO bookorder (cart_id,user_id,totalPrice) select cart_id,user_id,totalprice from cart where user_id="+user_id;
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Commande ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }  
    
  
    
    
    
    
    
//"UPDATE bookorder SET cart_id='"+o.getCart_id()+"', user_id='"+ o.getUser_id()+"',status='"+o.getStatus()+"',totalPrice='" +o.getTotalPrice()+"' WHERE order_id="o.getOrder_id();    
    public void modifierO(Order o) {
       
         try {
              String req="UPDATE bookorder SET cart_id=?,user_id=?,status=?,totalPrice=? where order_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setInt(1, o.getCart_id());
            pst.setInt(2, o.getUser().getId());
            pst.setString(3, o.getStatus());
            pst.setDouble(4,o.getTotalPrice());
            pst.setInt(5, o.getOrder_id());
            
            pst.executeUpdate();
            System.out.println("Commande modifiée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }
    //********************admin view update
    
        public void modifierOAdmin(int c,String s,double tp) {
       
         try {
              String req="UPDATE bookorder SET status=?,totalPrice=? where cart_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setInt(3, c);
           
            pst.setString(1,s);
            pst.setDouble(2,tp);
            
            
            pst.executeUpdate();
            System.out.println("Commande modifiée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }

    
}
    
