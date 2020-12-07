package com.B8ks.service;


import com.B8ks.entities.User;
import com.B8ks.utils.DataSource;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServiceUser implements Iservice<User>  {

Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void adduser(User p) {
        try {
            PreparedStatement st = cnx.prepareStatement("INSERT into USER (mobile, age, nom, prenom, adresse, email, password) values (?,?,?,?,?,?,?)");
            st.setInt(1,p.getMobile());
            st.setInt(2,p.getAge());
            st.setString(3,p.getNom());
            st.setString(4,p.getPrenom());
            st.setString(5,p.getAdresse());
            st.setString(6,p.getEmail());
            st.setString(7,p.getPassword());
            st.executeUpdate();
            System.out.println("ajout reussi !!!");

        } catch (SQLException e) {
            System.out.println("lekhraaaa");
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getList() {
        List<User> l = new ArrayList<>() ;
        try {
            PreparedStatement st = cnx.prepareStatement("select * from USER ");
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                l.add(new User(rs.getInt(2),rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getBoolean(9)));
            }
            System.out.println("affichage reussi !!!!");
        } catch (SQLException e) {
e.printStackTrace();
        }
        return l ;
    }

    @Override
    public void delete(User p) {

        try {
            PreparedStatement st = cnx.prepareStatement("DELETE from user where id =?");
            st.setInt(1,p.getId());
            st.executeUpdate();
            System.out.println("supression reussite !!!!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User modify(User p) {
        try {
            PreparedStatement st = cnx.prepareStatement("update USER set mobile=?,age=?,nom=?,prenom=?,adresse=?," +
                    "email=?,password=? where id=?");
            st.setInt(1,p.getMobile());
            st.setInt(2,p.getAge());
            st.setString(3,p.getNom());
            st.setString(4,p.getPrenom());
            st.setString(5,p.getAdresse());
            st.setString(6,p.getEmail());
            st.setString(7,p.getPassword());
            st.setInt(8,p.getId());
            System.out.println("modification reussite !!!!!");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public User findById(int p) {
        User s = null ;
        try {
            PreparedStatement st = cnx.prepareStatement("select t.* from user t where id=?");
            st.setInt(1,p);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
             s = new User(rs.getInt(2),rs.getInt(3),rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getString(7),
                    rs.getString(8),rs.getBoolean(9));}

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }


    public User login(String email,String password)
    {
        User user = null ;
        try {
            PreparedStatement st = cnx.prepareStatement("select * from user where email=? and password=?");
            st.setString(1,email);
            st.setString(2,password);

            ResultSet rs =st.executeQuery();
            if (rs.next()){
              user = new User(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),
                    rs.getString(5),rs.getString(6),rs.getString(7),
                    rs.getString(8));}


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
       return user ;
    }
}
