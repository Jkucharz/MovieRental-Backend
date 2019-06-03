package com.pai2.movierental.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "RENTAL")
@NoArgsConstructor
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToMany()
    private List<Movie> movies;
    @Column(name = "RENTAL_TIME")
    private LocalDate rentalTime;

    public Rental(User user, List<Movie> movies, LocalDate rentalTime) {
        this.user = user;
        this.movies = movies;
        this.rentalTime = rentalTime;
    }

}
