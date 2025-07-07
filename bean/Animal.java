package com.mvc.bean;

public class Animal implements java.io.Serializable{
    private int animalID;
    private String sciName;
    private String animalName;
    private String nickname;
    private String category;
    private String type;
    private String animalDetails;

    public Animal() {
    }

    public Animal(int animalID, String sciName, String animalName, String nickname, String category, String type, String animalDetails) {
        this.animalID = animalID;
        this.sciName = sciName;
        this.animalName = animalName;
        this.nickname = nickname;
        this.category = category;
        this.type = type;
        this.animalDetails = animalDetails;
    }

    public int getAnimalID() {
        return animalID;
    }

    public String getSciName() {
        return sciName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getAnimalDetails() {
        return animalDetails;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public void setSciName(String sciName) {
        this.sciName = sciName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAnimalDetails(String animalDetails) {
        this.animalDetails = animalDetails;
    }
    
    
}
