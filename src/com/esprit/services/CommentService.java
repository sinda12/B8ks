package com.esprit.services;

import com.esprit.entities.Comment;
import com.esprit.interfaces.CommentServiceInterace;
import com.esprit.utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentService implements CommentServiceInterace {
    private Connection cnx;

    public CommentService() {
        cnx = DataSource.getInstance().getCnx();
    }
    @Override
    public void create(Comment comment) throws SQLException {
        String request;
        request = "INSERT INTO `comments` (`text`, `blog_id`, `user_id`) VALUES ('"+comment.getText()+"'," +
                comment.getBlog_id()+", "+comment.getUser_id()+ ");";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    @Override
    public void update(Comment comment) throws SQLException {
        String request = "UPDATE `comments` SET `text`=?,`blog_id`=?,`user_id`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(1, comment.getText());
        pst.setInt(2, comment.getBlog_id());
        pst.setInt(3,  comment.getUser_id());
        pst.setInt(4, comment.getId());
        pst.executeUpdate();

    }

    @Override
    public void deleteById(int id) throws SQLException {
        String request = "DELETE FROM `comments` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    @Override
    public List<Comment> getAll() throws SQLException {
        return null;
    }
    public List<Comment> findByBlogId(int id) throws SQLException {


        ArrayList<Comment> results = new ArrayList<>();
        String request = "SELECT * FROM `comments`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Comment a = new Comment();
            a.setId(rst.getInt("id"));
            a.setText(rst.getString("text"));

            results.add(a);
        }

        return results;

    }
}
