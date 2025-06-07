package com.tuempresa.gestionpartidos.model.estrategiaEmparejamiento;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Empareja partidos según historial del usuario (mock).
 */
public class EmparejamientoPorHistorial implements IEstrategiaEmparejamiento {
    @Override
    public List<Partido> emparejar(Usuario usuario, List<Partido> partidos) {
        // Ejemplo: filtrar partidos por historial (mock)
        return partidos.stream().collect(Collectors.toList());
    }
}
