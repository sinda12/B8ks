/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.service;

import com.B8ks.utils.DataSource;
import Entity.Cart;
import Entity.Order;
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
public class CartService {
      Connection cnx = DataSource.getInstance().getCnx();

  public void ajouterC(Cart c) {
       
         try {
              String req="INSERT INTO cart (user_id,quantity) values(?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, c.getUser_id());
            pst.setInt(2, c.getQuantity());
            pst.executeUpdate();
            System.out.println("Panier ajoutée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }        
    }
    

public void supprimerC(Cart c) {
       
         try {
            
              String req="DELETE from cart where cart_id="+ c.getCart_id();
          cnx.createStatement().executeUpdate(req);
            System.out.println("panier est supprimée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }   
     
    }  



    public List<Cart> afficherC() {
        List<Cart> list = new ArrayList<>();
       
         try {
              String req="SELECT * from cart";
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
            ResultSet res = st.executeQuery();
            while (res.next()){
                list.add(new Cart(res.getInt(1), res.getInt(2),res.getInt(3)));
            }
             System.out.println("Panier affichée");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          
          }     
         return list ;
    }
    public void modifierC(Cart c) {
       
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
    }    
}