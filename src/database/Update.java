package database;


import database.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import database.pojo.*;



public class Update {

	public void  UpdateMaterial(Connection c, int id, String name, int price) throws SQLException {
		String sql = "UPDATE material SET name=?, price = ? WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1,name);
		prep.setInt(2, price);
		prep.setInt(3,id);
		prep.executeUpdate();
	}
	
	public void UpdateAccomodation (Connection c, int id, String name, int price ) throws SQLException {
		String sql = "UPDATE accomodation SET name = ?,price =? WHERE id = ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, name);
		prep.setInt(2, id);
		prep.setInt(3, id);
		prep.executeUpdate();
		
	}
	
	
	
	
}
