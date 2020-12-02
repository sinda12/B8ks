/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.utils;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author sinda
 */
public class DataSource {
    private static DataSource instance;
    private Connection cnx;
    private final String URL="jdbc:mysql://localhost:3306/b8ks";
    private final String USERNAME = "root";
    private final String PASSWORD ="";

    public DataSource() {
        
        try {
            cnx = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to B8ks");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }

    public static DataSource getInstance() {
           if (instance==null) {
               instance=new DataSource();
           } else {
           }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    

 
}
