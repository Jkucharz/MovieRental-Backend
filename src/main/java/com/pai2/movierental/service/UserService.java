package com.pai2.movierental.service;

import com.pai2.movierental.persistence.model.Role;
import com.pai2.movierental.persistence.model.User;
import com.pai2.movierental.persistence.repository.RoleRepository;
import com.pai2.movierental.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void addNewRole(Role role) {
        roleRepository.save(role);
    }

    public Role getRole(String roleName) {
        return roleRepository.findByName(roleName);
    }

    public boolean userExist(String name) {
        boolean value = false;
        if (userRepository.findByUserName(name) != null)
            value = true;
        return value;
    }

    public User getUser(String name) {
        return userRepository.findByUserName(name);
    }

    public List<Role> getUserRoles(String userName) {
        return userRepository.findByUserName(userName).getRoles();
    }

    public void setUserRoles(String userName, List<Role> roles) {
        List<Role> newUserRoles =  userRepository.findByUserName(userName).getRoles();
        newUserRoles.clear();
        for (Role r : roles) {
            newUserRoles.add(roleRepository.findByName(r.getName()));
        }
        userRepository.findByUserName(userName).setRoles(newUserRoles);
        save(userRepository.findByUserName(userName));
    }

    public boolean checkUserAdmin(String userName) {
        boolean value = false;
        if(userRepository.findByUserName(userName)==null){
            return false;
        }
        List<Role> roles = userRepository.findByUserName(userName).getRoles();

        for(Role role: roles){
            if(role.getName().equals("admin")){
                value = true;
            }
        }
        return  value;
    }
}
