package com.pai2.movierental;

import com.pai2.movierental.configuration.CustomUserDetails;
import com.pai2.movierental.persistence.model.Movie;
import com.pai2.movierental.persistence.model.Role;
import com.pai2.movierental.persistence.model.User;
import com.pai2.movierental.persistence.repository.UserRepository;
import com.pai2.movierental.service.MovieService;
import com.pai2.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class MovieRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService userService, MovieService movieService) throws Exception {
        if (repository.count() == 0) {
            userService.addNewRole(new Role((long) 1, "admin"));
            userService.addNewRole(new Role((long) 2, "user"));

            userService.save(new User("admin", "admin", "admin@movierental.pl", Arrays.asList(userService.getRole("admin"))));
            userService.save(new User("user", "user", "user@gmail.com", Arrays.asList(userService.getRole("user"))));

            movieService.save(new Movie("Przyklad","Przyklad","Przyklad",new Date(100,01,24),"Przyklad",1,5));
            movieService.save(new Movie("Przyklad","Przyklad","Przyklad",new Date(105,11,24),"Przyklad",1,3));
            movieService.save(new Movie("Przyklad","Przyklad","Przyklad",new Date(118,10,24),"Przyklad",1,5));
        }
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return userName -> new CustomUserDetails(repository.findByUserName(userName));
    }
}

