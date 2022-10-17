package com.alejrest.ejercicios060708;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstance("mysql");
        Conexion conexion2 = Conexion.getInstance("mongodb");

        System.out.println("Esta es la direccion de memoria de la conexion " + conexion + " a " + conexion.getConector());
        System.out.println("Esta es la direccion de memoria de la conexion2 " + conexion2 + " a " + conexion2.getConector());

    }
}
