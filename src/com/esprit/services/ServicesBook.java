/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.B8ks.entities.Book;
import com.B8ks.entities.Category;
import com.esprit.utils.DataSource;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gar4a
 */
public class ServicesBook {
    Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter (Book b){
    try{
    String req = "INSERT INTO book (title,author,cat,description,publishDate,price,img) VALUES (?,?,?,?,?,?,?)";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    st.setString(1, b.getTitle());
    st.setString(4, b.getDescr());
    st.setString(2, b.getPublisher());
    st.setString(5, b.getPublishdDate());
    st.setDouble(6, b.getPrice());
    st.setString(7, b.getImg());
    st.setString(3, b.getCat());
    st.executeUpdate();
    }catch(SQLException ex){
         System.out.println(ex.getMessage());
    }
    }
    
    public void supprimer (Book b){
    try{
    String req = "DELETE from book WHERE id=?";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    st.setInt(1, b.getId());
    st.executeUpdate();
    
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
    public void modifier (Book b){
    try{
    String req = "UPDATE book SET title=?, author=?, cat=?, description=?, publishDate=? ,price=?, img=? WHERE id=?";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    st.setString(1, b.getTitle());
    st.setString(2, b.getPublisher());
    st.setString(3, b.getCat());
    st.setString(4, b.getDescr());
    st.setString(5, b.getPublishdDate());
    st.setDouble(6, b.getPrice());
    st.setString(7, b.getImg());
    st.setInt(8, b.getId());
    st.executeUpdate();
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
    public List<Book> afficher (){
        List<Book> listBook = new ArrayList<>();
    try{
    String req = "SELECT * From Book b left join Category c on b.id = c.id";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    ResultSet res = st.executeQuery();
    while(res.next()){
      
    listBook.add(new Book(res.getInt("id"), res.getString("title"), res.getString("author"), res.getString("cat"), res.getString("description"), res.getString("publishDate"), res.getDouble("price"), res.getString("img")));
    }
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    return listBook;
    }
    
    public List<Book> afficherID (int id){
        List<Book> listBook = new ArrayList<>();
    try{
    String req = "SELECT * From Book where id=?";
    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
    ResultSet res = st.executeQuery();
    while(res.next()){
    Book b = new Book();
    listBook.add(new Book(res.getInt("id"), res.getString("title"), res.getString("author"), res.getString("cat"), res.getString("description"), res.getString("publishDate"), res.getDouble("price"), res.getString("img")));
                }
    }catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
    return listBook;
    }
}
