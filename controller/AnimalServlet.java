package com.mvc.controller;

import com.mvc.bean.Animal;
import com.mvc.dao.AnimalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnimalServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        //To retrieve action parameter to decide the method that will be used
        String action = request.getParameter("action");

        if (action.equals("registerAnimal")) {
            registerAnimal(request, response);
        } else if (action.equals("updateAnimal")) {
            updateAnimal(request, response);
        }if (action.equals("registerAnimalStaff")) {
            registerAnimalStaff(request, response);
        } else if (action.equals("updateAnimalStaff")) {
            updateAnimalStaff(request, response);
        }
         
        
        try {
            
        }catch (NumberFormatException ex) {
            out.println("Error: " + ex.getMessage());
        } finally {
            out.close();
        }
    
    }
    //To register animal by admin
    private void registerAnimal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String sciName = request.getParameter("sciName");
        String animalName = request.getParameter("animalName");
        String nickname = request.getParameter("nickname");
        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String animalDetails = request.getParameter("animalDetails");

        Animal insert = new Animal();
        insert.setSciName(sciName);
        insert.setAnimalName(animalName);
        insert.setNickname(nickname);
        insert.setCategory(category);
        insert.setType(type);
        insert.setAnimalDetails(animalDetails);

        AnimalDAO insertAnimalDAO = new AnimalDAO();
        insertAnimalDAO.registerAnimal(insert);
        response.sendRedirect("manageAnimal.jsp");
    }
    
    //To update animal information by admin
    private void updateAnimal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String animalID = request.getParameter("animalID");
        String sciName = request.getParameter("sciName");
        String animalName = request.getParameter("animalName");
        String nickname = request.getParameter("nickname");
        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String animalDetails = request.getParameter("animalDetails");
        

        Animal update = new Animal();
        update.setAnimalID(Integer.parseInt(animalID));
        update.setSciName(sciName);
        update.setAnimalName(animalName);
        update.setNickname(nickname);
        update.setCategory(category);
        update.setType(type);
        update.setAnimalDetails(animalDetails);

        AnimalDAO updateAnimalDAO = new AnimalDAO();
        updateAnimalDAO.updateAnimal(update);
        response.sendRedirect("manageAnimal.jsp");

    }
    
    //To register animal by staff
    private void registerAnimalStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String sciName = request.getParameter("sciName");
        String animalName = request.getParameter("animalName");
        String nickname = request.getParameter("nickname");
        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String animalDetails = request.getParameter("animalDetails");

        Animal insert = new Animal();
        insert.setSciName(sciName);
        insert.setAnimalName(animalName);
        insert.setNickname(nickname);
        insert.setCategory(category);
        insert.setType(type);
        insert.setAnimalDetails(animalDetails);

        AnimalDAO insertAnimalDAO = new AnimalDAO();
        insertAnimalDAO.registerAnimal(insert);
        response.sendRedirect("manageAnimalStaff.jsp");
    }
    
    //To update animal information by staff
    private void updateAnimalStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String animalID = request.getParameter("animalID");
        String sciName = request.getParameter("sciName");
        String animalName = request.getParameter("animalName");
        String nickname = request.getParameter("nickname");
        String category = request.getParameter("category");
        String type = request.getParameter("type");
        String animalDetails = request.getParameter("animalDetails");
        

        Animal update = new Animal();
        update.setAnimalID(Integer.parseInt(animalID));
        update.setSciName(sciName);
        update.setAnimalName(animalName);
        update.setNickname(nickname);
        update.setCategory(category);
        update.setType(type);
        update.setAnimalDetails(animalDetails);

        AnimalDAO updateAnimalDAO = new AnimalDAO();
        updateAnimalDAO.updateAnimal(update);
        response.sendRedirect("manageAnimalStaff.jsp");

    }


}
