package com.tuempresa.gestionpartidos.controller;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;
import com.tuempresa.gestionpartidos.model.UsuarioConcreto;
import com.tuempresa.gestionpartidos.service.PartidoService;
import com.tuempresa.gestionpartidos.service.UsuarioService;
import com.tuempresa.gestionpartidos.factory.FactoryPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Partido crearPartido(@RequestBody Partido partido, @RequestParam Long usuarioId) {
        Partido nuevo = FactoryPartido.crear(
            partido.getDeporte(),
            partido.getUbicacion(),
            partido.getHorario(),
            partido.getDuracion(),
            partido.getCantidadJugadores()
        );
        UsuarioConcreto creador = usuarioService.buscarPorId(usuarioId).orElse(null);
        if (creador != null) {
            nuevo.setCreador(creador);
            nuevo.getJugadores().add(creador);
        }
        // Solo setear jugadores si la lista viene y tiene elementos
        if (partido.getJugadores() != null && !partido.getJugadores().isEmpty()) {
            nuevo.setJugadores(partido.getJugadores());
            // Asegurarse de que el creador esté en la lista
            if (creador != null && nuevo.getJugadores().stream().noneMatch(j -> j.getId().equals(creador.getId()))) {
                nuevo.getJugadores().add(creador);
            }
        }
        return partidoService.crearPartido(nuevo);
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

    @PostMapping("/{id}/salir")
    public void salirDePartido(@PathVariable Long id, @RequestParam Long usuarioId) {
        partidoService.salirDePartido(id, usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Partido> listarPorUsuario(@PathVariable Long usuarioId) {
        return partidoService.listarPorUsuario(usuarioId);
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelarPartido(@PathVariable Long id, @RequestParam Long usuarioId) {
        boolean ok = partidoService.cancelarPartido(id, usuarioId);
        if (ok) return ResponseEntity.ok().build();
        return ResponseEntity.status(403).body("Solo el creador puede cancelar el partido");
    }
}
