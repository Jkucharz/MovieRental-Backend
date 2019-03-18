package com.pai2.movierental.persistence.repository;

import com.pai2.movierental.persistence.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
