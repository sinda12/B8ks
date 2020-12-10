
package com.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static DataSource instance;

    private Connection cnx;

    private final String URL = "jdbc:mysql://localhost:3306/esprit?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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