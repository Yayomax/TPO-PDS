package com.tuempresa.gestionpartidos.factory;

import com.tuempresa.gestionpartidos.model.Partido;
import com.tuempresa.gestionpartidos.model.estado.EstadoNecesitamosJugadores;
import com.tuempresa.gestionpartidos.model.estrategiaEmparejamiento.EmparejamientoPorNivel;
import com.tuempresa.gestionpartidos.model.estado.EstadoPartido;
import com.tuempresa.gestionpartidos.model.estrategiaEmparejamiento.IEstrategiaEmparejamiento;
import java.time.LocalDateTime;

/**
 * Factory para crear instancias de Partido con estado y estrategia por defecto.
 */
public class FactoryPartido {
    public static Partido crear(String deporte, String ubicacion, LocalDateTime horario, int duracion, int cantidadJugadores) {
        EstadoPartido estadoInicial = new EstadoNecesitamosJugadores();
        IEstrategiaEmparejamiento estrategia = new EmparejamientoPorNivel();
        return new Partido(deporte, ubicacion, horario, duracion, cantidadJugadores, estadoInicial, estrategia);
    }
}
