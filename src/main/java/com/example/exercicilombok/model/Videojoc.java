package com.example.exercicilombok.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Videojoc {
    @Id
    private int idVideojoc;
    private String titol;
    private String genere;
    private boolean multijugador;
}
