package com.pai2.movierental.service;

import com.pai2.movierental.persistence.model.Movie;
import com.pai2.movierental.persistence.model.Type;
import com.pai2.movierental.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovie(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> getMovies(String whatMovies) {
        List<Movie> list = movieRepository.findAll();
        switch (whatMovies) {
            case "all": {
                list = movieRepository.findAll();
                break;
            }
        }
        return list;
    }

    public void removeTypeForAllMovies(String typeName) {
        for(Movie movie: movieRepository.findAll()){
           movie.removeType(typeName);
        }
    }
}
