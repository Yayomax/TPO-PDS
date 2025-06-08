package com.tuempresa.gestionpartidos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.tuempresa.gestionpartidos.model.notificacion.IStrategiaNotificacion;
import com.tuempresa.gestionpartidos.model.notificacion.NotificacionEmail;
import com.tuempresa.gestionpartidos.model.notificacion.NotificacionPush;
import com.tuempresa.gestionpartidos.model.notificacion.AdapterJavaEmail;

@Configuration
public class NotificationConfig {

    @Bean
    @Primary
    public IStrategiaNotificacion pushNotificacion() {
        return new NotificacionPush();
    }

    @Bean
    public IStrategiaNotificacion emailNotificacion(AdapterJavaEmail adapterJavaEmail) {
        return new NotificacionEmail(adapterJavaEmail);
    }
}
