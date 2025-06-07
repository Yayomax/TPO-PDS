package com.tuempresa.gestionpartidos.model.estado;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Estado: partido en juego.
 * Al finalizar, transita a EstadoFinalizado.
 */
public class EstadoEnJuego implements EstadoPartido {
    @Override
    public void agregarJugador(Partido partido, Usuario usuario) {
        // No se pueden agregar jugadores en juego
    }

    @Override
    public void confirmarJugador(Partido partido, Usuario usuario) {
        // No aplica
    }

    @Override
    public String getNombre() {
        return "En Juego";
    }
}
