package com.pai2.movierental.controller;

import com.pai2.movierental.exception.BadRequestException;
import com.pai2.movierental.exception.DuplicateException;
import com.pai2.movierental.exception.NotFoundException;
import com.pai2.movierental.model.MovieAddDTO;
import com.pai2.movierental.model.MovieEditDTO;
import com.pai2.movierental.model.MovieRateDTO;
import com.pai2.movierental.persistence.model.Movie;
import com.pai2.movierental.service.MovieService;
import com.pai2.movierental.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    TypeService typeService;

    @GetMapping(value = "/getAllMovies")
    public List getAllMovies() {
        return movieService.getMovies("all");
    }

    @PostMapping(value = "/movie/rate")
    public ResponseEntity<Movie> rateMovie(@RequestBody MovieRateDTO movieRateDTO) {

        if(movieRateDTO.getRate()<1 || movieRateDTO.getRate()>5)
            throw new BadRequestException("Film można ocenić od 0 do 5");

        movieService.rateMovie(movieRateDTO.getTitle(), movieRateDTO.getRate());

        return new ResponseEntity<>(movieService.getMovie(movieRateDTO.getTitle()), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/admin/movie/add")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieAddDTO movieAddDTO) {
        if (movieService.getMovie(movieAddDTO.getTitle()) != null) {
            throw new DuplicateException("Istnieje już taki film");
        }
        if (!typeService.checkTypes(movieAddDTO.getTypes())) {
            throw new NotFoundException("Taki gatunek filmu nie istnieje. Dodaj go przed przypisaniem");
        }

        movieService.save(new Movie(movieAddDTO.getTitle(), movieAddDTO.getTypes(), movieAddDTO.getDirector(), movieAddDTO.getProductionYear(), movieAddDTO.getDescription(), 0));

        return new ResponseEntity<>(movieService.getMovie(movieAddDTO.getTitle()), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/admin/movie/edit")
    public ResponseEntity<Movie> editMovie(@RequestBody MovieEditDTO movieEditDTO) {
        if (!movieService.existMovie(movieEditDTO.getTitle())) {
            throw new NotFoundException("Nie można edytować - taki film nie istnieje");
        }

        if (movieEditDTO.getTitle().equals(movieEditDTO.getNewTitle())) {
            throw new DuplicateException("Nowy tytuł filmu jest taki sam, jak obecny tytuł");
        }

        if (movieService.getMovie(movieEditDTO.getNewTitle()) != null) {
            throw new DuplicateException("Istnieje już taki film");
        }

        if (!typeService.checkTypes(movieEditDTO.getTypes())) {
            throw new NotFoundException("Taki gatunek filmu nie istnieje. Dodaj go przed przypisaniem");
        }

        movieService.editMovie(movieEditDTO.getTitle(), new Movie(movieEditDTO.getNewTitle(), movieEditDTO.getTypes(), movieEditDTO.getDirector(), movieEditDTO.getProductionYear(), movieEditDTO.getDescription(), 0));

        if (movieEditDTO.getNewTitle() == null) {
            movieEditDTO.setNewTitle(movieEditDTO.getTitle());
        }

        return new ResponseEntity<>(movieService.getMovie(movieEditDTO.getNewTitle()), HttpStatus.ACCEPTED);
    }
}
