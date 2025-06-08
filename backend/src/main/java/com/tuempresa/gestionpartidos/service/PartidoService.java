package com.tuempresa.gestionpartidos.service;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;
import com.tuempresa.gestionpartidos.model.estado.EstadoCancelado;
import com.tuempresa.gestionpartidos.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Servicio para lógica de negocio de partidos.
 */
@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public Partido crearPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Optional<Partido> buscarPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public List<Partido> listarTodos() {
        return partidoRepository.findAll();
    }

    public void agregarJugador(Long partidoId, Usuario usuario) {
        Optional<Partido> partidoOpt = partidoRepository.findById(partidoId);
        partidoOpt.ifPresent(partido -> {
            partido.getEstadoReal().agregarJugador(partido, usuario);
            partidoRepository.save(partido);
        });
    }

    // Buscar partidos donde el usuario es jugador
    public List<Partido> listarPorUsuario(Long usuarioId) {
        return partidoRepository.findAll().stream()
            .filter(p -> p.getJugadores().stream().anyMatch(j -> j.getId().equals(usuarioId)))
            .collect(Collectors.toList());
    }

    public void salirDePartido(Long partidoId, Long usuarioId) {
        Optional<Partido> partidoOpt = partidoRepository.findById(partidoId);
        partidoOpt.ifPresent(partido -> {
            partido.getJugadores().removeIf(j -> j.getId().equals(usuarioId));
            partidoRepository.save(partido);
        });
    }

    public boolean cancelarPartido(Long partidoId, Long usuarioId) {
        Optional<Partido> partidoOpt = partidoRepository.findById(partidoId);
        if (partidoOpt.isPresent()) {
            Partido partido = partidoOpt.get();
            if (partido.getCreador() != null && partido.getCreador().getId().equals(usuarioId)) {
                partido.setEstado(new EstadoCancelado());
                partidoRepository.save(partido);
                return true;
            }
        }
        return false;
    }
}
