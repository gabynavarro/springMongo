package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.reponse.RegisterResponse;
import com.mongoLibreria.libreria.model.request.SignupRequest;




public interface IRegisterUserService {

    RegisterResponse register(SignupRequest requeste);
}
