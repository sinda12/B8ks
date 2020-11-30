package service;


import entities.User;
import utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServiceUser implements Iservice<User>  {

Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void add(User p) {
        try {
            PreparedStatement st = cnx.prepareStatement("INSERT into USER (mobile, age, nom, prenom, adresse, email, password, isAdmin) values (?,?,?,?,?,?,?,?)");
            st.setInt(1,p.getMobile());
            st.setInt(2,p.getAge());
            st.setString(3,p.getNom());
            st.setString(4,p.getPrenom());
            st.setString(5,p.getAdresse());
            st.setString(6,p.getEmail());
            st.setString(7,p.getPassword());
            st.setBoolean(8,p.getAdmin());
            st.executeUpdate();
            System.out.println("ajout reussi !!!");

        } catch (SQLException e) {
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
                    "email=?,password=?,isAdmin=? where id=?");
            st.setInt(1,p.getMobile());
            st.setInt(2,p.getAge());
            st.setString(3,p.getNom());
            st.setString(4,p.getPrenom());
            st.setString(5,p.getAdresse());
            st.setString(6,p.getEmail());
            st.setString(7,p.getPassword());
            st.setBoolean(8,p.getAdmin());
            st.setInt(9,p.getId());
            System.out.println("modification reussite !!!!!");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }
}
