package com.alejrest.ejercicios060708;

public class Conexion {
    private String conector;
    private static Conexion conexion;

    private Conexion(String conector){
        this.conector = conector;
    }

    public static Conexion getInstance(String conector){
        if (conexion == null){
            conexion = new Conexion(conector);
        }else{
            System.out.println("La conexión ya estaba creada");
        }
        return conexion;
    }

    public String getConector() {
        return conector;
    }
}
