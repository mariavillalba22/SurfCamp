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
		String sql = "DELETE FROM camper WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, camperID);
		prep.executeUpdate();			
	}
	
	public void deleteCamperIdfromM ( int camperID) throws SQLException {
		String sql = "DELETE FROM camper_material WHERE id_camper = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, camperID);
		prep.executeUpdate();			
	}
	public void deleteCamperIdfromA ( int camperID) throws SQLException {
		String sql = "DELETE FROM camper_activity WHERE id_camper = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, camperID);
		prep.executeUpdate();			
	}
	public void deleteActivityIdfromCA ( int activityID) throws SQLException {
		String sql = "DELETE FROM camper_activity WHERE id_activity= ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, activityID);
		prep.executeUpdate();			
	}
	
	public void deleteTransportID ( int transportID) throws SQLException {
		String sql = "DELETE  FROM transport WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, transportID);
		prep.executeUpdate();
			
	}
	
    public void deleteInstructorID ( int instructorID) throws SQLException {
		String sql = "DELETE  FROM instructor WHERE id = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, instructorID);
		prep.executeUpdate();
		
			
	}

   public void deleteMaterialID ( int materialID) throws SQLException {
	String sql = "DELETE FROM material WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, materialID);
	prep.executeUpdate();
	
		
}
 
   public void deleteMaterialIdfromCM ( int materialID) throws SQLException {
		String sql = "DELETE FROM camper_material WHERE id_material = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, materialID);
		prep.executeUpdate();			
	}
   public void deleteMaterialIdfromMA ( int materialID) throws SQLException {
		String sql = "DELETE FROM material_activity WHERE id_material = ?";
		PreparedStatement prep  = c.prepareStatement(sql);
		prep.setInt(1, materialID);
		prep.executeUpdate();			
	}

public void deleteAccomodationID ( int accomodationID) throws SQLException {
    
	String sql = "DELETE FROM accomodation WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, accomodationID);
	prep.executeUpdate();	
	
		
}

public void deleteActivityID ( int activityID) throws SQLException {
    
	String sql = "DELETE  FROM activity WHERE id = ?";
	PreparedStatement prep  = c.prepareStatement(sql);
	prep.setInt(1, activityID);
	prep.executeUpdate();
	
		
}
	
	
	
}
