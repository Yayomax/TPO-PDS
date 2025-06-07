package com.tuempresa.gestionpartidos.model;

import com.tuempresa.gestionpartidos.model.estado.EstadoPartido;
import com.tuempresa.gestionpartidos.model.estrategiaEmparejamiento.IEstrategiaEmparejamiento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad principal que representa un partido deportivo.
 * Aplica los patrones State y Strategy.
 */
public class Partido {
    private String deporte;
    private String ubicacion;
    private LocalDateTime horario;
    private int duracion;
    private int cantidadJugadores;
    private List<Usuario> jugadores = new ArrayList<>();
    private EstadoPartido estado;
    private IEstrategiaEmparejamiento emparejador;

    public Partido(String deporte, String ubicacion, LocalDateTime horario, int duracion, int cantidadJugadores, EstadoPartido estado, IEstrategiaEmparejamiento emparejador) {
        this.deporte = deporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.duracion = duracion;
        this.cantidadJugadores = cantidadJugadores;
        this.estado = estado;
        this.emparejador = emparejador;
    }

    public void cambiarEstado(EstadoPartido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void cambiarEstrategia(IEstrategiaEmparejamiento nuevaEstrategia) {
        this.emparejador = nuevaEstrategia;
    }

    // Getters y setters omitidos por brevedad
}
