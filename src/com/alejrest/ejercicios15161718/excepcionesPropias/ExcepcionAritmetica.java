package com.alejrest.ejercicios15161718.excepcionesPropias;

public class ExcepcionAritmetica extends ArithmeticException{

    public ExcepcionAritmetica(String mensaje){
        super("No es posible realizar la operación aritmetica: " + mensaje);
    }
}
