package com.pai2.movierental.persistence.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Type")
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME")
    private String name;

    public Type(String name) {
        this.name = name;
    }
}
