package com.esprit.interfaces;

import com.esprit.entities.Blog;

import java.sql.SQLException;
import java.util.List;

public interface BlogServiceInterface {

    public void create(Blog blog) throws SQLException;
    public void update(Blog blog) throws SQLException;
    public void deleteById(int Id) throws SQLException;
    public List<Blog> getAll() throws SQLException;
    public Blog getBlogById(int id) throws SQLException;
    public void updateLDR(Blog blog) throws SQLException;

}
