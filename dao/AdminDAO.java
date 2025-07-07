package com.mvc.dao;

import com.mvc.util.DBConnection;
import com.mvc.bean.Admin;
import java.sql.*;


public class AdminDAO {
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    private int adminID;
    private String adminPass;
    
    //login authorization purpose
    public String authorizeLogin(Admin admin) {
        adminID = admin.getAdminID();
        adminPass = admin.getAdminPass();

        try {
            conn = DBConnection.getConnection();
            String query = "SELECT ADMINID, ADMINPASS FROM ADMIN WHERE ADMINID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, adminID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int adminID_DB = rs.getInt("ADMINID");
                String adminPassDB = rs.getString("ADMINPASS");

                if (adminID == adminID_DB && adminPass.equals(adminPassDB)) {
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
