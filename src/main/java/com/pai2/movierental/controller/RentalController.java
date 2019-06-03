package com.pai2.movierental.controller;

import com.pai2.movierental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentalController {
    @Autowired
    RentalService rentalService;

    @GetMapping(value = "/admin/rental")
    public ResponseEntity<List> getRole() {
        return new ResponseEntity<>(rentalService.getRentals(), HttpStatus.ACCEPTED);
    }
}
