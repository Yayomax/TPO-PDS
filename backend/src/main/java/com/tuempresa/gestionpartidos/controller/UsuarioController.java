package com.tuempresa.gestionpartidos.controller;

import com.tuempresa.gestionpartidos.model.UsuarioConcreto;
import com.tuempresa.gestionpartidos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para usuarios.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public UsuarioConcreto registrar(@RequestBody UsuarioConcreto usuario) {
        return usuarioService.registrar(usuario);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioConcreto> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping
    public List<UsuarioConcreto> listarTodos() {
        return usuarioService.listarTodos();
    }
}
