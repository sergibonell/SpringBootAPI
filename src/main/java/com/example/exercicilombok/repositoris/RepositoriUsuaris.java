package com.example.exercicilombok.repositoris;

import com.example.exercicilombok.model.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoriUsuaris extends JpaRepository<Usuari, Long> {
    Optional<Usuari> findByUsername(String username);
}
