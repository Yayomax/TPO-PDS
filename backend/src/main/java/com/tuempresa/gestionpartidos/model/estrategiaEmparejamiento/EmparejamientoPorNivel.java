package com.tuempresa.gestionpartidos.model.estrategiaEmparejamiento;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Empareja partidos según el nivel de juego del usuario.
 */
public class EmparejamientoPorNivel implements IEstrategiaEmparejamiento {
    @Override
    public List<Partido> emparejar(Usuario usuario, List<Partido> partidos) {
        // Ejemplo: filtrar partidos por nivel (requiere decorator de nivel)
        // Aquí se asume que todos los partidos son válidos
        return partidos.stream().collect(Collectors.toList());
    }
}
