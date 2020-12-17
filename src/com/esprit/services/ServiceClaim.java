package com.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.esprit.entities.Claim;
import com.esprit.entities.User;
import com.esprit.utils.DataSource;

public class ServiceClaim {
	
	Connection cnx= DataSource.getInstance().getCnx();
	
	public void create(Claim c, User u) {
		try {
			String req="INSERT INTO Claim VALUES(null,?,?)";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setString(1,c.getDescription());
			st.setInt(2, u.getId());
			st.executeUpdate();
			
			System.out.println("Claim Added Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void delete(Claim c) {
		try {
			String req="DELETE FROM Claim WHERE id=?";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(1,c.getId());
			st.executeUpdate();
			
			System.out.println("Claim Deleted Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public void modify(Claim c) {
		try {
			String req="UPDATE Claim set description=? WHERE id=? ";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(2,c.getId());
			st.setString(1,c.getDescription());
			st.executeUpdate();
			
			System.out.println("Claim Updated Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public List<Claim>show(){
		List<Claim> list=new ArrayList<>();
		try {
			String req="select * from Claim";
			PreparedStatement st = cnx.prepareStatement(req);
			ResultSet res =st.executeQuery(req);
			while (res.next()) {
				list.add(new Claim(res.getInt("id"),res.getString("description")));
			}
			
			System.out.println("Claim Listed");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

}
