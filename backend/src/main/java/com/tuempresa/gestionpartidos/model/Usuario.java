package com.tuempresa.gestionpartidos.model;

/**
 * Interfaz base para usuarios del sistema.
 * Permite aplicar el patrón Decorator para enriquecer usuarios.
 */
public interface Usuario {
    Long getId();
    String getNombre();
    String getEmail();
    String getPassword();
    void setPassword(String password);
}
