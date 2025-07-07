package com.mvc.bean;

public class Ticket implements java.io.Serializable{
   private int ticketID;
   private String custID;
   private String visitDate;
   private int adult;
   private int children;
   private double totalPrice;
   private String status;

    public Ticket() {
    }

    public Ticket(int ticketID, String custID, String visitDate, int adult, int children, double totalPrice, String status) {
        this.ticketID = ticketID;
        this.custID = custID;
        this.visitDate = visitDate;
        this.adult = adult;
        this.children = children;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getCustID() {
        return custID;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public int getAdult() {
        return adult;
    }

    public int getChildren() {
        return children;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
