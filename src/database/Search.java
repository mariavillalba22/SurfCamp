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
	Connection c;
	public Search(Connection c) {
		this.c=c;
	}
 
	//We put NIF because in the check list it said that we have to search an object with 
	//something different that the primary key
	public Camper searchCamper( String NIF) throws SQLException {
		String sql = "SELECT * FROM camper WHERE NIF LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, NIF);
		ResultSet rs = prep.executeQuery();
		Camper camper = new Camper();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			Integer phonenumber = rs.getInt("phone_number");
			String email = rs.getString("email");
			String payment_method = rs.getString("payment_method");
			Integer needtopay = rs.getInt("needtopay");
			camper = new Camper(id,name,dob,NIF,phonenumber,email,payment_method,needtopay);
			
			
	}
		return camper;
	}
	
	public Camper searchCamper( Integer id) throws SQLException {
		String sql = "SELECT * FROM camper WHERE id LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Camper camper = new Camper();
		while (rs.next()) {
			String NIF = rs.getString("NIF");
			String name = rs.getString("name");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			Integer phonenumber = rs.getInt("phone_number");
			String email = rs.getString("email");
			String payment_method = rs.getString("payment_method");
			Integer needtopay = rs.getInt("needtopay");
			camper = new Camper(id,name,dob,NIF,phonenumber,email,payment_method,needtopay);
			
			
	}
		return camper;
	}
	
	public Instructor searchInstructor( Integer id) throws SQLException {
		String sql = "SELECT * FROM instructor WHERE id LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Instructor instructor = new Instructor();
		while (rs.next()) {
			String name = rs.getString("name");
			Integer phonenumber = rs.getInt("phone_number");
			String NIF = rs.getString("NIF");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			String nationality = rs.getString("nationality");
			Integer salary = rs.getInt("salary");
			instructor= new Instructor(id,name,phonenumber,dob,NIF,nationality,salary);
			
	}
		return instructor;
	}
	
	public Activity searchActivity( Integer id) throws SQLException {
		String sql = "SELECT *FROM activity WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Activity activity = new Activity();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    activity = new Activity(id, name,price, availability);
		  
		}
		return activity;
	}
	public Activity searchActivityN( String name) throws SQLException {
		String sql = "SELECT *FROM activity WHERE name LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setString(1, name);
		ResultSet rs = prep.executeQuery();
		Activity activity = new Activity();
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Integer price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    activity = new Activity(id, name,price, availability);
		  
		}
		return activity;
	}
	
	public Material searchMaterial( Integer id)throws SQLException{
		String sql = "SELECT *FROM material WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Material material = new Material();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
		    material = new Material(id, name,price);
		    System.out.println(material);
		}
		return material;
	}
	
	public Material searchMaterialN( String name)throws SQLException{
		String sql = "SELECT *FROM material WHERE name LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setString(1, name);
		ResultSet rs = prep.executeQuery();
		Material material = new Material();
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Integer price = rs.getInt("price");
		    material = new Material(id, name,price);
		    System.out.println(material);
		}
		return material;
	}
	public Accomodation searchAccomodation( Integer id) throws SQLException{
		String sql = "SELECT *FROM accomodation WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Accomodation accomodation = new Accomodation();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    accomodation = new Accomodation(id, name,price, availability);
		    
		}
		return accomodation;
	}
	
	public Accomodation searchAccomodationN( String name) throws SQLException{
		String sql = "SELECT *FROM accomodation WHERE name LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setString(1, name);
		ResultSet rs = prep.executeQuery();
		Accomodation accomodation = new Accomodation();
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Integer price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    accomodation = new Accomodation(id, name,price,availability);
		    
		}
		return accomodation;
	}
	
	public Transport searchTransportN(String name) throws SQLException{
		String sql = "SELECT *FROM transport WHERE name LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setString(1, name);
		ResultSet rs = prep.executeQuery();
		Transport trans= new Transport();
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Integer price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    trans = new Transport(id, name,price, availability);
		}
		return trans;
	}
	
	public Transport searchTransport(Integer id) throws SQLException{
		String sql = "SELECT *FROM transport WHERE id LIKE ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		Transport trans= new Transport();
		while(rs.next()) {
			String name = rs.getString("name");
			Integer price = rs.getInt("price");
			Integer availability = rs.getInt("availability");
		    trans = new Transport(id, name,price, availability);
		  
		}
		return trans;
	}
	
	
	
	
	
}
