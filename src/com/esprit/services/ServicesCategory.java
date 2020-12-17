/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;


import com.esprit.entities.Category;
import com.esprit.utils.DataSource;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gar4a
 */
public class ServicesCategory {
    Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter (Category c){
    try{
    String req = "INSERT INTO category (title_cat,description) VALUES (?,?)";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    st.setString(1, c.getTitle_cat());
    st.setString(2, c.getDesc());
    st.executeUpdate();
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
    public void supprimer (Category c){
    try{
    String req = "DELETE from category WHERE id=?";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    st.setInt(1, c.getId());
    st.executeUpdate();
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
    public void modifier (Category c){
    try{
    String req = "UPDATE category SET title_cat=?, description=? WHERE id=?";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    st.setString(1, c.getTitle_cat());
    st.setString(2, c.getDesc());
    st.setInt(3, c.getId());
    st.executeUpdate();
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
    public List<Category> afficher (){
        List<Category> listCategory = new ArrayList<>();
    try{
    String req = "SELECT * From Category";
    Statement st = (Statement) cnx.createStatement();
    ResultSet res = st.executeQuery(req);
    while(res.next()){
      
       listCategory.add(new Category(res.getInt("id"),res.getString("title_cat"),res.getString("description")));
    }
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    System.out.println(listCategory);
    return listCategory;
    }
}
