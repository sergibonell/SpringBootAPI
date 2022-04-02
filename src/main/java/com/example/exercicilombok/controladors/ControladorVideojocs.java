package com.example.exercicilombok.controladors;

import com.example.exercicilombok.model.Videojoc;
import com.example.exercicilombok.serveis.ServeiVideojocs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorVideojocs {
    private final ServeiVideojocs serveiVideojocs;

    @GetMapping("/videojocs")
    public ResponseEntity<?> llistarVideojocs(@RequestParam (value="genere", required=false) String genere){
        List<Videojoc> videojocs;
        if(genere==null)
            videojocs = serveiVideojocs.llistarVideojocs();
        else
            videojocs = serveiVideojocs.llistarVideojocsPerGenere(genere);

        if(videojocs == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videojocs);
    }

    @PostMapping("/videojocs")
    public ResponseEntity<?> crearUsuari(@RequestBody Videojoc nou){
        Videojoc videojoc = serveiVideojocs.afegirVideojoc(nou);
        return new ResponseEntity<Videojoc>(videojoc, HttpStatus.CREATED);
    }

    /*
    @GetMapping("/videojocs/{id}")
    public Videojoc consultarVideojoc(@PathVariable int id)
    {
        return serveiVideojocs.consultarVideojoc(id);
    }

    @GetMapping("/videojocs/genere/{genere}")
    public List<Videojoc> llistarUsuarisPerGenere(@PathVariable String genere){
        return serveiVideojocs.llistarVideojocsPerGenere(genere);
    }

    @GetMapping("/videojocs/comptar/{genere}")
    public long comptarPerGenere(@PathVariable String genere){
        return serveiVideojocs.comptarPerGenere(genere);
    }



    @DeleteMapping("/videojocs/{id}")
    public Videojoc eliminarUsuari(@PathVariable int id){
        return serveiVideojocs.eliminarVideojoc(id);
    }

    @PutMapping("/videojocs")
    public Videojoc modificarUsuari(@RequestBody Videojoc videojoc){
        return serveiVideojocs.modificarVideojoc(videojoc);
    }
    */
}
