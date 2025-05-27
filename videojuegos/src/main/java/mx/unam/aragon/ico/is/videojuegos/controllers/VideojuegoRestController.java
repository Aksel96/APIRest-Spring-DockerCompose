package mx.unam.aragon.ico.is.videojuegos.controllers;


import mx.unam.aragon.ico.is.videojuegos.entities.Videojuego;
import mx.unam.aragon.ico.is.videojuegos.services.interfaces.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideojuegoRestController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Videojuego>> getVideojuego() {
        return new ResponseEntity<>(videojuegoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Videojuego> getVideojuegoPorClave(@PathVariable Long clave) {
        Optional<Videojuego> tmp = videojuegoService.buscarPorId(clave);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Videojuego> createVideojuego(@RequestBody Videojuego videojuego) {
        return new ResponseEntity<>(videojuegoService.crear(videojuego), HttpStatus.CREATED);
    }

    @PostMapping("{id}")
    public ResponseEntity<String> noExiste(){
        return new ResponseEntity<>("EndPoint no soportado",HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{clave}")
    public ResponseEntity<Videojuego> actualizaParcial(@PathVariable Long clave, @RequestBody Videojuego videojuego) {
        Videojuego tmp = videojuegoService.buscarPorId(clave).orElse(null);
        if (tmp != null) {
            if (videojuego.getNombre() != null) tmp.setNombre(videojuego.getNombre());
            if (videojuego.getGenero() != null) tmp.setGenero(videojuego.getGenero());
            if (videojuego.getPortada() != null) tmp.setPortada(videojuego.getPortada());
            if (videojuego.getPrecio() != null) tmp.setPrecio(videojuego.getPrecio());

            return new ResponseEntity<>(videojuegoService.actualizar(clave,tmp), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{clave}")
    public ResponseEntity<Videojuego> editar(@PathVariable Long clave, @RequestBody Videojuego videojuego) {
        Optional<Videojuego> tmp = videojuegoService.buscarPorId(clave);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(videojuegoService.actualizar(clave,videojuego), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{clave}")
    public ResponseEntity<String> eliminar(@PathVariable Long clave) {
        Optional<Videojuego> tmp = videojuegoService.buscarPorId(clave);
        if (tmp.isPresent()) {
            videojuegoService.eliminar(clave);
            return new ResponseEntity<>("Se elimino el registro con id: " + clave, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
