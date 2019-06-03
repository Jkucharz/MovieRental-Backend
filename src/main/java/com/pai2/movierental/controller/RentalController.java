package com.pai2.movierental.controller;

import com.pai2.movierental.exception.NotFoundException;
import com.pai2.movierental.model.RentalAddDTO;
import com.pai2.movierental.persistence.model.Movie;
import com.pai2.movierental.persistence.model.Rental;
import com.pai2.movierental.service.MovieService;
import com.pai2.movierental.service.RentalService;
import com.pai2.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalController {
    @Autowired
    RentalService rentalService;

    @Autowired
    MovieService movieService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/admin/rental")
    public ResponseEntity<List> getAdminRental() {
        return new ResponseEntity<>(rentalService.getRentals(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/rental")
    public ResponseEntity<List> getRental() {

        List<Rental> rentals = new ArrayList<>();

        for (Rental rental : rentalService.getRentals()) {
            if (rental.getUser().getUserName().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
                rentals.add(rental);
            }
        }
        if(rentals.size()==0){
            throw new NotFoundException("Brak wypożyczeń");
        }
        return new ResponseEntity<>(rentals, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/rental/add")
    public ResponseEntity<Rental> addRental(@RequestBody RentalAddDTO rentalAddDTO) {
        for (Movie movie : rentalAddDTO.getMovies()) {
            if (movieService.getMovie(movie.getTitle()) == null)
                throw new NotFoundException("Nie istnieje film o nazwie: " + movie.getTitle());

        }

        List<Movie> newMovie = new ArrayList<>();

        for (Movie movie : rentalAddDTO.getMovies()) {
            newMovie.add(movieService.getMovie(movie.getTitle()));
        }

        Rental rental = new Rental(userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()), newMovie, LocalDate.now());
        rentalService.save(rental);
        return new ResponseEntity<>(rental, HttpStatus.ACCEPTED);
    }
}
