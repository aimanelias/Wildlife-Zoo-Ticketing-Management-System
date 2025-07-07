package com.mvc.bean;

public class AuthorizeCust {
    private String status;
    private String custName;

    public AuthorizeCust(String status, String custName) {
        this.status = status;
        this.custName = custName;
    }

    public String getStatus() {
        return status;
    }

    public String getCustName() {
        return custName;
    }
}
