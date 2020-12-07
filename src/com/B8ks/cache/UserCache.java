/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.cache;

import com.B8ks.entities.Blog;
import com.B8ks.entities.Claim;
import com.B8ks.entities.NewsLetter;
import com.B8ks.entities.Order;
import com.B8ks.entities.UsedBook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sinda
 */
public class UserCache {
    public static int id,mobile, age;
    public static String nom,prenom,adresse,email,password;
    public static Boolean isAdmin ;
    public static List<Order> orders = new ArrayList<Order>();
    public static List<Blog> blogs = new ArrayList<Blog>() ;
    public static List<UsedBook> usedBooks = new ArrayList<UsedBook>() ;
    public static List<Claim> claims = new ArrayList<Claim>() ;
    public static List<NewsLetter> newsLetters = new ArrayList<NewsLetter>() ;
    
    
}
