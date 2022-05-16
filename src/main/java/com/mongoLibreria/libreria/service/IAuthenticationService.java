package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.reponse.JwtResponse;
import com.mongoLibreria.libreria.model.request.LoginRequest;


public interface IAuthenticationService {
    JwtResponse authentication(LoginRequest request);
    
}
