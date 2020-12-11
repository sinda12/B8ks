/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;

import com.B8ks.entities.Book;
import com.B8ks.entities.Category;
import com.esprit.services.ServicesBook;
import com.esprit.services.ServicesCategory;
import com.esprit.utils.DataSource;
import com.mysql.jdbc.Connection;
import java.sql.Date;

/**
 *
 * @author gar4a
 */
public class MainProg {
    public static void main(String[] args) {
        ServicesBook sb = new ServicesBook();
        Book b = new Book(1,"AAAA", "B", "C", "12/12/12", 110);
        
        
        sb.modifier(b);
        
        
        
    }
}
