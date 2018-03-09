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
	public void SearchCamper(Connection c , String NIF) throws SQLException {
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
	}
	}
	
	
	
	
}
