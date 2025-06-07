package com.tuempresa.gestionpartidos.model.notificacion;

/**
 * Adapter para enviar emails usando JavaMail (mock).
 */
public class AdapterJavaEmail {
    public void enviarEmail(Notificacion notificacion) {
        // Simulación de envío de email
        System.out.println("[EMAIL] " + notificacion.getDestinatario().getEmail() + ": " + notificacion.getMensaje());
    }
}
