package com.mycompany.dambasquet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consultas {
    public static List<Jugador> buscarJugadorNombre(List<Equipo> equipos, String nombre){
        List<Jugador> listaJugadores = new ArrayList<>();
        String nombrec;
        String nombrem;
        for (Equipo equipo: equipos){
            for (Jugador jugador: equipo.getListaJugadores().getListaJugadores()){
                nombrec=jugador.getNombre().toLowerCase();
                nombrem=nombre.toLowerCase();
                if (nombrec.contains(nombrem))
                    listaJugadores.add(jugador);
            }
        }
        return listaJugadores;
    }
    public static List<Jugador> buscarJugadoresPorCanastas(List<Equipo> equipos, int canastas) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()) {
                if (jugador.getCanastas() >= canastas){
                    jugadores.add(jugador);
                }
            }
        }
        return jugadores;
    }
    public static List<Jugador> buscarJugadoresEntreAsistencias(List <Equipo> equipos, int asistenciasMin, int asistenciasMax){
        List<Jugador> jugadoresAsistencias = new ArrayList<>();
        for (Equipo equipo : equipos){
            for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()){
                if(jugador.getAsistencias()>= asistenciasMin && jugador.getAsistencias() <= asistenciasMax ){
                    jugadoresAsistencias.add(jugador);
                }
            }
        }
        return jugadoresAsistencias;
    }
    public static List<Jugador> buscarJugadoresDeUnaPosicion(List<Equipo> equipos, String posicion){
        List<Jugador> jugadoresPosicion = new ArrayList<>();
        for (Equipo equipo : equipos){
            for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()){
                if(jugador.getPosicion().equalsIgnoreCase(posicion) ){
                    jugadoresPosicion.add(jugador);
                }
            }
        }
        return jugadoresPosicion;
    }
    public static List<Jugador> buscarJugadoresDeUnEquipo(List<Equipo> equipos, String nombre){
        List<Jugador> jugadoresDeUnEquipo = new ArrayList<>();
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equalsIgnoreCase(nombre)){
                for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()){
                    jugadoresDeUnEquipo.add(jugador);
                }
            }
        }
        return jugadoresDeUnEquipo;
    }
    public static List<Equipo> buscarEquipoLocalidad(List<Equipo> equipos, String localidad){
        List<Equipo> equiposLocalidad = new ArrayList<>();
        for (Equipo equipo : equipos){
            if(equipo.getLocalidad().equalsIgnoreCase(localidad)){
                equiposLocalidad.add(equipo);
            }
        }
        return equiposLocalidad;
    }
    public static List<Jugador> buscarJugadoresDeUnEquipoYPosicion(List<Equipo> equipos, String nombre, String posicion){
        List<Jugador> jugadoresEquipoPosicion = new ArrayList<>();
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equalsIgnoreCase(nombre)){
                for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()){
                    if(jugador.getPosicion().equalsIgnoreCase(posicion) ){
                        jugadoresEquipoPosicion.add(jugador);
                    }
                }
            }
        }
        return jugadoresEquipoPosicion;
    }
    public static List<Jugador> buscarJugadoresMaxCanastasEquipo(List<Equipo> equipos, String nombre){
        List<Jugador> jugadoresMaxCanastas = new ArrayList<>();
        int max = 0;
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equalsIgnoreCase(nombre)){
                for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()){
                    if(jugador.getCanastas()>max){
                        max = jugador.getCanastas();
                    }
                }
                for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()){
                    if(jugador.getCanastas()==max){
                        jugadoresMaxCanastas.add(jugador);
                    }
                }
            }
        }
        return jugadoresMaxCanastas;
    }
    public static List<Jugador> buscarJugadoresNacimiento(List<Equipo> equipos, Date nacimiento){
        List<Jugador> jugadoresNacimiento= new ArrayList<>();
        for (Equipo equipo : equipos){
            for (Jugador jugador : equipo.getListaJugadores().getListaJugadores()){
                
            }
        }
        return jugadoresNacimiento;
    }
    public static void AVGCantastasAsistenciasRebotes(List<Equipo> equipos, String posicion){
        double totalCanastas=0;
        double totalRebotes=0;
        double totalAsistencias=0;
        double contador = 0;
        for (Equipo e: equipos){
            for (Jugador j : e.getListaJugadores().getListaJugadores()){
                if (j.getPosicion().equalsIgnoreCase(posicion)) {
                    totalAsistencias += j.getAsistencias();
                    totalCanastas += j.getCanastas();
                    totalRebotes += j.getRebote();
                    contador++;
                }
            }
        }
        System.out.println("La media de canastas es: "+(totalCanastas/contador));
        System.out.println("La media de asistencias es: "+(totalAsistencias/contador));
        System.out.println("La media de rebotes es: "+(totalRebotes/contador));
    }
    public static void AVGMaxMinCantastasAsistenciasRebotes(List<Equipo> equipos, String posicion){
        double totalCanastas=0;
        double totalRebotes=0;
        double totalAsistencias=0;
        double contador = 0;
        int maxCanastas = 0;
        int minCanastas = 30;
        int maxRebotes = 0;
        int minRebotes = 30;
        int maxAsistencias =0;
        int minAsistencias = 30;
        for (Equipo e: equipos){
            for (Jugador j : e.getListaJugadores().getListaJugadores()){
                if (j.getPosicion().equalsIgnoreCase(posicion)) {
                    totalAsistencias += j.getAsistencias();
                    totalCanastas += j.getCanastas();
                    totalRebotes += j.getRebote();
                    if (j.getCanastas()>maxCanastas)
                        maxCanastas=j.getCanastas();
                    if (j.getCanastas()<minCanastas)
                        minCanastas=j.getCanastas();
                    if (j.getRebote()>maxRebotes)
                        maxRebotes=j.getRebote();
                    if (j.getRebote()<minRebotes)
                        minRebotes=j.getRebote();
                    if (j.getAsistencias()>maxAsistencias)
                        maxAsistencias=j.getAsistencias();
                    if (j.getAsistencias()<minAsistencias)
                        minAsistencias=j.getAsistencias();
                    contador++;
                }
            }
        }
        System.out.println("El maximo de canastas es: "+maxCanastas);
        System.out.println("La media de canastas es: "+(totalCanastas/contador));
        System.out.println("El minimo de canastas es: "+minCanastas);
        System.out.println("El maximo de asistencias es: "+maxAsistencias);
        System.out.println("La media de asistencias es: "+(totalAsistencias/contador));
        System.out.println("El minimo de asistencias es: "+minAsistencias);
        System.out.println("El maximo de rebotes es: "+maxRebotes);
        System.out.println("La media de rebotes es: "+(totalRebotes/contador));
        System.out.println("El minimo de rebotes es: "+minRebotes);
    }
}
