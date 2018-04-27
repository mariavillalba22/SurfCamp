package database;

import database.pojo.*;

import database.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {
	Connection c;
	public Delete(Connection c) {
		this.c=c;
	}

	public void deleteCamperId ( int camperID) throws SQLException {
		Statement stmt = c.createStatement();
		String sql = "DELETE FROM camper WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, camperID);
		prep.executeUpdate();			
	}
	
	public void deleteCamperIdfromM ( int camperID) throws SQLException {
		Statement stmt = c.createStatement();
		String sql = "DELETE FROM camper_material WHERE id_camper = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, camperID);
		prep.executeUpdate();			
	}
	public void deleteCamperIdfromA ( int camperID) throws SQLException {
		Statement stmt = c.createStatement();
		String sql = "DELETE FROM camper_activity WHERE id_camper = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, camperID);
		prep.executeUpdate();			
	}
	
	
	public void deleteTransportID ( int transportID) throws SQLException {
		Statement stmt = c.createStatement();
		String sql = "DELETE  FROM transport WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, transportID);
		prep.executeUpdate();
			
	}
	
    public boolean deleteInstructorID ( int instructorID) throws SQLException {
        
		String sql = "DELETE  FROM instructor WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, instructorID);
		prep.executeUpdate();
		return true;
			
	}

   public boolean deleteMaterialtID ( int materialID) throws SQLException {
    
	String sql = "DELETE  FROM material WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, materialID);
	prep.executeUpdate();
	return true;
		
}

public boolean deleteAccomodationID ( int accomodationID) throws SQLException {
    
	String sql = "DELETE  FROM accomodation WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, accomodationID);
	prep.executeUpdate();
	return true;
		
}

public void deleteActivityID ( int activityID) throws SQLException {
    

	String sql = "DELETE  FROM activiy WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, activityID);
	prep.executeUpdate();
	System.out.println("Deletion finished");
		
}
	
	
	
}
