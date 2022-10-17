package com.alejrest.ejercicios15161718;

import com.alejrest.ejercicios15161718.excepcionesPropias.ExcepcionFicheroNoEncontrado;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PruebaExcepciones pruebasExcepciones = new PruebaExcepciones();
        ArrayList<String> usuarios = new ArrayList();

        usuarios.add("Ramón");
        usuarios.add("Raúl");
        usuarios.add("Roberto");

        try {
            pruebasExcepciones.leerFichero("tutu.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try{
            pruebasExcepciones.dividir(1,0);
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println(pruebasExcepciones.obtenerNombre(usuarios,3));
        }catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
}
