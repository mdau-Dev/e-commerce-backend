package com.mdaucodes.ecommerce.entity;


import com.mdaucodes.ecommerce.rolesPermissions.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class GeneralUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastNAme;
    private String email;
    private String password;
    private String tellNo;
    private Role role;

    public GeneralUser(String firstName, String lastNAme,
                       String email, String password, String tellNo, Role role) {
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.email = email;
        this.password = password;
        this.tellNo = tellNo;
        this.role = role;
    }

    public GeneralUser(String firstName, String lastNAme, String email, String password, String tellNo) {
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.email = email;
        this.password = password;
        this.tellNo = tellNo;
    }

    public GeneralUser() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "GeneralUser{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastNAme='" + lastNAme + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tellNo='" + tellNo + '\'' +
                ", role=" + role +
                '}';
    }
}
