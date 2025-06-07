package com.tuempresa.gestionpartidos.model.estado;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Estado: partido confirmado, listo para jugar.
 * Transita a EstadoEnJuego cuando inicia el partido.
 */
public class EstadoConfirmado implements EstadoPartido {
    @Override
    public void agregarJugador(Partido partido, Usuario usuario) {
        // No se pueden agregar jugadores en este estado
    }

    @Override
    public void confirmarJugador(Partido partido, Usuario usuario) {
        // No aplica, ya está confirmado
    }

    @Override
    public String getNombre() {
        return "Confirmado";
    }
}
