package com.tuempresa.gestionpartidos.repository;

import com.tuempresa.gestionpartidos.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para partidos.
 */
@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    // Métodos de consulta personalizados si es necesario
}
