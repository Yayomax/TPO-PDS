package com.tuempresa.gestionpartidos.model.decoratorUsuario;

import com.tuempresa.gestionpartidos.model.Usuario;

/**
 * Decorador abstracto para usuarios.
 * Permite agregar responsabilidades dinámicamente.
 */
public abstract class UsuarioDecorator implements Usuario {
    protected Usuario usuario;

    public UsuarioDecorator(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Long getId() {
        return usuario.getId();
    }

    @Override
    public String getNombre() {
        return usuario.getNombre();
    }

    @Override
    public String getEmail() {
        return usuario.getEmail();
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }
}
