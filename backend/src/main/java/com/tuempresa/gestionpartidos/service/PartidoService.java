package com.tuempresa.gestionpartidos.service;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;
import com.tuempresa.gestionpartidos.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
            partido.getEstado().agregarJugador(partido, usuario);
            partidoRepository.save(partido);
        });
    }
}
