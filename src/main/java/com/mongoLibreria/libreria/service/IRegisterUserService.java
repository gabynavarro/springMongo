package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.reponse.UserRegisterRequest;
import com.mongoLibreria.libreria.model.reponse.UserRegisterResponse;

public interface IRegisterUserService {

    UserRegisterResponse register(UserRegisterRequest request);
}
