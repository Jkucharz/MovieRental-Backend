package com.pai2.movierental.service;

import com.pai2.movierental.model.Role;
import com.pai2.movierental.model.User;
import com.pai2.movierental.repository.RoleRepository;
import com.pai2.movierental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void addNewRole(Role role){
        roleRepository.save(role);
    }

    public Role getRole(String roleName){
        return roleRepository.findByName(roleName);
    }
}
