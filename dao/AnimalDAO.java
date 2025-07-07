package com.mvc.dao;

import com.mvc.util.DBConnection;
import com.mvc.bean.Animal;
import java.sql.*;


public class AnimalDAO {
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    private int animalID = 0;
    private String sciName;
    private String animalName;
    private String nickname;
    private String category;
    private String type;
    private String animalDetails;
    //To register animal information
    public void registerAnimal(Animal animal) {
		
	sciName = animal.getSciName();
	animalName = animal.getAnimalName();
	nickname = animal.getNickname();
	category = animal.getCategory();
        type = animal.getType();
        animalDetails = animal.getAnimalDetails();
		
	try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM ANIMAL");
                        
            while(rs.next()){
                animalID = rs.getInt("ANIMALID");
            }
            animalID++;
                        
            String sql = "INSERT INTO ANIMAL(ANIMALID,SCINAME,ANIMALNAME,NICKNAME,CATEGORY,TYPE,ANIMALDETAILS)VALUES(?,?,?,?,?,?,?)";
			
            ps = conn.prepareStatement(sql);
            ps.setInt(1, animalID);
            ps.setString(2, sciName);
            ps.setString(3, animalName);
            ps.setString(4, nickname);
            ps.setString(5, category);
            ps.setString(6, type);
            ps.setString(7, animalDetails);
            ps.executeUpdate();
			
            closeResources();
	}catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    //To update Animal
    public void updateAnimal(Animal animal) {
		
	animalID = animal.getAnimalID();
	sciName = animal.getSciName();
	animalName = animal.getAnimalName();
	nickname = animal.getNickname();
	category = animal.getCategory();
        type = animal.getType();
        animalDetails = animal.getAnimalDetails();
		
        try {
            conn = DBConnection.getConnection();
			
            String sql = "UPDATE ANIMAL SET SCINAME=?, ANIMALNAME=?, NICKNAME=?, CATEGORY=?, TYPE=?, ANIMALDETAILS=? WHERE ANIMALID=?";
			
            ps = conn.prepareStatement(sql);
            ps.setString(1, sciName);
            ps.setString(2, animalName);
            ps.setString(3, nickname);
            ps.setString(4, category);
            ps.setString(5, type);
            ps.setString(6, animalDetails);
            ps.setInt(7, animalID);
            ps.executeUpdate();
			
            closeResources();
	}catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    // To delete animal
    public void deleteAnimal(Animal animal) {
        
        animalID = animal.getAnimalID();
                
	try {
            conn = DBConnection.getConnection();

            String sql = "DELETE FROM ANIMAL WHERE ANIMALID=?";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1,  animalID);
            ps.executeUpdate();
			
            closeResources();
			
	} catch(Exception e) {
            e.printStackTrace();
	}	
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
