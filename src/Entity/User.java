package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User  {
    private int id,mobile, age;
    private String nom,prenom,adresse,email,password;
    private Boolean isAdmin ;
    private List<Order> orders = new ArrayList<Order>();
    private List<Blog> blogs = new ArrayList<Blog>() ;
    private List<UsedBook> usedBooks = new ArrayList<UsedBook>() ;
    private List<Claim> claims = new ArrayList<Claim>() ;
    private List<NewsLetter> newsLetters = new ArrayList<NewsLetter>() ;

    public User() {
    }

    public User(int id, int mobile, int age, String nom, String prenom, String adresse, String email, String password, Boolean isAdmin, List<Order> orders, List<Blog> blogs, List<UsedBook> usedBooks) {
        this.id = id;
        this.mobile = mobile;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.orders = orders;
        this.blogs = blogs;
        this.usedBooks = usedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<UsedBook> getUsedBooks() {
        return usedBooks;
    }

    public void setUsedBooks(List<UsedBook> usedBooks) {
        this.usedBooks = usedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                mobile == user.mobile &&
                age == user.age &&
                Objects.equals(nom, user.nom) &&
                Objects.equals(prenom, user.prenom) &&
                Objects.equals(adresse, user.adresse) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(isAdmin, user.isAdmin) &&
                Objects.equals(orders, user.orders) &&
                Objects.equals(blogs, user.blogs) &&
                Objects.equals(usedBooks, user.usedBooks);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobile=" + mobile +
                ", age=" + age +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", orders=" + orders +
                ", blogs=" + blogs +
                ", usedBooks=" + usedBooks +
                '}';
    }
}
