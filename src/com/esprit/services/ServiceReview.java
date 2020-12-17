package com.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.esprit.models.Review;
import com.esprit.models.User;
import com.esprit.utils.DataSource;

public class ServiceReview {

	Connection cnx= DataSource.getInstance().getCnx();
	
	public void create(Review r,User u) {
		try {
			String req="INSERT INTO Review VALUES(null,?,sysdate(),?,?)";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setString(1,r.getReview());
                        st.setInt(2,r.getRate());
			st.setInt(3, u.getId());
			st.executeUpdate();
			
			System.out.println("Review Added Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void delete(Review r) {
		try {
			String req="DELETE FROM Review WHERE id=?";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(1,r.getId());
			st.executeUpdate();
			
			System.out.println("Review Deleted Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public void modify(Review r) {
		try {
			String req="UPDATE Review set review=?,reviewDate=sysdate(),rate=? WHERE id=? ";
			PreparedStatement st = cnx.prepareStatement(req);
			st.setInt(3,r.getId());
			st.setString(1,r.getReview());
			st.setInt(2,r.getRate());
			st.executeUpdate();
			
			System.out.println("Review Updated Successfully");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public List<Review>show(){
		List<Review> list=new ArrayList<>();
		try {
			String req="select * from Review";
			PreparedStatement st = cnx.prepareStatement(req);
			ResultSet res =st.executeQuery(req);
			while (res.next()) {
				list.add(new Review(res.getInt("Id"),res.getString("review"),res.getString("reviewDate"),res.getInt("rate")));
			}
			
			System.out.println("User listed");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
}
