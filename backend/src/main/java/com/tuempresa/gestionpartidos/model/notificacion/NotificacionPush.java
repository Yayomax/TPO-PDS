package com.tuempresa.gestionpartidos.model.notificacion;

/**
 * Implementación de notificación push (mock, simula Firebase).
 */
public class NotificacionPush implements IStrategiaNotificacion {
    @Override
    public void enviar(Notificacion notificacion) {
        // Simulación de envío push
        System.out.println("[PUSH] " + notificacion.getDestinatario().getEmail() + ": " + notificacion.getMensaje());
    }
}
