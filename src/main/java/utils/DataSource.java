package utils;

import java.sql.*;

public class DataSource {
    public static DataSource instance ;

    private Connection cnx ;
    private final String URL = "jdbc:mysql://localhost:3306/EbookDb" ;
    private final String USERNAME = "root";
    private final String PASSWORD = "" ;

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("CONNECTION REUSSITE !");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static DataSource getInstance(){
        if (instance == null) instance = new DataSource();
        return instance ;

    }



}

