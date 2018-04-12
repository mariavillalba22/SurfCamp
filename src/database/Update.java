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



public class Update {

	public void  UpdateMaterial(Connection c, Material mat) throws SQLException {
		String sql = "UPDATE material SET name=?, price = ? WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, mat.getName());
		prep.setInt(2, mat.getPrice());
		prep.setInt(3, mat.getId());
		prep.executeUpdate();
	}
	
	public void UpdateAccomodation (Connection c, Accomodation acom) throws SQLException {
		String sql = "UPDATE accomodation SET name = ?, price =? WHERE id = ?";
		PreparedStatement prep = c.prepareStatement(sql);

		prep.setString(1, acom.getName());
		prep.setInt(2, acom.getPrice());
		prep.setInt(3, acom.getId());

		prep.executeUpdate();
		
	}
	
	public void UpdateActivity (Connection c, Activity act) throws SQLException {
		String sql = "UPDATE activity SET name = ?, price =? WHERE id = ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, act.getName());
		prep.setInt(2, act.getPrice());
		prep.setInt(3, act.getId());
		prep.executeUpdate();
	}
	
	
	public void UpdateInstructor (Connection c, Instructor ins) throws SQLException {
		String sql = "UPDATE instructor SET name =?, phone_number =?, dob =?, NIF =?, nationality =?, salary =? WHERE id = ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, ins.getName());
		prep.setInt(2, ins.getPhoneNumber());
		prep.setDate(3, ins.getDob());
		prep.setString(4, ins.getNIF());
		prep.setString(5, ins.getNationality());
		prep.setInt(6, ins.getSalary());
		prep.setInt(7, ins.getId());
		prep.executeUpdate();
		
	}
	
	public void UpdateCamper (Connection c, Camper cam) throws SQLException{
		String sql = "UPDATE instructor SET name =?, phoneNumber =?, dob =?. NIF =?, email =?, payment_method =? WHERE id = ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, cam.getName());
		prep.setInt(2, cam.getPhonenumber());
		prep.setDate(3, cam.getDateofbirth());
		prep.setString(4, cam.getNIF());
		prep.setString(5, cam.getEmail());
		prep.setString(6, cam.getPayment_method());
		prep.setInt(7, cam.getId());
		prep.executeUpdate();
	}
	

}
