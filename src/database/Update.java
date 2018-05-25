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
	Connection c;
	public Update(Connection c) {
		this.c=c;
		
	}

  public void  UpdateMaterial( Material mat) throws SQLException {
      String sql = "UPDATE material SET name=?, price = ? WHERE id=?";
      PreparedStatement prep = c.prepareStatement(sql);
      prep.setString(1, mat.getMaterial());
      prep.setInt(2, mat.getPrice());
      prep.setInt(3, mat.getId());
      prep.executeUpdate();
  }

  public void UpdateAccomodation ( Accomodation acom) throws SQLException {
      String sql = "UPDATE accomodation SET name = ?, price =?, availability=? WHERE id = ?";
      PreparedStatement prep = c.prepareStatement(sql);

      prep.setString(1, acom.getAccomodation());
      prep.setInt(2, acom.getPrice());
      prep.setInt(3, acom.getAvailability());
      prep.setInt(4, acom.getId());

      prep.executeUpdate();

  }

  public void UpdateActivity ( Activity act) throws SQLException {
      String sql = "UPDATE activity SET name = ?, price =?,  availability=? WHERE id = ?";
      PreparedStatement prep = c.prepareStatement(sql);
      prep.setString(1, act.getActivity());
      prep.setInt(2, act.getPrice());
      prep.setInt(3, act.getId());
      prep.executeUpdate();
  }

  public void UpdateTransport ( Transport trans) throws SQLException {

      String sql = "UPDATE transport SET name = ?, price =?, availability=? WHERE id = ?";

      PreparedStatement prep = c.prepareStatement(sql);
      prep.setString(1, trans.getType_transport());
      prep.setInt(2, trans.getPrice());
      prep.setInt(3, trans.getAvailable());
      prep.setInt(4, trans.getId());
      prep.executeUpdate();
  }

  public void UpdateInstructor ( Instructor ins) throws SQLException {
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

  public void UpdateCamper ( Camper cam) throws SQLException{
      String sql = "UPDATE camper SET name =?, phone_number =?, dob =?, NIF =?, email =?, payment_method =?, needtopay=? WHERE id = ?";
      PreparedStatement prep = c.prepareStatement(sql);
      prep.setString(1, cam.getName());
      prep.setInt(2, cam.getPhonenumber());
      prep.setDate(3, cam.getDateofbirth());
      prep.setString(4, cam.getNIF());
      prep.setString(5, cam.getEmail());
      prep.setString(6, cam.getPayment_method());
      prep.setInt(7, cam.getNeedtopay());
      prep.setInt(8, cam.getId());
      
      prep.executeUpdate();
  }

  public void UpdateTransportInCamper(Transport trans, Camper cam) throws SQLException {
	  
	  String sql = "UPDATE camper SET transport_id=? WHERE id=?";
	  PreparedStatement prep = c.prepareStatement(sql);
	  prep.setInt(1, trans.getId());
	  prep.setInt(2, cam.getId());
	  prep.executeUpdate();
	  
	  
	  
  }
  
public void UpdateAccomodationInCamper(Accomodation accom, Camper cam) throws SQLException {
	  
	  String sql = "UPDATE camper SET accomodation_id=? WHERE id=?";
	  PreparedStatement prep = c.prepareStatement(sql);
	  prep.setInt(1, accom.getId());
	  prep.setInt(2, cam.getId());
	  prep.executeUpdate();
	  
  }

public void updateActICamper(Activity act, Camper camp) throws SQLException{
	
	String sql = "UPDATE camper SET activity_id=? WHERE id=?";
	  PreparedStatement prep = c.prepareStatement(sql);
	  prep.setInt(1, act.getId());
	  prep.setInt(2, camp.getId());
	  prep.executeUpdate();
}

public void updateMatInCamper(Material mat, Camper camp,Material m) throws SQLException{
	
	String sql = "UPDATE camper SET material_id=? WHERE id=? material_id=?";
	  PreparedStatement prep = c.prepareStatement(sql);
	  prep.setInt(1, mat.getId());
	  prep.setInt(2, camp.getId());
	  prep.setInt(3, m.getId());
	  prep.executeUpdate();
}
public void updateNewMatInCamper(Material mat, Camper camp)throws SQLException{
	String sql = "UPDATE camper SET material_id=? WHERE id=?";
	  PreparedStatement prep = c.prepareStatement(sql);
	  prep.setInt(1, mat.getId());
	  prep.setInt(2, camp.getId());
	  prep.executeUpdate();
}

}