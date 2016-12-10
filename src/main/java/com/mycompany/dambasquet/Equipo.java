package com.mycompany.dambasquet;

import javax.annotation.Generated;
import java.util.Date;


public class Equipo {
    private int id;
    private String nombre;
    private String localidad;
    private Date creacion;
    private ListaJugadores listaJugadores;

    public Equipo() {
    }

    
    public Equipo(int id, String nombre, String localidad, Date creacion) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.creacion = creacion;
        listaJugadores = new ListaJugadores();
    }

    
    public ListaJugadores getListaJugadores() {
        return listaJugadores;
    }
    public void setListaJugadores(ListaJugadores listaJugadores) {
        this.listaJugadores = listaJugadores;
    }   
    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", creacion=" + creacion +
                "}\n";
    }
}
