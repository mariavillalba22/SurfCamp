package database;

import database.pojo.*;

import database.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {

	public void deleteCamperId (Connection c, int camperID) throws SQLException {
        
		String sql = "DELETE  FROM camper WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, camperID);
		prep.executeUpdate();
		System.out.println("Deletion finished");
			
	}
	
	public void deleteTransportID (Connection c, int transportID) throws SQLException {
        
		String sql = "DELETE  FROM transport WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, transportID);
		prep.executeUpdate();
		System.out.println("Deletion finished");
			
	}
	
public void deleteInstructorID (Connection c, int instructorID) throws SQLException {
        
		String sql = "DELETE  FROM transport WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, instructorID);
		prep.executeUpdate();
		System.out.println("Deletion finished");
			
	}

public void deleteMaterialtID (Connection c, int materialID) throws SQLException {
    
	String sql = "DELETE  FROM transport WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, materialID);
	prep.executeUpdate();
	System.out.println("Deletion finished");
		
}

public void deleteAccomodationID (Connection c, int accomodationID) throws SQLException {
    
	String sql = "DELETE  FROM transport WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, accomodationID);
	prep.executeUpdate();
	System.out.println("Deletion finished");
		
}

public void deleteActivityID (Connection c, int activityID) throws SQLException {
    
	String sql = "DELETE  FROM transport WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, activityID);
	prep.executeUpdate();
	System.out.println("Deletion finished");
		
}
	
	
	
}
