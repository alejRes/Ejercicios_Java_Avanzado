package com.alejrest.ejercicios15161718.excepcionesPropias;

public class ExcepcionFueraDeRango extends IndexOutOfBoundsException{

    public ExcepcionFueraDeRango(String mensaje){
        super("Indice fuera de rango: " + mensaje);
    }
}
