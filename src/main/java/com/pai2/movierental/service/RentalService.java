package com.pai2.movierental.service;

import com.pai2.movierental.persistence.model.Rental;
import com.pai2.movierental.persistence.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepository rentalRepository;

    public void save(Rental rental) {
        rentalRepository.save(rental);
    }

    public List<Rental> getRentals() {
        return rentalRepository.findAll();
    }

    public void removeRental(int id) {
        rentalRepository.delete(rentalRepository.findById(id));
    }
}
