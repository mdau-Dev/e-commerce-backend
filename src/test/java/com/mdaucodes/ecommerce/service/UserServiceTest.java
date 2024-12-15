package com.mdaucodes.ecommerce.service;

import com.mdaucodes.ecommerce.entity.GeneralUser;
import com.mdaucodes.ecommerce.entity.TokenResponse;
import com.mdaucodes.ecommerce.entity.UserLoginModel;
import com.mdaucodes.ecommerce.entity.UserModel;
import com.mdaucodes.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void registerNewUser() {
        //Given
        UserModel model=new UserModel("mdau","pius",
                "mdau@gmail.com","ppeettzz","0796814105");

        GeneralUser generalUser=new GeneralUser();
        generalUser.setPassword(model.getPassword());
        generalUser.setEmail(model.getEmail());
        generalUser.setLastNAme(model.getLastNAme());
        generalUser.setFirstName(model.getFirstName());

        GeneralUser generalUser1=new GeneralUser();

        //Mock the Calls
        when(userRepository.findGeneralUserByEmailIgnoreCase(generalUser1.getEmail()))
                .thenReturn(Optional.of(generalUser));
        when(userRepository.findGeneralUserByTellNo(generalUser1.getTellNo()))
                .thenReturn(Optional.of(generalUser));

        //when
        ResponseEntity<TokenResponse> token=userService.registerNewUser(model);

        //then
        assertEquals(model.getEmail(),generalUser.getEmail());
        assertEquals(model.getPassword(),generalUser.getPassword());
        System.out.println(token);
    }

    @Test
    void loginUser() {
        //Given
        UserLoginModel loginModel=new UserLoginModel("md@gmail.com","ppeettzz");
        GeneralUser generalUser=new GeneralUser();

        //Mock the calls
        when(userRepository.findGeneralUserByEmailIgnoreCase(loginModel.getEmail()))
                .thenReturn(Optional.of(generalUser));
        when(userRepository.findGeneralUserByTellNo(loginModel.getTellNo()))
                .thenReturn(Optional.of(generalUser));
        //when
        ResponseEntity<TokenResponse> token=userService.loginUser(loginModel);

        //then
        System.out.println(token);
    }

    @Test
    void fetchAllUsers() {
        //Given
        List<GeneralUser> generalUserList=new ArrayList<>();
        generalUserList.add(
                new GeneralUser("Pius", "mdau", "mdau@gmail.com",
                        "ppeettzz", "0796184541"));
        generalUserList.add(
                new GeneralUser("Tony", "Munene", "mnene@gmail.com",
                        "ppeettzz", "0796184541"));

        //Mock The Calls
        when(userRepository.findAll()).thenReturn(generalUserList);

        //when
        List<GeneralUser> userList=userService.fetchAllUsers();
        //then
        assertEquals(userList,generalUserList);
//        verify(userReposi,userList.size())
    }

    @Test
    void fetchAllVendors() {
    }

    @Test
    void fetchAllAdmins() {
    }

    @Test
    void fetchUsersOnly() {
    }
}