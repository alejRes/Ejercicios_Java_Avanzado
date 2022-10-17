package com.alejrest.ejercicios15161718.excepcionesPropias;

import java.io.FileNotFoundException;

public class ExcepcionFicheroNoEncontrado extends FileNotFoundException {
    public ExcepcionFicheroNoEncontrado(String mensaje){
        super("Fichero no encontrado:" + mensaje);
    }
}
