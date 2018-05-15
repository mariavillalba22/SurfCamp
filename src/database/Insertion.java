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
    	PreparedStatement sql = c.prepareStatement(sql1);
		sql.setInt(1, transport.getId());
		sql.setInt(2, camper.getId());
		
		sql.executeUpdate();
		sql.close();
    }
    
    public void insertAccomInC(Camper camper, Accomodation accomodation) throws SQLException {
    	String sql1 = "UPDATE camper SET accomodation_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement sql = c.prepareStatement(sql1);
		sql.setInt(1, accomodation.getId());
		sql.setInt(2, camper.getId());
		
		sql.executeUpdate();
		sql.close();
    }
    
    
    public void insertTransInI(Instructor instructor, Transport transport) throws SQLException {
    	String sql1 = "UPDATE instructor SET transport_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement sql = c.prepareStatement(sql1);
		sql.setInt(1, transport.getId());
		sql.setInt(2, instructor.getId());
		
		sql.executeUpdate();
		sql.close();
    }
    
    public void insertAccomInI(Instructor instructor, Accomodation accomodation) throws SQLException {
    	String sql1 = "UPDATE instructor SET accomodation_id = ? "+
				 "WHERE id = ?";
    	PreparedStatement sql = c.prepareStatement(sql1);
		sql.setInt(1, accomodation.getId());
		sql.setInt(2, instructor.getId());
		
		sql.executeUpdate();
		sql.close();
    }

	public void insertCamper (Camper camper ) throws Exception{
		String sql1 = "INSERT INTO camper (name, dob, NIF, phone_number, email, payment_method, needtopay)"+
				 "VALUES (?,?,?,?,?,?,?);";
		PreparedStatement sql = c.prepareStatement(sql1);
		sql.setString(1, camper.getName());
		sql.setDate(2, camper.getDateofbirth());
		sql.setString(3, camper.getNIF());
		sql.setInt(4, camper.getPhonenumber());
		sql.setString(5, camper.getEmail());
		sql.setString(6, camper.getPayment_method());
		sql.setInt(7, camper.getNeedtopay());
     
		
		sql.executeUpdate();
		sql.close();

		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		camper.setId(lastId);
	}
	
	



	public void insertCamper_material( Camper camper, Material material) throws SQLException{

		String sql9="INSERT INTO camper_material(id_camper, id_material)"+ 
					"VALUES(?,?)";
		PreparedStatement sql = c.prepareStatement(sql9);
		sql.setInt(1,camper.getId());
		sql.setInt(2, material.getId());
	
		sql.executeUpdate();
		sql.close();
		
	}
	
	public void insertCamper_activity( Camper camper, Activity activity)throws SQLException{
		String sql10="INSERT INTO camper_activity(id_camper, id_activity)"+ 
					"VALUES(?,?);";
	
		PreparedStatement sql = c.prepareStatement(sql10);
		sql.setInt(1,camper.getId());
		sql.setInt(2, activity.getId());
	
		sql.executeUpdate();
		sql.close();
	}
	
	
	public void insertMaterial_activity(Material material, Activity activity)throws SQLException{
		String sql11="INSERT INTO material_activity(id_material, id_activity)"+ 
					"VALUES(?,?);";
	
		PreparedStatement sql = c.prepareStatement(sql11);
		sql.setInt(1,material.getId());
		sql.setInt(2, activity.getId());
		sql.executeUpdate();
		sql.close();
	}
	
	public Accomodation insertAccomodation (Accomodation accomodation ) throws SQLException{
		String sql2 = "INSERT INTO accomodation (name, price, availability)"+
				"VALUES (?,?,?);";
		PreparedStatement sql = c.prepareStatement(sql2);
		sql.setString(1, accomodation.getAccomodation());
		sql.setInt(2, accomodation.getPrice());
		sql.setInt(3, accomodation.getAvailability());
	
		sql.executeUpdate();
		sql.close();
		
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
		PreparedStatement sql = c.prepareStatement(sql3);
		sql.setString(1, activity.getActivity());
		sql.setInt(2, activity.getPrice());
		sql.setInt(3, activity.getAvailability());
		
	
		sql.executeUpdate();
		sql.close();
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
    	PreparedStatement sql = c.prepareStatement(sql1);
		sql.setInt(1, instructor.getId());
		sql.setInt(2, activity.getId());
		
		sql.executeUpdate();
		sql.close();
    }
	
	public Material insertMaterial (Material material ) throws SQLException{
		String sql4 = "INSERT INTO material (name, price)"+
				"VALUES (?,?);";
		PreparedStatement sql = c.prepareStatement(sql4);
		sql.setString(1, material.getMaterial());
		sql.setInt(2, material.getPrice());
	
		sql.executeUpdate();
		sql.close();

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
		PreparedStatement sql = c.prepareStatement(sql5);
		sql.setString(1, transport.getType_transport());
		sql.setInt(2, transport.getPrice());
		sql.setInt(3, transport.getAvailable());
		sql.executeUpdate();
		sql.close();
		
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
		PreparedStatement sql = c.prepareStatement(sql6);
		sql.setString(1, instructor.getName());
		sql.setInt(2, instructor.getPhoneNumber());
		sql.setDate(3, instructor.getDob());
		sql.setString(4, instructor.getNIF());
		sql.setString(5, instructor.getNationality());
		sql.setInt(6, instructor.getSalary());
		
		sql.executeUpdate();
		sql.close();
		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs1 = p.executeQuery();
		Integer lastId = rs1.getInt("lastId");
		instructor.setId(lastId);
		return instructor;
	}
	
}
