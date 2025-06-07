package com.tuempresa.gestionpartidos.model.decoratorUsuario;

import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Decorador que agrega el deporte favorito al usuario.
 */
public class UsuarioDeporteFavoritoDecorado extends UsuarioDecorator {
    private String deporteFavorito;

    public UsuarioDeporteFavoritoDecorado(Usuario usuario, String deporteFavorito) {
        super(usuario);
        this.deporteFavorito = deporteFavorito;
    }

    public String getDeporteFavorito() {
        return deporteFavorito;
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
