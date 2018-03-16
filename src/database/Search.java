package database;

import database.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import database.pojo.*;


public class Search {
	public Search() {}
 
	// he puesto NIF pq en el checklist pedia buscar por algo distinto al id
	public Camper SearchCamper(Connection c , String NIF) throws SQLException {
		String sql = "SELECT * FROM camper WHERE NIF LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, NIF);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			Integer phonenumber = rs.getInt("phone_number");
			String email = rs.getString("email");
			String payment_method = rs.getString("payment_method");
			Camper camper = new Camper(id,name,dob,NIF,phonenumber,email,payment_method);
			System.out.println(camper);
			return camper;
	}
		return null;
	}
	
	public void SearchInstructor(Connection c , Integer id) throws SQLException {
		String sql = "SELECT * FROM instructor WHERE id LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			Integer phonenumber = rs.getInt("phone_number");
			String NIF = rs.getString("NIF");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			String nationality = rs.getString("nationality");
			Integer salary = rs.getInt("salary");
			Instructor instructor= new Instructor(id,name,phonenumber,dob,NIF,nationality,salary);
			System.out.println(instructor);
	}
	}
	
	public void SearchActivity(Connection c, Integer id) throws SQLException {
		String sql = "SELECT *FROM activity WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
		    Activity activity = new Activity(id, name,price);
		    System.out.println(activity);
		}
		
	}
	
	public void SearchMaterial(Connection c , Integer id)throws SQLException{
		String sql = "SELECT *FROM material WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
		    Material material = new Material(id, name,price);
		    System.out.println(material);
		}
	}
	
	public void SearchAccomodation(Connection c, Integer id) throws SQLException{
		String sql = "SELECT *FROM accomodation WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
		    Accomodation accomodation = new Accomodation(id, name,price);
		    System.out.println(accomodation);
		}
	}
	
	public void SearchTransport(Connection c, Integer id) throws SQLException{
		String sql = "SELECT *FROM transport WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
		    Transport trans = new Transport(id, name,price);
		    System.out.println(trans);
		}
	}
	
	
	
	
	
}
