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
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public List<Order> afficherO() {
        
        
        
        List<Order> list = new ArrayList<>();
         try {
             if(UserCache.isAdmin)
             { String req="SELECT * from bookorder";
            java.sql.Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            User s = new User();
            while (res.next()){
                s.setId(res.getInt(3));
                list.add(new Order(res.getInt(1), res.getInt(2),s,res.getString(4),res.getFloat(5)));
            }
             System.out.println("Commande afficher");}
             else
             { String req="SELECT * from bookorder where user_id="+UserCache.id;
            java.sql.Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            User s = new User();
            while (res.next()){
                s.setId(res.getInt(3));
                list.add(new Order(res.getInt(1), res.getInt(2),s,res.getString(4),res.getFloat(5)));
            }
             System.out.println("Commande afficher");
                 
             }
                 ;
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;}

    
    
    
    
//"UPDATE bookorder SET cart_id='"+o.getCart_id()+"', user_id='"+ o.getUser_id()+"',status='"+o.getStatus()+"',totalPrice='" +o.getTotalPrice()+"' WHERE order_id="o.getOrder_id();    
    public void modifierO(Order o) {
       
         try {
              String req="UPDATE bookorder SET cart_id=?,user_id=?,status=?,totalPrice=? WHERE order_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setInt(1, o.getCart_id());
            pst.setInt(2, o.getUser().getId());
            pst.setString(3, o.getStatus());
            pst.setFloat(4, (float) o.getTotalPrice());
            pst.setInt(5, o.getOrder_id());
            
            pst.executeUpdate();
            System.out.println("Commande modifiée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }

    
}
    
