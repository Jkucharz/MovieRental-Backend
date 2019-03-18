package com.pai2.movierental.service;

import com.pai2.movierental.persistence.model.Type;
import com.pai2.movierental.persistence.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    TypeRepository typeRepository;

    public List<Type> getTypes(){
        return typeRepository.findAll();
    }

    public Type getType(String type){
        return typeRepository.findByName(type);
    }

    public void save(Type type){
        typeRepository.save(type);
    }
}