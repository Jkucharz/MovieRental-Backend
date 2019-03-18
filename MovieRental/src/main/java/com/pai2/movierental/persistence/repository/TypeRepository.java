package com.pai2.movierental.persistence.repository;

import com.pai2.movierental.persistence.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String type);
}
