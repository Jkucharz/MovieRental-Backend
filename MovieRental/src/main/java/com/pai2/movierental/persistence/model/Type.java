package com.pai2.movierental.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Type {
    @Id
    @Column(name = "NAME", nullable = false)
    private String name;

}
