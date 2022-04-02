package com.example.exercicilombok.serveis;

import com.example.exercicilombok.model.Videojoc;
import com.example.exercicilombok.repositoris.RepositoriVideojocs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiVideojocs {
    private final RepositoriVideojocs repo;

    public List<Videojoc> llistarVideojocs(){
        return repo.findAll();
    }

    public List<Videojoc> llistarVideojocsPerGenere(String genere){
        return repo.findByGenere(genere);
    }

    public long comptarPerGenere(String genere){
        return repo.countByGenere(genere);
    }

    public List<Videojoc> findByMultijugador(boolean multi){
        return repo.findByMultijugador(multi);
    }

    public Videojoc consultarVideojoc(int id){
        return repo.findById(id).orElse(null);
    }

    public Videojoc afegirVideojoc(Videojoc it){
        return repo.save(it);
    }

    public Videojoc modificarVideojoc(Videojoc videojoc){
        Videojoc aux = null;
        if(repo.existsById(videojoc.getIdVideojoc())) aux = repo.save(videojoc);
        return aux;
    }

    public Videojoc eliminarVideojoc(int id){
        Videojoc res = repo.findById(id).orElse(null);
        if(res!=null) repo.deleteById(id);
        return res;
    }
}
