package com.pai2.movierental.model;

import com.pai2.movierental.persistence.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieEditDTO {
    private String title;
    private String newTitle;
    private List<Type> types;
    private String director;
    private Date productionYear;
    private String description;
}
