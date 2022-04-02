package com.example.exercicilombok.repositoris;

import com.example.exercicilombok.model.Videojoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriVideojocs extends JpaRepository<Videojoc, Integer> {
    List<Videojoc> findByGenere(String g);
    long countByGenere(String g);
    List<Videojoc> findByMultijugador(boolean multi);
}
