package controllers;

import itmo.lab.web4.controllers.AuthController;
import itmo.lab.web4.models.User;
import itmo.lab.web4.services.AuthService;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {




    @Mock
    AuthService authService;


    @InjectMocks
    AuthController authController;


    @Test
    void testSuccessLogin(){


        User user = new User();
        user.setUsername("mama");
        user.setPassword("papa");


        Mockito.when(authService.login(Mockito.any())).thenReturn("token");


        Map<String, String> response = new HashMap<>();

        response.put("token", "token");

        Assertions.assertEquals(authController.login(user), ResponseEntity.ok(response));


    }

    @Test
    void testFailureLogin() {
        User user = new User();
        user.setUsername("mama");
        user.setPassword("papa");


        when(authService.login(any(User.class)))
                .thenThrow(new UsernameNotFoundException("User not found"));

        assertThrows(UsernameNotFoundException.class, () -> {
            authController.login(user);
        });

    }


    @Test
    void testSuccessRegistration(){

        User user = new User();
        user.setUsername("mama");
        user.setPassword("papa");


        when(authService.register(any(User.class)))
                .thenThrow(new BadCredentialsException("User already exists!!"));

        assertThrows(BadCredentialsException.class, () -> {
            authController.register(user);
        });

    }


}
