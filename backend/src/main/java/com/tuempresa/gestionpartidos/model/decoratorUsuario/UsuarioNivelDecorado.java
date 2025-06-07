package com.tuempresa.gestionpartidos.model.decoratorUsuario;

import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Decorador que agrega el nivel de juego al usuario.
 */
public class UsuarioNivelDecorado extends UsuarioDecorator {
    private int nivelJuego;

    public UsuarioNivelDecorado(Usuario usuario, int nivelJuego) {
        super(usuario);
        this.nivelJuego = nivelJuego;
    }

    public int getNivelJuego() {
        return nivelJuego;
    }

    @Override
    public void setEmail(String email) {
        usuario.setEmail(email);
    }

    @Override
    public void setNombre(String nombre) {
        usuario.setNombre(nombre);
    }
}
