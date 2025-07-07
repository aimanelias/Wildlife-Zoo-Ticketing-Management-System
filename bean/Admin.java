package com.mvc.bean;

public class Admin implements java.io.Serializable{
    private int adminID;
    private String adminPass;
    private String adminName;
    
    public Admin() {
    }

    public Admin(int adminID, String adminPass, String adminName) {
        this.adminID = adminID;
        this.adminPass = adminPass;
        this.adminName = adminName;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
}