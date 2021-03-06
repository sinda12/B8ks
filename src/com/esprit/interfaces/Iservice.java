package com.esprit.interfaces;

import com.esprit.entities.User;

import java.util.List;

public interface Iservice<T> {
    public void addUser(T p);
    public List<T> getList();
    public void delete(int id);
    public T modify(T p);
    public T findById(int p);
    public void delete(T p);
}
