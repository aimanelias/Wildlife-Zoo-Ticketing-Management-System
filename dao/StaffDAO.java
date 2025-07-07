package com.mvc.dao;

import com.mvc.util.DBConnection;
import com.mvc.bean.Staff;
import java.sql.*;


public class StaffDAO {
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    private int staffID = 0;
    private String staffName;
    private String staffPass;
    
    //login authorization purpose
    public String authorizeLogin(Staff staff) {
        staffID = staff.getStaffID();
        staffPass = staff.getStaffPass();
        
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            
            String query = "SELECT STAFFID, STAFFPASS FROM STAFF WHERE STAFFID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, staffID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int staffID_DB = rs.getInt("STAFFID");
                String staffPassDB = rs.getString("STAFFPASS");

                if (staffID == staffID_DB && staffPass.equals(staffPassDB)) {
                    return "Authorized";
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResources();
            }
        return "Invalid ID or Password";
    
   }
   
    //To add staff information
   public void addStaff(Staff staff) {

        staffName = staff.getStaffName();
        staffPass = staff.getStaffPass();
		
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM STAFF");
                        
            while(rs.next()){
                staffID = rs.getInt("STAFFID");
            }
            staffID++;
            
            String sql = "INSERT INTO STAFF (STAFFID, STAFFPASS, STAFFNAME) VALUES (?,?,?)";
			
            ps = conn.prepareStatement(sql);
            ps.setInt(1, staffID);
            ps.setString(2, staffPass);
            ps.setString(3, staffName);
            ps.executeUpdate();
			
            closeResources();
	}catch(Exception e) {
            e.printStackTrace();
	}
    }
   
   //To update Staff information
   public void updateStaff(Staff staff) {
	staffID =staff.getStaffID();
	staffName = staff.getStaffName();
        staffPass = staff.getStaffPass();
		
	try {
            conn = DBConnection.getConnection();

            String sql = "UPDATE STAFF SET STAFFNAME=?, STAFFPASS=? WHERE STAFFID=?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, staffName);
            ps.setString(2, staffPass);
            ps.setInt(3, staffID);
            ps.executeUpdate();
		    
            closeResources();
	}catch(Exception e) {
            e.printStackTrace();
	}		
    }
   
   // To delete Staff
   public void deleteUser(Staff staff) {
	staffID = staff.getStaffID();
	staffName = staff.getStaffName();
        staffPass = staff.getStaffPass();
		
        try {
            conn = DBConnection.getConnection();

            String sql = "DELETE FROM STAFF WHERE STAFFID=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, staffID);
            ps.executeUpdate();
		    
            closeResources();
	}catch(Exception e) {
            e.printStackTrace();
	}		
    }
   
    // Close resources method
    private static void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
