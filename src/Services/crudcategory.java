package Services;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Entity.Category;
import Utils.DataSource;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class crudcategory {

	/**
	 *
	 * @author gar4a
	 */

	    Connection cnx = DataSource.getInstance().getCnx();
	    
	    public void ajouter (Category c){
	    try{
	    String req = "INSERT INTO category (title) VALUES ('"+c.getTitle()+"')";
	    Statement st = (Statement) cnx.createStatement();
	    st.executeUpdate(req);
	    System.out.println("Catégorie ajoutée !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    }
	    
	    public void supprimer (Category c){
	    try{
	    String req = "DELETE from category WHERE id="+c.getId();
	    Statement st = (Statement) cnx.createStatement();
	    st.executeUpdate(req);
	    System.out.println("Catégorie supprimée !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    }
	    
	    public void modifier (Category c){
	    try{
	    String req = "UPDATE category SET title='"+c.getTitle()+"' WHERE id="+c.getId();
	    Statement st = (Statement) cnx.createStatement();
	    st.executeUpdate(req);
	    System.out.println("Catégorie modifiée !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    }
	    
	    public List<Category> afficher (){
	        List<Category> listCategory = new ArrayList<>();
	    try{
	    String req = "SELECT * From category";
	    Statement st = (Statement) cnx.createStatement();
	    ResultSet res = st.executeQuery(req);
	    while(res.next()){
	       // list.add(new Category(res.getInt("id"),res.getString("title")));
	       listCategory.add(new Category(res.getString("title")));
	    }
	    System.out.println("Catégorie récupérées !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    return listCategory;
	    }
	}
