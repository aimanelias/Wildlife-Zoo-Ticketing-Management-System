package com.mvc.controller;

import com.mvc.bean.Ticket;
import com.mvc.dao.TicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        //To retrieve action parameter to decide the method that will be used
        String action = request.getParameter("action");

        if (action.equals("insertTicket")) {
            insertTicket(request, response);
        }else if (action.equals("cancelTicket")) {
            cancelTicket(request, response);
        }else if (action.equals("visitedTicket")) {
            visitedTicket(request, response);
        }else if (action.equals("visitedTicketStaff")) {
            visitedTicketStaff(request, response);
        }
         
        
        try {
            
        }catch (NumberFormatException ex) {
            out.println("Error: " + ex.getMessage());
        } finally {
            out.close();
        }
    
    }
    //To insert the ticket information from the parameter
    private void insertTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String custID = request.getParameter("custID");
        String visitDate = request.getParameter("visitDate");
        String adult = request.getParameter("adult");
        String children = request.getParameter("children");
        String totalPrice = request.getParameter("totalPrice");

        Ticket insert = new Ticket();
        insert.setCustID(custID);
        insert.setVisitDate(visitDate);
        insert.setAdult(Integer.parseInt(adult));
        insert.setChildren(Integer.parseInt(children));
        insert.setTotalPrice(Double.parseDouble(totalPrice));

        TicketDAO insertCustDAO = new TicketDAO();
        insertCustDAO.addTicket(insert);
        response.sendRedirect("manageTicketCust.jsp");
    }
    
    //To update ticket status to cancelled
    private void cancelTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String ticketID = request.getParameter("ticketID");

        Ticket update = new Ticket();
        update.setTicketID(Integer.parseInt(ticketID));

        TicketDAO updateTicketDAO = new TicketDAO();
        updateTicketDAO.cancelTicket(update);
        response.sendRedirect("manageTicketCust.jsp");

    }
    //To update ticket status to visited by admin
    private void visitedTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String ticketID = request.getParameter("ticketID");

        Ticket update = new Ticket();
        update.setTicketID(Integer.parseInt(ticketID));

        TicketDAO updateTicketDAO = new TicketDAO();
        updateTicketDAO.visitedTicket(update);
        response.sendRedirect("manageTicket.jsp");

    }
    
    //To update ticket status to visited by staff
    private void visitedTicketStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String ticketID = request.getParameter("ticketID");

        Ticket update = new Ticket();
        update.setTicketID(Integer.parseInt(ticketID));

        TicketDAO updateTicketDAO = new TicketDAO();
        updateTicketDAO.visitedTicketStaff(update);
        response.sendRedirect("manageTicketStaff.jsp");

    }

}


