package com.pai2.movierental.controller;

import com.pai2.movierental.exception.BadRequestException;
import com.pai2.movierental.exception.DuplicateException;
import com.pai2.movierental.model.UserRegistrationDTO;
import com.pai2.movierental.persistence.model.User;
import com.pai2.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserRegistrationDTO register(@RequestBody UserRegistrationDTO userRegistrationDTO){
        if(!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getPasswordConfirmation()))
            throw new BadRequestException("Hasła nie są takie same");

        if(userService.userExist(userRegistrationDTO.getUserName()))
            throw new DuplicateException("W bazie istnieje użytkownik o takie nazwie");

        Pattern namePattern = Pattern.compile("[^a-zA-Z0-9]");
        if(namePattern.matcher(userRegistrationDTO.getUserName()).find()) {
            throw new BadRequestException("W nazwie użytkownika są niedozwolone znaki");
        }

        Pattern emailPattern = Pattern.compile("@");
        if(!emailPattern.matcher(userRegistrationDTO.getEmail()).find())
            throw new BadRequestException("Niepoprawny adres email");

        userService.save(new User(userRegistrationDTO.getUserName(),userRegistrationDTO.getPassword(),userRegistrationDTO.getEmail(), Arrays.asList(userService.getRole("user"))));

        return userRegistrationDTO;
    }


    @GetMapping(value = "/logouts")
    public void logout(@RequestParam(value = "access_token") String accessToken){
        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
    }

    @GetMapping(value ="/getUsername")
    public String getUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
