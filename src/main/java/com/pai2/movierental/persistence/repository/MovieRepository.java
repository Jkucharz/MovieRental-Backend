package com.pai2.movierental.persistence.repository;

import com.pai2.movierental.persistence.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findByTitle(String title);
    List<Movie> findAllByOrderByTitleDesc();
    List<Movie> findAllByOrderByTitleAsc();
    List<Movie> findAllByOrderByRateDesc();
    List<Movie> findAllByOrderByRateAsc();
}
