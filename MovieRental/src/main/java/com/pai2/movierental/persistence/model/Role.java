package com.pai2.movierental.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ROLES")
@Getter
@NoArgsConstructor
public class Role {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME")
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
