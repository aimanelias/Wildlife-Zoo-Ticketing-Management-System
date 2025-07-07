package com.mvc.bean;

public class Staff implements java.io.Serializable{
    private int staffID;
    private String staffName;
    private String staffPass;

    public Staff() {
    }

    public Staff(int staffID, String staffName, String staffPass) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffPass = staffPass;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass;
    }
    
}
