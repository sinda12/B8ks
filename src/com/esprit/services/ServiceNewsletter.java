package com.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.esprit.entities.NewsLetter;
import com.esprit.entities.User;
import com.esprit.utils.DataSource;

public class ServiceNewsletter {
	
	Connection cnx= DataSource.getInstance().getCnx();

	public void create(NewsLetter n, User u) {
		try {
			String req="INSERT INTO Newsletter VALUES(null,?,?,?)";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setString(1,n.getDescription());
			st.setString(2, u.getNom());
			st.setString(3, u.getPrenom());
			st.executeUpdate();
			
			System.out.println("Newsletter Added Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void delete(NewsLetter n) {
		try {
			String req="DELETE FROM Newsletter WHERE id=?";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(1,n.getId());
			st.executeUpdate();
			
			System.out.println("Newsletter Deleted Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public void modify(NewsLetter n) {
		try {
			String req="UPDATE Newsletter set description=? WHERE id=? ";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(2,n.getId());
			st.setString(1,n.getDescription());
			st.executeUpdate();
			
			System.out.println("Newsletter Updated Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public List<NewsLetter>show(){
		List<NewsLetter> list=new ArrayList<>();
		try {
			String req="select * from Newsletter";
			PreparedStatement st = cnx.prepareStatement(req);
			ResultSet res =st.executeQuery(req);
			while (res.next()) {
				list.add(new NewsLetter(res.getInt("Id"),res.getString("description")));
			}
			
			System.out.println("Claim Listed");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
}
