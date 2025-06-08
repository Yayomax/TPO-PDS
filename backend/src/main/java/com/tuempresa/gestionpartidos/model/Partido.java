package com.tuempresa.gestionpartidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuempresa.gestionpartidos.model.estado.EstadoPartido;
import com.tuempresa.gestionpartidos.model.estrategiaEmparejamiento.IEstrategiaEmparejamiento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ElementCollection;
import javax.persistence.Transient;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entidad principal que representa un partido deportivo.
 * Aplica los patrones State y Strategy.
 */
@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deporte;
    private String ubicacion;
    private LocalDateTime horario;
    private int duracion;
    private int cantidadJugadores;

    @ManyToMany
    private List<UsuarioConcreto> jugadores = new ArrayList<>();

    @ManyToOne
    private UsuarioConcreto creador;

    @JsonIgnore
    @Transient
    private EstadoPartido estado;
    @JsonIgnore
    @Transient
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

    // Constructor vacío requerido por JPA
    public Partido() {}

    public void cambiarEstado(EstadoPartido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void cambiarEstrategia(IEstrategiaEmparejamiento nuevaEstrategia) {
        this.emparejador = nuevaEstrategia;
    }

    public List<UsuarioConcreto> getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    @JsonProperty("estado")
    public String getEstadoNombre() {
        return estado != null ? estado.getNombre() : null;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public void setJugadores(List<UsuarioConcreto> jugadores) {
        this.jugadores = jugadores;
    }

    public void setEstado(EstadoPartido estado) {
        this.estado = estado;
    }

    public void agregarJugador(Usuario usuario) {
        if (usuario instanceof UsuarioConcreto) {
            UsuarioConcreto nuevo = (UsuarioConcreto) usuario;
            if (jugadores.stream().noneMatch(j -> j.getId().equals(nuevo.getId()))) {
                jugadores.add(nuevo);
            }
        } else {
            throw new IllegalArgumentException("Solo se pueden agregar instancias de UsuarioConcreto a la lista de jugadores");
        }
    }

    public String getDeporte() {
        return deporte;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public UsuarioConcreto getCreador() {
        return creador;
    }

    public void setCreador(UsuarioConcreto creador) {
        this.creador = creador;
    }

    // Getter para el estado real (no serializado)
    @JsonIgnore
    public EstadoPartido getEstadoReal() {
        return estado;
    }
}
