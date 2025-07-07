package com.mvc.bean;

public class Customer implements java.io.Serializable{
   private String custID;
   private String custName;
   private String nationality;
   private String phoneNum;
   private String custEmail;
   private String custPass;

    public Customer() {
    }

    public Customer(String custID, String custName, String nationality, String phoneNum, String custEmail, String custPass) {
        this.custID = custID;
        this.custName = custName;
        this.nationality = nationality;
        this.phoneNum = phoneNum;
        this.custEmail = custEmail;
        this.custPass = custPass;
    }

    public String getCustID() {
        return custID;
    }

    public String getCustName() {
        return custName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public String getCustPass() {
        return custPass;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public void setCustPass(String custPass) {
        this.custPass = custPass;
    }
   
}
