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
 
	public void SearchCamper(Connection c , int id) throws SQLException {
		String sql = "SELECT * FROM camper WHERE id LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			String NIF = rs.getString("NIF");
			Integer phonenumber = rs.getInt("phone_number");
			String email = rs.getString("email");
			String payment_method = rs.getString("payment_method");
			Camper camper = new Camper(id,name,dob,NIF,phonenumber,email,payment_method);
			System.out.println(camper);

	}
	}
}
