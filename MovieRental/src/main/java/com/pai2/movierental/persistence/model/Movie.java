package com.pai2.movierental.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "MOVIE")
@NoArgsConstructor
@Getter
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "PRODUCTION_YEAR")
    private Date productionYear;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column (name = "BORROWS_QUANTITY")
    private int borrowsQuantity;
    @Column (name = "RATE")
    private int rate;

    public Movie(String name, String type, String director, Date productionYear, String description, int borrowsQuantity, int rate){
        this.name = name;
        this.type = type;
        this. director = director;
        this.productionYear = productionYear;
        this.description = description;
        this.borrowsQuantity = borrowsQuantity;
        this.rate = rate;
    }
}
