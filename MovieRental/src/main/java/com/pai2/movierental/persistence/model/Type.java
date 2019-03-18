package com.pai2.movierental.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Type {
    @Id
    @Column(name = "NAME", nullable = false)
    private String name;

}
