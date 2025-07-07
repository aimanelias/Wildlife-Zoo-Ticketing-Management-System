package com.mvc.controller;

import com.mvc.bean.Animal;
import com.mvc.bean.Staff;
import com.mvc.dao.AnimalDAO;
import com.mvc.dao.StaffDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type"); //To retrieve type parameter to decide the function
        String idParameter = request.getParameter("id"); //To retrieve id parameter for every type

        if (type != null && idParameter != null) {
            int objectId = Integer.parseInt(idParameter);

            if (type.equals("staff")) {
                // Deleting Staff
                Staff staff = new Staff();
                staff.setStaffID(objectId);

                StaffDAO staffDAO = new StaffDAO();
                staffDAO.deleteUser(staff);
                response.sendRedirect("manageStaff.jsp");
                
            }else if (type.equals("animal")) {
                // Deleting Animal from admin
                Animal animal = new Animal();
                animal.setAnimalID(objectId);

                AnimalDAO animalDAO = new AnimalDAO();
                animalDAO.deleteAnimal(animal);
                response.sendRedirect("manageAnimal.jsp");
                
            }else if (type.equals("animalStaff")) {
                // Deleting Animal from staff
                Animal animal = new Animal();
                animal.setAnimalID(objectId);

                AnimalDAO animalDAO = new AnimalDAO();
                animalDAO.deleteAnimal(animal);
                response.sendRedirect("manageAnimalStaff.jsp");
                
            }
        }

        
    }
}
