package com.pai2.movierental.controller;

import com.pai2.movierental.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping(value = "/getAllMovie")
    public List getAllMovie() {
        return movieService.getMovie("all");
    }
}
