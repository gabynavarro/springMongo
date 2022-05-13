package com.mongoLibreria.libreria.auth.seeder;



import com.mongoLibreria.libreria.model.Entity.ListRole;
import com.mongoLibreria.libreria.model.Entity.Role;
import com.mongoLibreria.libreria.model.Entity.User;
import com.mongoLibreria.libreria.repository.IRoleRepository;
import com.mongoLibreria.libreria.repository.IUserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class DataBaseSeeders {

    private static final String PASSWORD = "12345678";
    private static final String HOST_EMAIL = "@test.com";
    private static final String firstNameUser[] = {"Gabriel", "Abel", "Tomas"};
    private static final String lastNameUser[] = {"Navarro", "Acevedo", "Padilla"};    
    @Autowired(required=true)
    private IUserRepository userRepository;
    @Autowired(required=true)
    private  IRoleRepository roleRepository;
    @Autowired(required=true)
    private  PasswordEncoder passwordEncoder;

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        if (roleRepository.findAll().isEmpty()) {
            createRoles();
        } 
        if (userRepository.findAll().isEmpty()) {
            createUsers();
        }
       
    }
   

    private void createRoles() {
        createRole("jojojo", ListRole.USER);
        createRole("plapla", ListRole.ADMIN);    
    }

  
    private void createUsers() {
        createUsers(ListRole.ADMIN);
        createUsers(ListRole.USER);        
    }

    private Integer calcAge() {
        return (int) (Math.random() * (90 - 18 + 1) + 18);
    }
  

    private void createUsers(ListRole applicationRole) {

        for (int index = 0; index < 3; index++) {
            userRepository.save(
                 User.builder()
                .firstName(firstNameUser[index])
                .lastName(lastNameUser[index])
                .email(applicationRole.getName().toLowerCase() + (index + 1) + HOST_EMAIL)
                .password(passwordEncoder.encode(PASSWORD))
                .roles(createListRole(applicationRole))
             .build());
        }
    }

    private List<Role> createListRole(ListRole applicationRole) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName(applicationRole.getFullRoleName()));
        return roles;
    }

  
       private void createRole(String id, ListRole applicationRole) {
        Role role = new Role();
        role.setId(id);
        role.setName(applicationRole.getFullRoleName());
        role.setDescription(applicationRole.getName());
        roleRepository.save(role);
    }

 
}
