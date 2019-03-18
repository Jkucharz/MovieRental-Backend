package com.pai2.movierental.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "MOVIE")
@NoArgsConstructor
@Getter
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name = "Title")
    private String title;
    @ManyToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Type> types;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "PRODUCTION_YEAR")
    private Date productionYear;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "RATE")
    private int rate;

    public Movie(String title, List<Type> types, String director, Date productionYear, String description, int rate) {
        this.title = title;
        this.types = types;
        this.director = director;
        productionYear.setMonth(productionYear.getMonth()-1);
        this.productionYear = productionYear;
        this.description = description;
        this.rate = rate;
    }
}
