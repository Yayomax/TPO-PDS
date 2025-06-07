package com.tuempresa.gestionpartidos.model.notificacion;

/**
 * Implementación de notificación por email (usa AdapterJavaEmail).
 */
public class NotificacionEmail implements IStrategiaNotificacion {
    private AdapterJavaEmail adapter;

    public NotificacionEmail(AdapterJavaEmail adapter) {
        this.adapter = adapter;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        adapter.enviarEmail(notificacion);
    }
}
