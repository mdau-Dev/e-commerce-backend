package com.mdaucodes.ecommerce.service;

import com.mdaucodes.ecommerce.entity.*;
import com.mdaucodes.ecommerce.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<TokenResponse> registerNewUser(UserModel userModel) {
        if (userModel.getEmail()==null && userModel.getTellNo()==null){
            throw new IllegalArgumentException(String.format(
                    "THE USER MUST HAVE AT LEAST ENTERED THEIR TELEPHONE NUMBER OR EMAIL"
            ));
        }
        if (userModel.getEmail()!=null){
            Optional<GeneralUser> exists= userRepository.findGeneralUserByEmailIgnoreCase(
                    userModel.getEmail());
//                    .orElseThrow(() -> new IllegalArgumentException(
//                    String.format("USER OF EMAIL %s COULDN'T BE FOUND", userModel.getEmail())
//            )));
            if (exists.isPresent()){
                throw new IllegalArgumentException(
                        String.format("USER OF EMAIL %s IS ALREADY REGISTERED, please login", userModel.getEmail()));
            }
        }
        if (userModel.getTellNo()!=null){
            Optional<GeneralUser> exists=userRepository.findGeneralUserByTellNo(userModel.getTellNo());
//                    .orElseThrow(() -> new IllegalArgumentException(
//                            String.format("USER OF Tell NO: %s COULDN'T BE FOUND", userModel.getTellNo())
//                    )));
            if(exists.isPresent()){
                throw new IllegalArgumentException(String.format("USER OF Tell NO: %s IS ALREADY REGISTERED, please login",
                        userModel.getTellNo()));
            }
        }

        GeneralUser user=new GeneralUser();
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setFirstName(userModel.getFirstName());
        user.setLastNAme(userModel.getLastNAme());

        userRepository.save(user);
        return ResponseEntity.ok(new TokenResponse("To look into that token creation soon"));
    }

    public ResponseEntity<TokenResponse> loginUser(UserLoginModel loginModel) {

        if (loginModel.getEmail()==null&&loginModel.getTellNo()==null){
            throw new IllegalArgumentException(String.format(
                    "THE USER MUST HAVE AT LEAST ENTERED THEIR TELEPHONE NUMBER OR EMAIL"
            ));
        }
        if (loginModel.getTellNo()==null){
            Optional<GeneralUser> exists= Optional.of(userRepository.findGeneralUserByEmailIgnoreCase(
                    loginModel.getEmail()).orElseThrow(() -> new IllegalArgumentException(
                    String.format("USER OF EMAIL %s COULDN'T BE FOUND", loginModel.getEmail())
            )));
        }
        if (loginModel.getEmail()==null){
            Optional<GeneralUser> exists= Optional.ofNullable(userRepository.findGeneralUserByTellNo(loginModel.getTellNo())
                    .orElseThrow(() -> new IllegalArgumentException(
                            String.format("USER OF Tell NO: %s COULDN'T BE FOUND", loginModel.getTellNo())
                    )));
        }


        return ResponseEntity.ok(new TokenResponse("Login Successful"));
    }

    public List<GeneralUser> fetchAllUsers() {
        return userRepository.findAll();
    }

    public List<GeneralUser> fetchAllVendors() {
        List<GeneralUser> users=userRepository.findAll();
        for(GeneralUser user:users){
         if(!user.getRole().toString().toLowerCase().contains("vendor")){
             users.remove(user);
             return users;
         }
        }
        return users;
    }

    public List<GeneralUser> fetchAllAdmins() {
        List<GeneralUser> userList=userRepository.findAll();
        for(GeneralUser user: userList){
            if(!user.getRole().toString().toLowerCase().contains("admin")){
               userList.remove(user);
               return userList;
            }
        }
        return userList;
    }

    public List<GeneralUser> fetchUsersOnly() {

        List<GeneralUser> userList=userRepository.findAll();
        for(GeneralUser user: userList){
            if (!user.getRole().toString().toLowerCase().contains("user")){
                userList.remove(user);
                return userList;
            }
        }
        return userList;
    }
}
