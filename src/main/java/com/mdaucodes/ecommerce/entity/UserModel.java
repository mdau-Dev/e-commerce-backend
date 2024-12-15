package com.mdaucodes.ecommerce.entity;

public class UserModel {

    private String firstName;
    private String lastNAme;
    private String email;
    private String password;
    private String tellNo;

    public UserModel(String firstName, String lastNAme, String email, String password, String tellNo) {
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.email = email;
        this.password = password;
        this.tellNo = tellNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTellNo() {
        return tellNo;
    }

    public void setTellNo(String tellNo) {
        this.tellNo = tellNo;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastNAme='" + lastNAme + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tellNo='" + tellNo + '\'' +
                '}';
    }
}
