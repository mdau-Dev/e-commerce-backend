package com.mdaucodes.ecommerce.entity;

public class UserLoginModel {
    private String email;
    private String tellNo;
    private String password;

    public UserLoginModel() {
    }

    public UserLoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginModel(String email, String tellNo, String password) {
        this.email = email;
        this.tellNo = tellNo;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTellNo() {
        return tellNo;
    }

    public void setTellNo(String tellNo) {
        this.tellNo = tellNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginModel{" +
                "email='" + email + '\'' +
                ", tellNo='" + tellNo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
