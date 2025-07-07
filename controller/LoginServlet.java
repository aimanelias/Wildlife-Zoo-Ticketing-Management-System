package com.mvc.controller;

import com.mvc.bean.Admin;
import com.mvc.bean.AuthorizeCust;
import com.mvc.bean.Customer;
import com.mvc.bean.Staff;
import com.mvc.dao.AdminDAO;
import com.mvc.dao.CustDAO;
import com.mvc.dao.StaffDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userType = request.getParameter("userType");
        //To retrieve userType parameter to decide the method that will be used
        if (userType.equals("admin")) {
            handleAdminLogin(request, response);
        } else if (userType.equals("staff")) {
            handleStaffLogin(request, response);
        } else if (userType.equals("customer")) {
            handleCustomerLogin(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
    //To handle Admin Login
    private void handleAdminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminID = request.getParameter("adminID");
        String adminPass = request.getParameter("adminPass");

        Admin login = new Admin();
        login.setAdminID(Integer.parseInt(adminID));
        login.setAdminPass(adminPass);

        AdminDAO loginDAO = new AdminDAO();

        String auth = loginDAO.authorizeLogin(login);

        if (auth.equals("Authorized")) {
            HttpSession session = request.getSession();
            session.setAttribute("adminID", adminID);
            response.sendRedirect("indexAdmin.jsp");
        } else {
            request.setAttribute("WrongLoginMsg", auth);
            request.getRequestDispatcher("loginAdmin.jsp").forward(request, response);
        }
    }
    
    //To handle Staff Login
    private void handleStaffLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String staffID = request.getParameter("staffID");
        String staffPass = request.getParameter("staffPass");

        Staff login = new Staff();
        login.setStaffID(Integer.parseInt(staffID));
        login.setStaffPass(staffPass);

        StaffDAO loginDAO = new StaffDAO();

        String auth = loginDAO.authorizeLogin(login);

        if (auth.equals("Authorized")) {
            HttpSession session = request.getSession();
            session.setAttribute("staffID", staffID);
            response.sendRedirect("indexStaff.jsp");
        } else {
            request.setAttribute("WrongLoginMsg", auth);
            request.getRequestDispatcher("loginStaff.jsp").forward(request, response);
        }
    }
    //To handle Customer Login
    private void handleCustomerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String custID = request.getParameter("custID");
        String custPass = request.getParameter("custPass");

        Customer login = new Customer();
        login.setCustID(custID);
        login.setCustPass(custPass);

        CustDAO loginDAO = new CustDAO();

        AuthorizeCust auth = loginDAO.authorizeLogin(login);

        if (auth.getStatus().equals("Authorized")) {
            HttpSession session = request.getSession();
            session.setAttribute("custID", custID);
            session.setAttribute("custName", auth.getCustName());
            response.sendRedirect("indexCust.jsp");
        } else {
            request.setAttribute("WrongLoginMsg", auth);
            request.getRequestDispatcher("loginCust.jsp").forward(request, response);
        }
    }
}
