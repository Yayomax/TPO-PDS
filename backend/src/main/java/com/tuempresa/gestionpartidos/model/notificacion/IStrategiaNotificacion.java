package com.tuempresa.gestionpartidos.model.notificacion;

import com.tuempresa.gestionpartidos.model.notificacion.Notificacion;

/**
 * Interfaz Strategy para envío de notificaciones.
 */
public interface IStrategiaNotificacion {
    void enviar(Notificacion notificacion);
}
