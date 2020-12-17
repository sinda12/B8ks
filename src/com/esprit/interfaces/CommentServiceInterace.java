package com.esprit.interfaces;

import com.esprit.entities.Comment;

import java.sql.SQLException;
import java.util.List;

public interface CommentServiceInterace {
    public void create(Comment comment) throws SQLException;
    public void update(Comment comment) throws SQLException;
    public void deleteById(int Id) throws SQLException;
    public List<Comment> getAll() throws SQLException;
}
