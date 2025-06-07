package com.tuempresa.gestionpartidos.model.estrategiaEmparejamiento;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.Usuario;
import java.util.List;

/**
 * Interfaz del patrón Strategy para emparejamiento de partidos.
 */
public interface IEstrategiaEmparejamiento {
    List<Partido> emparejar(Usuario usuario, List<Partido> partidos);
}
