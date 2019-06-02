package com.pai2.movierental.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "MOVIE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private LocalDate productionYear;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "RATE")
    private int rate;


    public Movie(String title, List<Type> types, String director, LocalDate productionYear, String description, int rate) {
        this.title = title;
        this.types = types;
        this.director = director;
        this.productionYear = productionYear;
        this.description = description;
        this.rate = rate;
    }

    public void removeType(String type) {
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).getName().equals(type)) {
                types.remove(i);
            }
        }
    }
}
