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

    @GetMapping("/videojocs/{id}")
    public ResponseEntity<?> consultarVideojoc(@PathVariable int id)
    {
        Videojoc videojoc = serveiVideojocs.consultarVideojoc(id);
        if(videojoc == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(videojoc);
    }

    @GetMapping("/videojocs/comptar/{genere}")
    public ResponseEntity<?> comptarPerGenere(@PathVariable String genere){
        long count = serveiVideojocs.comptarPerGenere(genere);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/videojocs")
    public ResponseEntity<?> crearUsuari(@RequestBody Videojoc nou){
        Videojoc videojoc = serveiVideojocs.afegirVideojoc(nou);
        return new ResponseEntity<Videojoc>(videojoc, HttpStatus.CREATED);
    }



    /*



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
