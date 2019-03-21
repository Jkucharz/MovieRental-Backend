package com.pai2.movierental;

import com.pai2.movierental.configuration.CustomUserDetails;
import com.pai2.movierental.persistence.model.Role;
import com.pai2.movierental.persistence.model.User;
import com.pai2.movierental.persistence.repository.UserRepository;
import com.pai2.movierental.service.MovieService;
import com.pai2.movierental.service.RentalService;
import com.pai2.movierental.service.TypeService;
import com.pai2.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class MovieRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalApplication.class, args);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService userService, MovieService movieService, TypeService typeService, RentalService rentalService) throws Exception {
        if (repository.count() == 0) {
            userService.addNewRole(new Role((long) 1, "admin"));

            userService.save(new User("admin", "admin", "admin@gmail.com", Arrays.asList(userService.getRole("admin"))));
        }
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return userName -> new CustomUserDetails(repository.findByUserName(userName));
    }
}
