package com.mycompany.dambasquet;
import java.util.ArrayList;

public class ListaEquipos {
    
    private ArrayList<Equipo> listaEquipo;
    
    public ListaEquipos() {
        listaEquipo = new ArrayList<>();
    }

    public ArrayList<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }
    
    public void altaEquipo(Equipo e){
        listaEquipo.add(e);
    }

    public int tamaño(){
        return listaEquipo.size();
    }

}
