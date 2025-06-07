package com.tuempresa.gestionpartidos.model.estado;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Estado: partido cancelado.
 * Estado terminal.
 */
public class EstadoCancelado implements EstadoPartido {
    @Override
    public void agregarJugador(Partido partido, Usuario usuario) {
        // No se pueden agregar jugadores
    }

    @Override
    public void confirmarJugador(Partido partido, Usuario usuario) {
        // No aplica
    }

    @Override
    public String getNombre() {
        return "Cancelado";
    }
}
