package com.tuempresa.gestionpartidos.service;

import com.tuempresa.gestionpartidos.model.Usuario;
import com.tuempresa.gestionpartidos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para lógica de negocio de usuarios.
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}
