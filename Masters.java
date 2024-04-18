package com.jewelrystore.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Masters {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String fio;
    private int experience;
    private String file;
    private String description;

    public Masters(String fio, int experience, String description) {
        this.fio = fio;
        this.experience = experience;
        this.description = description;
    }
}