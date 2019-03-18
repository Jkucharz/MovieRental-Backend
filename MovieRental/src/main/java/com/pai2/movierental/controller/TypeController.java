package com.pai2.movierental.controller;

import com.pai2.movierental.exception.DuplicateException;
import com.pai2.movierental.exception.NotFoundException;
import com.pai2.movierental.model.TypeDTO;
import com.pai2.movierental.persistence.model.Type;
import com.pai2.movierental.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping(value = "/admin/movie/type")
    public ResponseEntity<List> getRole() {
        return new ResponseEntity<>(typeService.getTypes(), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/admin/movie/type/add")
    public ResponseEntity<Type> addType(@RequestBody TypeDTO typeDTO) {
        if(!typeService.addType(typeDTO.getName())){
            throw new DuplicateException("Istnieje już taki gatunek filmu");
        }
        return new ResponseEntity<>(typeService.getType(typeDTO.getName()), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/admin/movie/type/delete")
    public ResponseEntity<Type> deleteType(@RequestBody TypeDTO typeDTO) {
        Type tmp = typeService.getType(typeDTO.getName());
        if(!typeService.deleteType(typeDTO.getName())){
            throw new NotFoundException("Nie istnieje taki gatunek filmu");
        }
        return new ResponseEntity<>(tmp, HttpStatus.ACCEPTED);
    }
}
