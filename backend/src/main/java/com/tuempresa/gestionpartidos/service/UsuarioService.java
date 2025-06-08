package com.tuempresa.gestionpartidos.service;

import com.tuempresa.gestionpartidos.model.UsuarioConcreto;
import com.tuempresa.gestionpartidos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioConcreto registrar(UsuarioConcreto usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioConcreto> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioConcreto buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<UsuarioConcreto> listarTodos() {
        return usuarioRepository.findAll();
    }

    public boolean validarCredenciales(String email, String password) {
        UsuarioConcreto usuario = usuarioRepository.findByEmail(email);
        return usuario != null && passwordEncoder.matches(password, usuario.getPassword());
    }
}
