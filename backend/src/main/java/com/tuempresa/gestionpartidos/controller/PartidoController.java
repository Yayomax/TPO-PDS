package com.tuempresa.gestionpartidos.controller;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;
import com.tuempresa.gestionpartidos.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para partidos.
 */
@RestController
@RequestMapping("/api/partidos")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public Partido crearPartido(@RequestBody Partido partido) {
        return partidoService.crearPartido(partido);
    }

    @GetMapping("/{id}")
    public Optional<Partido> buscarPorId(@PathVariable Long id) {
        return partidoService.buscarPorId(id);
    }

    @GetMapping
    public List<Partido> listarTodos() {
        return partidoService.listarTodos();
    }

    @PostMapping("/{id}/agregar-jugador")
    public void agregarJugador(@PathVariable Long id, @RequestBody Usuario usuario) {
        partidoService.agregarJugador(id, usuario);
    }
}
