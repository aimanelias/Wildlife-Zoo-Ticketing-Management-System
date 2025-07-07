package com.mvc.dao;

import com.mvc.util.DBConnection;
import com.mvc.bean.Customer;
import com.mvc.bean.AuthorizeCust;
import java.sql.*;


public class CustDAO {
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    private String custID;
    private String custName;
    private String nationality;
    private String phoneNum;
    private String custEmail;
    private String custPass;
    
    //login authorization purpose
    public AuthorizeCust authorizeLogin(Customer cust) {
        custID = cust.getCustID();
        custPass = cust.getCustPass();

        try {
            conn = DBConnection.getConnection();
            String query = "SELECT CUSTID, CUSTPASS, CUSTNAME FROM CUSTOMER WHERE CUSTID = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, custID);
            rs = ps.executeQuery();

            while (rs.next()) {
                String custID_DB = rs.getString("CUSTID");
                String custPassDB = rs.getString("CUSTPASS");
                String custNameDB = rs.getString("CUSTNAME");
                
                if (custID.equals(custID_DB) && custPass.equals(custPassDB)) {
                    return new AuthorizeCust("Authorized", custNameDB);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResources();
        }

        return new AuthorizeCust("Invalid ID or Password", null);
        
    }
    //To add new customer information
    public void newCust(Customer cust) {
		
	custID = cust.getCustID();
	custName = cust.getCustName();
	nationality = cust.getNationality();
	phoneNum = cust.getPhoneNum();
	custEmail = cust.getCustEmail();
        custPass = cust.getCustPass();
	
	try {	
            conn = DBConnection.getConnection();
				
            String sql = "INSERT INTO CUSTOMER(CUSTID,CUSTNAME,NATIONALITY,PHONENUM,CUSTEMAIL,CUSTPASS)VALUES(?,?,?,?,?,?)";
			
            ps = conn.prepareStatement(sql);
            ps.setString(1, custID);
            ps.setString(2, custName);
            ps.setString(3, nationality);
            ps.setString(4, phoneNum);
            ps.setString(5, custEmail);
            ps.setString(6, custPass);
            ps.executeUpdate();
	
            closeResources();
        }catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    //To update Customer information
    public void updateCust(Customer cust) {
		
	custID = cust.getCustID();
	custName = cust.getCustName();
	nationality = cust.getNationality();
	phoneNum = cust.getPhoneNum();
	custEmail = cust.getCustEmail();
        custPass = cust.getCustPass();
		
	try {
            conn = DBConnection.getConnection();
			
            String sql = "UPDATE CUSTOMER SET CUSTNAME=?,NATIONALITY=?,PHONENUM=?,CUSTEMAIL=?,CUSTPASS=? WHERE CUSTID=?";
			
            ps = conn.prepareStatement(sql);
            ps.setString(1, custName);
            ps.setString(2, nationality);
            ps.setString(3, phoneNum);
            ps.setString(4, custEmail);
            ps.setString(5, custPass);
            ps.setString(6, custID);
            ps.executeUpdate();
			
            closeResources();
	}catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    // To delete customer
    public void deleteUser(String custID) {
	try {
            conn = DBConnection.getConnection();
			
            String sql = "DELETE FROM CUSTOMER WHERE CUSTID=?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1,  custID);
            ps.executeUpdate();
			
            closeResources();
			
	}catch(Exception e) {
            e.printStackTrace();
        }	
    }
    // To chech if the customer nric already exist
    public boolean custExist(String custID) {
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement("SELECT COUNT(*) FROM CUSTOMER WHERE CUSTID = ?"); 

            ps.setString(1, custID);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            int count = rs.getInt(1);

            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
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

