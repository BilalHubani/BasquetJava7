package com.mycompany.dambasquet;

import java.util.ArrayList;

public class ListaJugadores {
    
    private ArrayList<Jugador> listaJugadores;

    public ListaJugadores() {
        listaJugadores = new ArrayList<>();
    }
    
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }
    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    
    public void altaJugador(Jugador j){
        listaJugadores.add(j);
    }
    
    public int tamaño(){
        return listaJugadores.size();
    }

}
