package com.pai2.movierental.persistence.repository;

import com.pai2.movierental.persistence.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findByTitle(String title);
}
