package com.pai2.movierental.controller;

import com.pai2.movierental.exception.DuplicateException;
import com.pai2.movierental.exception.NotFoundException;
import com.pai2.movierental.model.MovieAddDTO;
import com.pai2.movierental.persistence.model.Movie;
import com.pai2.movierental.service.MovieService;
import com.pai2.movierental.service.TypeService;
import oracle.jdbc.proxy.annotation.Post;
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

    @PostMapping(value = "/admin/movie/add")
    public ResponseEntity<Movie> addType(@RequestBody MovieAddDTO movieAddDTO) {
        if(movieService.getMovie(movieAddDTO.getTitle())!=null){
            throw new DuplicateException("Istnieje już taki film");
        }
        if(!typeService.checkTypes(movieAddDTO.getTypes())){
           throw new NotFoundException("Taki gatunek filmu nie istnieje. Dodaj go przed przypisaniem");
        }

        movieService.save(new Movie(movieAddDTO.getTitle(),movieAddDTO.getTypes(),movieAddDTO.getDirector(),movieAddDTO.getProductionYear(),movieAddDTO.getDescription(),0));

        return new ResponseEntity<>(movieService.getMovie(movieAddDTO.getTitle()), HttpStatus.ACCEPTED);
    }
}
