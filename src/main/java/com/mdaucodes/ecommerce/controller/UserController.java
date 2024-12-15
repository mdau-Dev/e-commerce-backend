package com.mdaucodes.ecommerce.controller;

import com.mdaucodes.ecommerce.entity.*;
import com.mdaucodes.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/mdaucodes/users/")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public List<GeneralUser> fetchAllUsers(){
        return userService.fetchAllUsers();
    }
    @GetMapping("/fetchUsersOnly")
    public List<GeneralUser> fetchUsersOnly(){
        return userService.fetchUsersOnly();
    }
    @GetMapping("/getAllVendors")
    public List<GeneralUser> fetchAllVendors(){
        return userService.fetchAllVendors();
    }

    @GetMapping("/getAllAdmins")
    public List<GeneralUser> fetchAllAdmins(){
        return userService.fetchAllAdmins();
    }
    @PostMapping("/register")
    public ResponseEntity<TokenResponse> registerNewUser(
            @RequestBody UserModel userModel
            ){
        return userService.registerNewUser(userModel);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> loginUser(
            @RequestBody UserLoginModel loginModel
            ){
        return userService.loginUser(loginModel);
    }

}
