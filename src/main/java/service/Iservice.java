package service;

import java.util.List;

public interface Iservice <T> {
    public void adduser(T p);
    public List<T> getList();
    public void delete(T p);
    public T modify(T p);
    public T findById(int p);
}
