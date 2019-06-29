package com.pai2.movierental.persistence.repository;

import com.pai2.movierental.persistence.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    Rental findById (long id);
    List<Rental> findAllByOrderByRentalTimeDesc();
}
