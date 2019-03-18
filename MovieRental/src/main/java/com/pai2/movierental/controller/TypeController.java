package com.pai2.movierental.controller;

import com.pai2.movierental.persistence.model.Type;
import com.pai2.movierental.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping(value = "/admin/movie/type")
    public ResponseEntity<List> getRole(){
        System.out.println(typeService.getTypes());
        return new ResponseEntity<>(typeService.getTypes(), HttpStatus.ACCEPTED);
    }
}
