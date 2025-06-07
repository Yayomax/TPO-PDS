package com.tuempresa.gestionpartidos.service;

import com.tuempresa.gestionpartidos.model.notificacion.IStrategiaNotificacion;
import com.tuempresa.gestionpartidos.model.notificacion.Notificacion;
import org.springframework.stereotype.Service;

/**
 * Servicio para envío de notificaciones.
 */
@Service
public class NotificacionService {
    private IStrategiaNotificacion estrategia;

    public NotificacionService(IStrategiaNotificacion estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(IStrategiaNotificacion estrategia) {
        this.estrategia = estrategia;
    }

    public void notificar(Notificacion notificacion) {
        estrategia.enviar(notificacion);
    }
}
