package database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import database.pojo.Accomodation;
import database.pojo.Activity;
import database.pojo.Camper;
import database.pojo.Instructor;
import database.pojo.Material;
import database.pojo.Transport;

public class Insertion {
	
		public Insertion() {
			
		}
	public void insertCamper (Connection c,Camper camper ) throws SQLException{
		String sql1 = "INSERT INTO camper (name, dob, NIF,phone_number,email,payment_method)"+/*"transports"
				+ "accomodation,materials,activity) "*/
				 "VALUES (?,?,?,?,?,?);";
		PreparedStatement sql = c.prepareStatement(sql1);
		sql.setString(1, camper.getName());
		sql.setDate(2, camper.getDateofbirth());
		sql.setString(3, camper.getNIF());
		sql.setInt(4, camper.getPhonenumber());
		sql.setString(5, camper.getEmail());
		sql.setString(6, camper.getPayment_method());
		/*sql.setInt(7, getAccomodation(camper.getId());
		sql.setTransport(8, camper.getTransports());
		sql.setMaterial(9, camper.getMaterials());
		sql.setActivity(10, camper.getActivity);*/
		
		sql.executeUpdate();
		sql.close();
	}
	
	public void insertCamperTodo (Connection c,Camper camper ) throws SQLException{
		String sql1 = "INSERT INTO camper (name, dob, NIF,phone_number,email,payment_method,transport_id)"+/*"transports"
				+ "accomodation,materials,activity) "*/
				 "VALUES (?,?,?,?,?,?,?,?);";
		PreparedStatement sql = c.prepareStatement(sql1);
		sql.setString(1, camper.getName());
		sql.setDate(2, camper.getDateofbirth());
		sql.setString(3, camper.getNIF());
		sql.setInt(4, camper.getPhonenumber());
		sql.setString(5, camper.getEmail());
		sql.setString(6, camper.getPayment_method());
		sql.setInt(7, camper.getTransport_id());
		sql.setInt(8, camper.getAccomodation_id());
		/*sql.setInt(7, getAccomodation(camper.getId());
		sql.setTransport(8, camper.getTransports());
		sql.setMaterial(9, camper.getMaterials());
		sql.setActivity(10, camper.getActivity);*/
		
		sql.executeUpdate();
		sql.close();
	}
	public void insertAccomodation (Connection c,Accomodation accomodation ) throws SQLException{
		String sql2 = "INSERT INTO accomodation (name, price)"+
				"VALUES (?,?);";
		PreparedStatement sql = c.prepareStatement(sql2);
		sql.setString(1, accomodation.getAccomodation());
		sql.setInt(2, accomodation.getPrice());
	
		sql.executeUpdate();
		sql.close();
	}
	public void insertActivity (Connection c,Activity activity ) throws SQLException{
		String sql3 = "INSERT INTO activity (name, price)"+
				"VALUES (?,?);";
		PreparedStatement sql = c.prepareStatement(sql3);
		sql.setString(1, activity.getActivity());
		sql.setInt(2, activity.getPrice());
	
		sql.executeUpdate();
		sql.close();
	}
	public void insertMaterial (Connection c, Material material ) throws SQLException{
		String sql4 = "INSERT INTO material (name, price)"+
				"VALUES (?,?);";
		PreparedStatement sql = c.prepareStatement(sql4);
		sql.setString(1, material.getMaterial());
		sql.setInt(2, material.getPrice());
	
		sql.executeUpdate();
		sql.close();
	}
	public void insertTransport (Connection c, Transport transport ) throws SQLException{
		String sql5 = "INSERT INTO transport (name, price)"+
				"VALUES (?,?);";
		PreparedStatement sql = c.prepareStatement(sql5);
		sql.setString(1, transport.getType_transport());
		sql.setInt(2, transport.getPrice());
	
		sql.executeUpdate();
		sql.close();
	}
	public void insertInstructor (Connection c,Instructor instructor ) throws SQLException{
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
	}
	
}
