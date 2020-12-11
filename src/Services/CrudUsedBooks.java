package Services;




import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Entity.usedbook;
import Utils.DataSource;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CrudUsedBooks {



	    Connection cnx = DataSource.getInstance().getCnx();
	    
	    public void ajouter (usedbook b){
	    try{
	    String req = "INSERT INTO usedbook1 (titre,prix,auteur,description,datepub) VALUES (?,?,?,?,?)";
	    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
	    st.setString(1, b.getTitre());
	    st.setDouble(2, b.getPrix());
	    st.setString(3, b.getAuteur());
	    st.setString(4, b.getDescription());
	    st.setString(5, b.getDatepub());
	    
	    st.executeUpdate();
	    System.out.println("Livre ajoutée !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    }
	    
	    public void supprimer (usedbook b){
	    try{
	    String req = "DELETE from usedbook1 WHERE id=?";
	    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
	    st.setInt(1, b.getId());
	    st.executeUpdate();
	    System.out.println("Livre supprimé !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    }
	    
	    public void modifier (usedbook b){
	    try{
	    String req = "UPDATE usedbook1 SET titre=?, prix=?, auteur=?, description=? ,datepub=? WHERE id=?";
	    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
	    st.setInt(6, b.getId());
	    st.setString(1, b.getTitre());
	    st.setDouble(2, b.getPrix());
	    st.setString(3, b.getAuteur());
	    st.setString(4,  b.getDescription());
	    st.setString(5, b.getDatepub());
	    st.executeUpdate();
	    System.out.println("Livre modifié !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    }
	    
	    public List<usedbook> afficher (){
	        List<usedbook> listusedbook = new ArrayList<>();
	    try{
	    String req = "SELECT * From usedbook1";
	    PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
	    ResultSet res = st.executeQuery();
	    while(res.next()){
	       // list.add(new Category(res.getInt("id"),res.getString("title")));
	 listusedbook.add(new usedbook(res.getInt("id"),res.getString("titre"),res.getDouble("prix"), res.getString("auteur"),res.getString("description"), res.getString("datepub")));
	    }
	    System.out.println("book récupérées !");
	    }catch(SQLException ex){
	    System.out.println(ex.getMessage());
	    }
	    return listusedbook;
	    }

		//public void modifier(int i, String string, int j, String string2, String string3, String string4) {
			// TODO Auto-generated method stub
			
		//}
	}
