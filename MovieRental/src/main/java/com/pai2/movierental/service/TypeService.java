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

    @Autowired
    MovieService movieService;

    public Type getType(String type) {
        return typeRepository.findByName(type);
    }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    public boolean exitType(String type){
        boolean exist = false;
        if(typeRepository.findByName(type)!=null){
            exist = true;
        }
        return exist;
    }

    public boolean checkTypes(List<Type> list) {
        boolean alright = true;
        for (Type t : list) {
            if (!exitType(t.getName())){
                alright = false;
            }
        }
        return alright;
    }

    public boolean addType(String name) {
        boolean value = false;
        if (getType(name) == null || !getType(name).getName().equals(name)) {
            typeRepository.save(new Type(name));
            value = true;
        }
        return value;
    }

    public boolean deleteType(String name) {
        boolean value = true;
        if (typeRepository.findByName(name) == null) {
            value = false;
        } else {
            movieService.removeTypeForAllMovies(name);
            typeRepository.delete(typeRepository.findByName(name));
        }

        return value;
    }

    public void save(Type type) {
        typeRepository.save(type);
    }
}
