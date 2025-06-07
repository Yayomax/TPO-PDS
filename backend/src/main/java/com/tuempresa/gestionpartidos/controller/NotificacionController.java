package com.tuempresa.gestionpartidos.controller;

import com.tuempresa.gestionpartidos.model.notificacion.Notificacion;
import com.tuempresa.gestionpartidos.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para notificaciones.
 */
@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @PostMapping
    public void enviarNotificacion(@RequestBody Notificacion notificacion) {
        notificacionService.notificar(notificacion);
    }
}
