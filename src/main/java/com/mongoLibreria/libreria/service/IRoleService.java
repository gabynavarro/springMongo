package com.mongoLibreria.libreria.service;

import com.mongoLibreria.libreria.model.Entity.Role;
import java.util.List;

public interface IRoleService {
    Role findBy(String name);
    Role findById(Long id);
    List<Role> findAll();
}
