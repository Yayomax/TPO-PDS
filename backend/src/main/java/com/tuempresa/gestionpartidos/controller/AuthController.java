package com.tuempresa.gestionpartidos.controller;

import com.tuempresa.gestionpartidos.model.UsuarioConcreto;
import com.tuempresa.gestionpartidos.security.JwtTokenProvider;
import com.tuempresa.gestionpartidos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioConcreto usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.registrar(usuario);
        return ResponseEntity.ok("Usuario registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        UsuarioConcreto usuario = usuarioService.buscarPorEmail(credentials.get("email"));
        if (usuario == null || !passwordEncoder.matches(credentials.get("password"), usuario.getPassword())) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
        String token = jwtTokenProvider.generarToken(usuario.getEmail());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
