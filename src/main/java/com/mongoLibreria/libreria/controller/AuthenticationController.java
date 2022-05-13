package com.mongoLibreria.libreria.controller;

import com.mongoLibreria.libreria.model.request.UserRegisterRequest;
import com.mongoLibreria.libreria.model.request.UserAuthenticatedRequest;
import com.mongoLibreria.libreria.service.IAuthenticationService;
import com.mongoLibreria.libreria.service.IRegisterUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthenticationController {

    
    private final IRegisterUserService registerUserService;
    private final IAuthenticationService authenticationService;    

    @PostMapping("/register")    
    public ResponseEntity<?> register(@RequestPart(value = "user", required = true) UserRegisterRequest request) {       
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUserService.register(request));
    }      
    
    @PostMapping("/login")    
    public ResponseEntity<?> login(@Valid @RequestBody UserAuthenticatedRequest request){       
        return ResponseEntity.ok(authenticationService.authentication(request));
    }

}
