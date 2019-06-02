package com.pai2.movierental.model;

import com.pai2.movierental.persistence.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieAddDTO {
    private String title;
    private List<Type> types;
    private String director;
    private LocalDate productionYear;
    private String description;
}
