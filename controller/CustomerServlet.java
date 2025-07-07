package com.mvc.controller;

import com.mvc.bean.Customer;
import com.mvc.dao.CustDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azri
 */
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        //To retrieve action parameter to decide the method that will be used
        String action = request.getParameter("action");

        if (action.equals("insertCust")) {
            insertCust(request, response);
        } else if (action.equals("updateCust")) {
            updateCust(request, response);
        }
         
        
        try {
            
        }catch (NumberFormatException ex) {
            out.println("Error: " + ex.getMessage());
        } finally {
            out.close();
        }
    
    }
    //To insert customer detail 
    private void insertCust(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List errorMsgs = new LinkedList();
        String custID = request.getParameter("custID");
        String custName = request.getParameter("custName");
        String nationality = request.getParameter("nationality");
        String phoneNum = request.getParameter("phoneNum");
        String custEmail = request.getParameter("custEmail");
        String custPass = request.getParameter("custPass");
        String custPassConf = request.getParameter("custPassConf");

        Customer insert = new Customer();
        insert.setCustID(custID);
        insert.setCustName(custName);
        insert.setNationality(nationality);
        insert.setPhoneNum(phoneNum);
        insert.setCustEmail(custEmail);
        insert.setCustPass(custPass);

        if((custPassConf==null) || custPassConf.length()==0){
            errorMsgs.add("Please confirm your password");
        }else if (!custPass.equals(custPassConf)) {
            errorMsgs.add("Passwords do not match");
        }
        CustDAO insertCustDAO = new CustDAO();
        if (insertCustDAO.custExist(custID)) {
        errorMsgs.add("NRIC already exists");
        }
        
        if(errorMsgs.isEmpty()){
        insertCustDAO.newCust(insert);
        response.sendRedirect("loginCust.jsp");
        }else {
        request.setAttribute("errorMsgs", errorMsgs);
        request.getRequestDispatcher("newCust.jsp").forward(request,response);
        }
    }
    //To update customer detail
    private void updateCust(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String custID = request.getParameter("custID");
        String custName = request.getParameter("custName");
        String nationality = request.getParameter("nationality");
        String phoneNum = request.getParameter("phoneNum");
        String custEmail = request.getParameter("custEmail");
        String custPass = request.getParameter("custPass");
        

        Customer update = new Customer();
        update.setCustID(custID);
        update.setCustName(custName);
        update.setNationality(nationality);
        update.setPhoneNum(phoneNum);
        update.setCustEmail(custEmail);
        update.setCustPass(custPass);

        CustDAO insertCustDAO = new CustDAO();
        insertCustDAO.updateCust(update);
        response.sendRedirect("updateCust.jsp");

    }

    

}
