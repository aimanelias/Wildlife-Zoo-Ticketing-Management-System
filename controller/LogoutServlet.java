package com.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Logout Function
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
       
       if(session!=null){
           session.invalidate();
           request.setAttribute("errMessage", "You have logged out successfully");
           RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
           rd.forward(request,response);
           System.out.println("Logged out");
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
