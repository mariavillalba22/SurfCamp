package database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import database.pojo.Camper;

public class Insertion {
	
		Connection c;
		public Insertion() {
			
		}
	public void insert (Connection c,Camper camper ) throws SQLException{
		String sql1 = "INSERT INTO camper (name, dateofbirth, NIF,phonenumber,email,payment_method,"+/*"transports"
				+ "accomodation,materials,activity) "*/
				 "VALUES (?,?,?,?,?,?,?);";
		PreparedStatement sql = c.prepareStatement(sql1);
		sql.setString(1, camper.getName());
		sql.setDate(2, camper.getDateofbirth());
		sql.setString(3, camper.getNIF());
		sql.setInt(4, camper.getPhonenumber());
		sql.setString(5, camper.getEmail());
		sql.setString(6, camper.getPayment_method());
		/*sql.setAccomodation(7, camper.getAccomodation());
		sql.setTransport(8, camper.getTransports());
		sql.setMaterial(9, camper.getMaterials());
		sql.setActivity(10, camper.getActivity);*/
		
		sql.executeUpdate();
		sql.close();
	}
	
}
