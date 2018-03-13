package database;

import database.pojo.*;

import database.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {

	public void deleteCamperId (Connection c, int id) throws SQLException {
        
		String sql = "DELETE  FROM camper WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, id);
		prep.executeUpdate();
		System.out.println("Deletion finished");
			
	}
	
	public void deleteCamperName (Connection c, String id) throws SQLException {
        
		String sql = "DELETE  FROM camper WHERE name = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, name);
		prep.executeUpdate();
		System.out.println("Deletion finished");
			
	}
	
	
}
