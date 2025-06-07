package com.tuempresa.gestionpartidos.model.estado;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Estado: partido armado, esperando confirmaciones.
 * Si todos confirman, pasa a EstadoConfirmado.
 */
public class EstadoArmado implements EstadoPartido {
    @Override
    public void agregarJugador(Partido partido, Usuario usuario) {
        // No se pueden agregar más jugadores
    }

    @Override
    public void confirmarJugador(Partido partido, Usuario usuario) {
        // Lógica de confirmación (ejemplo: marcar usuario como confirmado)
        // Si todos confirman:
        // partido.cambiarEstado(new EstadoConfirmado());
    }

    @Override
    public String getNombre() {
        return "Armado";
    }
}
