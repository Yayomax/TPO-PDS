package com.tuempresa.gestionpartidos.model.estado;

import com.tuempresa.gestionpartidos.model.Usuario;
import com.tuempresa.gestionpartidos.model.Partido;

/**
 * Interfaz del patrón State para el ciclo de vida de un partido.
 */
public interface EstadoPartido {
    void agregarJugador(Partido partido, Usuario usuario);
    void confirmarJugador(Partido partido, Usuario usuario);
    String getNombre();
}
