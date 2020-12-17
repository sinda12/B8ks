package com.esprit.services;

import com.esprit.entities.Blog;
import com.esprit.interfaces.BlogServiceInterface;
import com.esprit.utils.DataSource;
//import com.esprit.util.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogService implements BlogServiceInterface {
    private Connection cnx;

    public BlogService() {
        cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void create(Blog blog) throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("insert into blogs values (?,?,?,?,?,?,?,?,?)");
        pst.setInt(1, blog.getId());
        pst.setString(2, blog.getTitle());
        pst.setString(3,  blog.getCategory());
        pst.setString(4, blog.getText());
        pst.setInt(5, blog.getReport());
        pst.setInt(6, blog.getLikes());
        pst.setInt(7, blog.getDislikes());
        pst.setString(8,blog.getDate());
        pst.setInt(9,blog.getUser().getId());
        pst.executeUpdate();
    }

    @Override
    public void update(Blog blog) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("update blogs set title=?,catgory=?,text=?,report=?,likes=?,dislikes=?,Datee=? where id=?");


        pst.setString(1, blog.getTitle());
        pst.setString(2,  blog.getCategory());
        pst.setString(3, blog.getText());
        pst.setInt(4, blog.getReport());
        pst.setInt(5, blog.getLikes());
        pst.setInt(6, blog.getDislikes());
        pst.setString(7,blog.getDate());
        pst.setInt(8,blog.getId());
        pst.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String request = "DELETE FROM `blogs` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);

    }

    @Override
    public List<Blog> getAll() throws SQLException {


        ArrayList<Blog> results = new ArrayList<>();
        String request = "SELECT * FROM `blogs`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Blog a = new Blog();
            a.setId(rst.getInt("id"));
            a.setTitle(rst.getString("title"));
            a.setCategory(rst.getString("category"));
            a.setText(rst.getString("text"));
            a.setLikes(rst.getInt("likes"));
            a.setDislikes(rst.getInt("dislikes"));
            a.setReport(rst.getInt("report"));
            a.setDate(rst.getString("Datee"));
            results.add(a);
        }

        return results;
    }

    @Override
    public Blog getBlogById(int id) throws SQLException {
        String request = "SELECT * FROM `blogs` WHERE id="+id;
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        Blog a = new Blog();
        while (rst.next()) {
            a.setId(rst.getInt("id"));
            a.setText(rst.getString("text"));
            a.setLikes(rst.getInt("likes"));
            a.setDislikes(rst.getInt("dislikes"));
            a.setReport(rst.getInt("report"));
            a.setDate(rst.getString("Date"));
        }
        return a;
    }

    @Override
    public void updateLDR(Blog blog) throws SQLException {
        PreparedStatement pst = cnx.prepareStatement("update blogs set report=?,likes=?,dislikes=? where id=?");
        pst.setInt(1, blog.getReport());
        pst.setInt(2, blog.getLikes());
        pst.setInt(3, blog.getDislikes());
        pst.setInt(4,blog.getId());
        pst.executeUpdate();
    }
}


