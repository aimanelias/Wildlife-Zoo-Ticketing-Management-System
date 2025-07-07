package com.mvc.dao;

import com.mvc.util.DBConnection;
import com.mvc.bean.Ticket;
import java.sql.*;


public class TicketDAO {
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    private int ticketID;
    private String custID;
    private String visitDate;
    private int adult;
    private int children;
    private double totalPrice;
    
    //To add ticket information
    public void addTicket(Ticket ticket) {
		
	ticketID = ticket.getTicketID();
	custID = ticket.getCustID();
	visitDate = ticket.getVisitDate();
        adult = ticket.getAdult();
        children = ticket.getChildren();
        totalPrice = ticket.getTotalPrice();
		
	try {

            conn = DBConnection.getConnection();
			
            String sql = "INSERT INTO TICKET (CUSTID, VISITDATE, ADULT, CHILDREN, TOTALPRICE) VALUES (?,?,?,?,?)";
			
            ps = conn.prepareStatement(sql);
            ps.setString(1, custID);
            ps.setString(2, visitDate);
            ps.setInt(3, adult);
            ps.setInt(4, children);
            ps.setDouble(5, totalPrice);
            ps.executeUpdate();
			
            conn.close();
	}catch(Exception e) {
            e.printStackTrace();
	}
    }
     //To update ticket status to cancelled
    public void cancelTicket(Ticket ticket) {
	ticketID = ticket.getTicketID();
		
	try {
            conn = DBConnection.getConnection();

            String sql = "UPDATE TICKET SET STATUS='CANCELLED' WHERE TICKETID=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, ticketID);
            ps.executeUpdate();
		    
            conn.close();
	}catch(Exception e) {
            e.printStackTrace();
	}		
    }
     
    public void visitedTicket(Ticket ticket) {
        ticketID = ticket.getTicketID();
		
	try {
            conn = DBConnection.getConnection();

            String sql = "UPDATE TICKET SET STATUS='VISITED' WHERE TICKETID=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, ticketID);
            ps.executeUpdate();
		    
            conn.close();
	}catch(Exception e) {
            e.printStackTrace();
	}		
    }
     
    public void visitedTicketStaff(Ticket ticket) {
        ticketID = ticket.getTicketID();
		
        try {
            conn = DBConnection.getConnection();

            String sql = "UPDATE TICKET SET STATUS='VISITED' WHERE TICKETID=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, ticketID);
            ps.executeUpdate();
		    
            conn.close();
	}catch(Exception e) {
            e.printStackTrace();
	}		
    } 
}
