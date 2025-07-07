package com.mvc.controller;

import com.mvc.bean.Staff;
import com.mvc.dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaffServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //To retrieve action parameter to decide the method that will be used
        String action = request.getParameter("action");

        if ("insertStaff".equals(action)) {
            insertStaff(request, response);
        } else if ("updateStaff".equals(action)) {
            updateStaff(request, response);
        }
         
        try {
            
        }catch (NumberFormatException ex) {
            out.println("Error: " + ex.getMessage());
        } finally {
            out.close();
        }
    }
    //To insert new staff by admin
    private void insertStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String staffPass = request.getParameter("staffPass");
        String staffName = request.getParameter("staffName");

        Staff insert = new Staff();
        insert.setStaffPass(staffPass);
        insert.setStaffName(staffName);

        StaffDAO insertStaffDAO = new StaffDAO();
        insertStaffDAO.addStaff(insert);
        response.sendRedirect("manageStaff.jsp");

    } 
    
    //To update staff details
    private void updateStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String staffID = request.getParameter("staffID");
        String staffPass = request.getParameter("staffPass");
        String staffName = request.getParameter("staffName");

        Staff update = new Staff();
        update.setStaffID(Integer.parseInt(staffID));
        update.setStaffPass(staffPass);
        update.setStaffName(staffName);

        StaffDAO insertStaffDAO = new StaffDAO();
        insertStaffDAO.updateStaff(update);
        response.sendRedirect("manageStaff.jsp");

    }

}
