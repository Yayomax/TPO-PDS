package com.tuempresa.gestionpartidos.model.notificacion;

import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Clase que representa una notificación genérica.
 */
public class Notificacion {
    private Usuario destinatario;
    private String mensaje;

    public Notificacion(Usuario destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
