package com.tuempresa.gestionpartidos.repository;

import com.tuempresa.gestionpartidos.model.UsuarioConcreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para usuarios.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioConcreto, Long> {
    UsuarioConcreto findByEmail(String email);
}
