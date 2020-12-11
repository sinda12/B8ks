/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.utils;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author gar4a
 */
public class DataSource {
    private static DataSource instance;
    
    private Connection cnx;
    
    private final String URL = "jdbc:mysql://localhost:3306/esprit";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    
    private DataSource() {
        try {
       cnx = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to Esprit !");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if (instance==null)
            instance = new DataSource();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
}
