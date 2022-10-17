package com.alejrest.ejercicios15161718;

import com.alejrest.ejercicios15161718.excepcionesPropias.ExcepcionAritmetica;
import com.alejrest.ejercicios15161718.excepcionesPropias.ExcepcionFicheroNoEncontrado;
import com.alejrest.ejercicios15161718.excepcionesPropias.ExcepcionFueraDeRango;

import java.io.*;
import java.util.ArrayList;

public class PruebaExcepciones {

    public void leerFichero(String nombreFichero) throws IOException {

        File file = new File(nombreFichero);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new ExcepcionFicheroNoEncontrado(nombreFichero);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea;
        while ((linea = bufferedReader.readLine()) != null) {
            System.out.println(linea);
        }
    }

    public double dividir(double dividendo, double divisor) throws ExcepcionAritmetica {
        if (divisor != 0) {
            return dividendo / divisor;
        }
        throw new ExcepcionAritmetica("no es posible dividir por 0");
    }

    public String obtenerNombre(ArrayList<String> lista, int posicion) throws ExcepcionFueraDeRango {
        if (posicion >= lista.size())
            throw new ExcepcionFueraDeRango("La posición debe estar entre 0 y " + (lista.size() - 1));

        return lista.get(posicion);
    }
}
