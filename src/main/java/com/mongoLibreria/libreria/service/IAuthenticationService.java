package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.reponse.UserAuthenticatedResponse;
import com.mongoLibreria.libreria.model.request.UserAuthenticatedRequest;


public interface IAuthenticationService {
    UserAuthenticatedResponse authentication(UserAuthenticatedRequest request);
}
