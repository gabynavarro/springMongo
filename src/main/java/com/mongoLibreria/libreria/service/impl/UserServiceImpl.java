package com.mongoLibreria.libreria.service.impl;

import com.mongoLibreria.libreria.auth.filter.JwtUtil;
import com.mongoLibreria.libreria.auth.filter.JwtUtils;
import com.mongoLibreria.libreria.model.Entity.ERole;
import com.mongoLibreria.libreria.model.Entity.Role;
import com.mongoLibreria.libreria.model.Entity.User;
import com.mongoLibreria.libreria.model.mapper.UserMapper;
import com.mongoLibreria.libreria.model.reponse.JwtResponse;
import com.mongoLibreria.libreria.model.reponse.RegisterResponse;
import com.mongoLibreria.libreria.model.request.LoginRequest;
import com.mongoLibreria.libreria.model.request.SignupRequest;
import com.mongoLibreria.libreria.repository.RoleRepository;
import com.mongoLibreria.libreria.repository.UserRepository;
import com.mongoLibreria.libreria.service.IAuthenticationService;
import com.mongoLibreria.libreria.service.IRegisterUserService;
import com.mongoLibreria.libreria.service.IUserService;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

@Service
public class UserServiceImpl implements UserDetailsService, IRegisterUserService, IAuthenticationService, IUserService {
//   

    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";
    private static final String USER_EMAIL_ERROR = "Email address is already used.";
    private static final String USER_LIST_ERROR = "Empty user list";
    private static final String USERNAME_ERROR = "Error: Username is already taken!";
    private static final String ROLE_ERROR = "Error: Role is not found.";

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RegisterResponse register(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException(USERNAME_ERROR);
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(USER_EMAIL_ERROR);
        }
        // Create new user's account                
        User user = userMapper.userDto2Entity(request);
        Set<String> strRoles = request.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(ROLE_ERROR));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException(ROLE_ERROR));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException(ROLE_ERROR));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException(ROLE_ERROR));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        User userCreated = userRepository.save(user);
        RegisterResponse userRegister = userMapper.userEntityRes(userCreated);
        userRegister.setToken(jwtUtil.generateTokenUser(userCreated));
        return userRegister;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) getUser(email);
    }

    
    
    
    
    
    
    
    private User getUser(String id) {
        User userOptional = userRepository.findById(id).orElseThrow();
        return userOptional;
    }
//
    private User getUserLog(String user) {
         User userLog=userRepository.findByUsername(user);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }        
        return userLog;
    }

    @Override
    public JwtResponse authentication(LoginRequest request) {
            
        User user = getUserLog(request.getUsername());       
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        return userMapper.userEntity2Dto(user,jwtUtil.generateTokenUser(user));
    }

    //TODO: user me - info usuario log
    @Override
    public User getInfoUser() throws NotFoundException {
        Object userInstance = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userInstance instanceof User) {
            String username = ((User) userInstance).getUsername();//            
        } else {
            String username = userInstance.toString();
        }
//        System.out.println("EL USSS ES: "+ userInstance.toString());
        return userRepository.findByUsername(userInstance.toString());
    }

//    public List<UserResponse> listAllUser(List<User> entities) {
//        List<UserResponse> listResponse = new ArrayList<>();
//        if (entities.size() == 0) {
//            throw new EntityNotFoundException(USER_LIST_ERROR);
//        }
//        for (User entity : entities) {
//            listResponse.add(userMapper.convertTo(entity));
//        }
//        return listResponse;
//    }


}
