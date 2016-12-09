package com.mycompany.dambasquet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Basquet {
    private static ListaEquipos listaEquipos;
    private static Fichero ficheroEquipos;
    public static void main(String[] args) {
        ficheroEquipos = new Fichero("basket.xml");
        listaEquipos = (ListaEquipos) ficheroEquipos.leer();

        if(listaEquipos == null){
            listaEquipos = new ListaEquipos();
        }
        int opcion = 0;
        int opcion2 = 0;
        int opcion3 = 0;
        do {
            mostrarMenu();
            opcion = EntradaDatos.pedirEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    altaEquipo();
                    break;
                case 2:
                    altaJugador();
                    break;
                case 3:
                    do {
                        mostrarMenuJugadores();
                        opcion2 = EntradaDatos.pedirEntero("Elige una opción: ");
                        switch (opcion2){
                            case 1:
                                consultaJugador1();
                                break;
                            case 2:
                                consultaJugador2();
                                break;
                            case 3:
                                consultaJugador3();
                                break;
                            case 4:
                                consultaJugador4();
                                break;
                            case 5:
                                consultaJugador5();
                                break;
                            case 6:
                                consultaJugador6();
                                break;
                            case 7:
                                consultaJugador7();
                                break;
                            case 8:
                                System.out.println("Volviendo al menu anterior");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    }while (opcion2 != 8);
                    break;
                case 4:
                    do {
                        mostrarMenuEquipos();
                        opcion3 = EntradaDatos.pedirEntero("Elige una opción: ");
                        switch (opcion3){
                            case 1:
                                consultaEquipo1();
                                break;
                            case 2:
                                consultaEquipo2();
                                break;
                            case 3:
                                consultaEquipo3();
                                break;
                            case 4:
                                consultaEquipo4();
                                break;
                            case 5:
                                System.out.println("Volviendo al menu anterior");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    }while (opcion3 != 5);
                    break;
                case 5:
                    System.out.println("Pasa un buen dia :)");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }while (opcion != 5);
    }
    public static void mostrarMenu(){
        System.out.println("1. Dar de alta un equipo");
        System.out.println("2. Dar de alta un jugador");
        System.out.println("3. Menu de consultas de un jugadores");
        System.out.println("4. Menu de consultas de equipos");
        System.out.println("5. Salir");
    }
    public static void mostrarMenuJugadores(){
        System.out.println("1. Buscar jugadores por nombre");
        System.out.println("2. Buscar jugadores que hayan conseguido un numero mayor o igual a x");
        System.out.println("3. Buscar jugadores con un numero de asistencias dentro de un rango");
        System.out.println("4. Buscar jugadores que pertenezcan a una posicion especifica");
        System.out.println("5. Buscar jugadores que hayan nacido antes de una fecha en concreto");
        System.out.println("6. Agrupar jugadores por la posicion del campo");
        System.out.println("7. Lo mismo que la anterior pero devolviendo mas cosas");
        System.out.println("8. Volver al menu anterior");
    }
    public static void mostrarMenuEquipos(){
        System.out.println("1. Consulta los equipos de una localidad");
        System.out.println("2. Devolver todos los jugadores de un equipo");
        System.out.println("3. Devolver todos los jugadores de un equipo que jueguen en la misma posicion");
        System.out.println("4. Devolver el jugador con mas canastas de un equipo");
        System.out.println("5. Volver al menu anterior");
    }
    public static void altaEquipo(){
        int id = listaEquipos.tamaño() +1;
        String nombre = EntradaDatos.pedirCadena("Escribe el nombre del equipo");
        String localidad = EntradaDatos.pedirCadena("Escribe la localidad del equipo");
        Date creacion;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        do {
            dia = EntradaDatos.pedirEntero("Dia de nacimiento");
        }while(dia<1 || dia > 31);
        do {
            mes = EntradaDatos.pedirEntero("Mes de nacimiento");
        }while (mes<1 || mes>12);
        do {
            ano = EntradaDatos.pedirEntero("Año de nacimiento");
        }while (ano<1 || ano>2016);
        creacion = new Date(ano,mes,dia);
        Equipo equipo = new Equipo(id, nombre,localidad,creacion);
        listaEquipos.altaEquipo(equipo);
        ficheroEquipos.grabar(listaEquipos);
        System.out.println("Equipo dado de alta");
    }
    public static void altaJugador(){
        int id = 1;
        for (Equipo e: listaEquipos.getListaEquipo()) {
            id = id + e.getListaJugadores().tamaño();
        }
        String nombreEquipo = EntradaDatos.pedirCadena("Escribe el nombre de tu equipo");
        boolean existe = false;
        Equipo equipo = null;
        for (Equipo e: listaEquipos.getListaEquipo()){
            if (nombreEquipo.equalsIgnoreCase(e.getNombre())){
                existe = true;
                equipo = e;
            }
        }
        if (existe){
            String nombre = EntradaDatos.pedirCadena("Introduce el nombre del jugador");
            String posicion = EntradaDatos.pedirCadena("Introduce la posicion");
            Date nacimiento;
            int dia = 0;
            int mes = 0;
            int ano = 0;
            do {
                dia = EntradaDatos.pedirEntero("Dia de la creacion");
            }while(dia<1 || dia > 31);
            do {
                mes = EntradaDatos.pedirEntero("Mes de la creacion");
            }while (mes<1 || mes>12);
            do {
                ano = EntradaDatos.pedirEntero("Año de la creacion");
            }while (ano<1 || ano>2016);
            nacimiento = new Date(ano,mes,dia);
            Jugador jugador = new Jugador(id,nombre,nacimiento,(int) Math.random()*30, (int) Math.random()*30,(int) Math.random()*30, posicion);
            equipo.getListaJugadores().altaJugador(jugador);
            ficheroEquipos.grabar(listaEquipos);
            System.out.println("Jugador dado de alta");
        }else {
            System.out.println("El equipo introducido aun no ha sido registrado");
        }
    }
    public static void consultaJugador1(){

    }
    public static void consultaJugador2(){

    }
    public static void consultaJugador3(){

    }
    public static void consultaJugador4(){

    }
    public static void consultaJugador5(){

    }
    public static void consultaJugador6(){

    }
    public static void consultaJugador7(){

    }
    public static void consultaEquipo1(){

    }
    public static void consultaEquipo2(){

    }
    public static void consultaEquipo3(){

    }
    public static void consultaEquipo4(){

    }
}
