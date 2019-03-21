package com.pai2.movierental.controller;

import com.pai2.movierental.exception.BadRequestException;
import com.pai2.movierental.exception.DuplicateException;
import com.pai2.movierental.exception.NotFoundException;
import com.pai2.movierental.model.UserRegistrationDTO;
import com.pai2.movierental.model.UserSetRoleDTO;
import com.pai2.movierental.persistence.model.Role;
import com.pai2.movierental.persistence.model.User;
import com.pai2.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.regex.Pattern;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @PostMapping(value = "/register")
    public UserRegistrationDTO register(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getPasswordConfirmation()))
            throw new BadRequestException("Hasła nie są takie same");

        if (userService.userExist(userRegistrationDTO.getUserName()))
            throw new DuplicateException("W bazie istnieje użytkownik o takie nazwie");

        Pattern namePattern = Pattern.compile("[^a-zA-Z0-9]");
        if (namePattern.matcher(userRegistrationDTO.getUserName()).find()) {
            throw new BadRequestException("W nazwie użytkownika są niedozwolone znaki");
        }

        Pattern emailPattern = Pattern.compile("@");
        if (!emailPattern.matcher(userRegistrationDTO.getEmail()).find())
            throw new BadRequestException("Niepoprawny adres email");

        userService.save(new User(userRegistrationDTO.getUserName(), userRegistrationDTO.getPassword(), userRegistrationDTO.getEmail(), Arrays.asList(userService.getRole("user"))));

        return userRegistrationDTO;
    }


    @GetMapping(value = "/logouts")
    public void logout(@RequestParam(value = "access_token") String accessToken) {
        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
    }

    @GetMapping(value = "/getUsername")
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PostMapping(value = "/admin/user/setRole")
    public ResponseEntity<User> setRole(@RequestBody UserSetRoleDTO userSetRoleDTO) {
        if (userService.getUser(userSetRoleDTO.getUserName()) == null)
            throw new NotFoundException("Nie istnieje taki użytkownik");
        if(userSetRoleDTO.getUserName()==null || getUsername().length()==0){
            throw new BadRequestException("Nie podano nazwy użytkownika");
        }
        if(userSetRoleDTO.getRoles()==null)
            throw new BadRequestException("Nie ustawiono tablicy z rolami");
        for (Role role : userSetRoleDTO.getRoles()) {
            if (userService.getRole(role.getName()) == null) {
                throw new NotFoundException("Nie istnieje rola " + role.getName());
            }
        }
        userService.setUserRoles(userSetRoleDTO.getUserName(),userSetRoleDTO.getRoles());
        return new ResponseEntity<>(userService.getUser(userSetRoleDTO.getUserName()), HttpStatus.ACCEPTED);
    }
}
