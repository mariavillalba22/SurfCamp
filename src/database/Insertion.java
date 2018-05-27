package database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.pojo.Accomodation;
import database.pojo.Activity;
import database.pojo.Camper;
import database.pojo.Instructor;
import database.pojo.Material;
import database.pojo.Transport;

public class Insertion {

	Connection c;
		public Insertion(Connection c) {	
			this.c =c;
		}	
		
    public void insertTransInC(Camper camper, Transport transport) throws SQLException {
    	String sql1 = "UPDATE camper SET transport_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement prep = c.prepareStatement(sql1);
		prep.setInt(1, transport.getId());
		prep.setInt(2, camper.getId());
		
		prep.executeUpdate();
		prep.close();
    }
    
    public void insertAccomInC(Camper camper, Accomodation accomodation) throws SQLException {
    	String sql1 = "UPDATE camper SET accomodation_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement prep = c.prepareStatement(sql1);
		prep.setInt(1, accomodation.getId());
		prep.setInt(2, camper.getId());
		
		prep.executeUpdate();
		prep.close();
    }
    
    
    public void insertTransInI(Instructor instructor, Transport transport) throws SQLException {
    	String sql1 = "UPDATE instructor SET transport_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement prep = c.prepareStatement(sql1);
		prep.setInt(1, transport.getId());
		prep.setInt(2, instructor.getId());
		
		prep.executeUpdate();
		prep.close();
    }
    
    public void insertAccomInI(Instructor instructor, Accomodation accomodation) throws SQLException {
    	String sql1 = "UPDATE instructor SET accomodation_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement prep = c.prepareStatement(sql1);
		prep.setInt(1, accomodation.getId());
		prep.setInt(2, instructor.getId());
		
		prep.executeUpdate();
		prep.close();
    }

	public void insertCamper (Camper camper ) throws Exception{
		String sql1 = "INSERT INTO camper (name, dob, NIF, phone_number, email, payment_method, needtopay)"+
				 "VALUES (?,?,?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql1);
		prep.setString(1, camper.getName());
		prep.setDate(2, camper.getDateofbirth());
		prep.setString(3, camper.getNIF());
		prep.setInt(4, camper.getPhonenumber());
		prep.setString(5, camper.getEmail());
		prep.setString(6, camper.getPayment_method());
		prep.setInt(7, camper.getNeedtopay());
     
		
		prep.executeUpdate();
		prep.close();

		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		camper.setId(lastId);
	}
	
	



	public void insertCamper_material( Camper camper, Material material) throws SQLException{

		String sql9="INSERT INTO camper_material(id_camper, id_material)"+ 
					"VALUES(?,?)";
		PreparedStatement prep = c.prepareStatement(sql9);
		prep.setInt(1,camper.getId());
		prep.setInt(2, material.getId());
	
		prep.executeUpdate();
		prep.close();
		
	}
	
	public void insertCamper_activity( Camper camper, Activity activity)throws SQLException{
		String sql10="INSERT INTO camper_activity(id_camper, id_activity)"+ 
					"VALUES(?,?);";
	
		PreparedStatement prep = c.prepareStatement(sql10);
		prep.setInt(1,camper.getId());
		prep.setInt(2, activity.getId());
	
		prep.executeUpdate();
		prep.close();
	}
	
	
	
	public Accomodation insertAccomodation (Accomodation accomodation ) throws SQLException{
		String sql2 = "INSERT INTO accomodation (name, price, availability)"+
				"VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql2);
		prep.setString(1, accomodation.getAccomodation());
		prep.setInt(2, accomodation.getPrice());
		prep.setInt(3, accomodation.getAvailability());
	
		prep.executeUpdate();
		prep.close();
		
		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		accomodation.setId(lastId);
		return accomodation;
	}
	
	public Activity insertActivity (Activity activity) throws Exception{
		String sql3 = "INSERT INTO activity (name, price, availability)"+
				"VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql3);
		prep.setString(1, activity.getActivity());
		prep.setInt(2, activity.getPrice());
		prep.setInt(3, activity.getAvailability());
		
	
		prep.executeUpdate();
		prep.close();
		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		activity.setId(lastId);
		
		return activity;
	}
	
	public void insertInstructorInA(Instructor instructor, Activity activity) throws SQLException {
    	String sql1 = "UPDATE activity SET instructor_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement prep = c.prepareStatement(sql1);
		prep.setInt(1, instructor.getId());
		prep.setInt(2, activity.getId());
		
		prep.executeUpdate();
		prep.close();
    }
	
	public Material insertMaterial (Material material ) throws SQLException{
		String sql4 = "INSERT INTO material (name, price)"+
				"VALUES (?,?);";
		PreparedStatement prep = c.prepareStatement(sql4);
		prep.setString(1, material.getMaterial());
		prep.setInt(2, material.getPrice());
	
		prep.executeUpdate();
		prep.close();

		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		material.setId(lastId);
		return material;
	}
	
	public Transport insertTransport (Transport transport ) throws SQLException{
		String sql5 = "INSERT INTO transport (name, price, availability)"+
				"VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql5);
		prep.setString(1, transport.getType_transport());
		prep.setInt(2, transport.getPrice());
		prep.setInt(3, transport.getAvailable());
		prep.executeUpdate();
		prep.close();
		
		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		transport.setId(lastId);
		return transport;
	}
	
	public Instructor insertInstructor (Instructor instructor ) throws SQLException{
		String sql6 = "INSERT INTO instructor (name,phone_number,dob,NIF,nationality,salary)"+
				 "VALUES (?,?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql6);
		prep.setString(1, instructor.getName());
		prep.setInt(2, instructor.getPhoneNumber());
		prep.setDate(3, instructor.getDob());
		prep.setString(4, instructor.getNIF());
		prep.setString(5, instructor.getNationality());
		prep.setInt(6, instructor.getSalary());
		
		prep.executeUpdate();
		prep.close();
		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		instructor.setId(lastId);
		return instructor;
	}
	
}
