package com.mdaucodes.ecommerce.entity;


import com.mdaucodes.ecommerce.rolesPermissions.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
