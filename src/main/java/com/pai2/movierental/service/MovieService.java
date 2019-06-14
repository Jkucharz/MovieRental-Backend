package com.pai2.movierental.service;

import com.pai2.movierental.persistence.model.Movie;
import com.pai2.movierental.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public boolean existMovie(String title) {
        if (movieRepository.findByTitle(title) != null) {
            return true;
        } else {
            return false;
        }
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

    public void editMovie(String movieTitle, Movie newMovie) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        if (newMovie.getTitle() != null)
            movie.setTitle(newMovie.getTitle());
        if (newMovie.getTypes() != null)
            movie.setTypes(newMovie.getTypes());
        if (newMovie.getDirector() != null)
            movie.setDirector(newMovie.getDirector());
        if (newMovie.getProductionYear() != null)
            movie.setProductionYear(newMovie.getProductionYear());
        if (newMovie.getDescription() != null)
            movie.setDescription(newMovie.getDescription());

        movieRepository.save(movie);
    }

    public void removeTypeForAllMovies(String typeName) {
        for (Movie movie : movieRepository.findAll()) {
            movie.removeType(typeName);
        }
    }

    public void rateMovie(String title, int rate) {
        Movie movie = movieRepository.findByTitle(title);
        movie.setRate(movie.getRate() + "," + Integer.toString(rate));
        movieRepository.save(movie);
    }

    public int getAvarage(String title) {
        String value = movieRepository.findByTitle(title).getRate();
        List<Integer> rates = new ArrayList<>();

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != ',') {
                rates.add(Character.getNumericValue(value.charAt(i)));
            }
        }

        double sum = 0;

        for (Integer i : rates) {
            sum+=i;
        }

        return (int)Math.round(sum/rates.size());
    }
}
