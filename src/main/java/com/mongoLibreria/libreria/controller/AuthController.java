package com.mongoLibreria.libreria.controller;

import com.mongoLibreria.libreria.model.request.LoginRequest;
import com.mongoLibreria.libreria.model.request.SignupRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongoLibreria.libreria.service.IAuthenticationService;
import com.mongoLibreria.libreria.service.IRegisterUserService;
import org.springframework.http.HttpStatus;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

        @Autowired
        private IAuthenticationService authenticationService;
        @Autowired 
        private IRegisterUserService registerUser;
	
        @PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
            return ResponseEntity.ok(authenticationService.authentication(loginRequest));		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		return ResponseEntity.status(HttpStatus.CREATED).body(registerUser.register(signUpRequest));
	}
}
