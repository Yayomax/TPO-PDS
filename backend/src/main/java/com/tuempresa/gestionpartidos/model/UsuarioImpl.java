package com.tuempresa.gestionpartidos.model;

/**
 * Implementación concreta de Usuario.
 */
public class UsuarioImpl implements Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String password;

    public UsuarioImpl(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
