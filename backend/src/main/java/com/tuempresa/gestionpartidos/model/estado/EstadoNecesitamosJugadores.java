package com.tuempresa.gestionpartidos.model.estado;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Estado inicial: se buscan jugadores.
 * Si se completa el cupo, transita a EstadoArmado.
 */
public class EstadoNecesitamosJugadores implements EstadoPartido {
    @Override
    public void agregarJugador(Partido partido, Usuario usuario) {
        partido.agregarJugador(usuario);
        if (partido.getJugadores().size() >= partido.getCantidadJugadores()) {
            partido.cambiarEstado(new EstadoArmado());
        }
    }

    @Override
    public void confirmarJugador(Partido partido, Usuario usuario) {
        // No aplica en este estado
    }

    @Override
    public String getNombre() {
        return "Necesitamos Jugadores";
    }
}
