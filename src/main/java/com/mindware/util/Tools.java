package com.mindware.util;

/**
 * Created by freddy on 19-08-16.
 */
public class Tools {
    public  static Boolean ValidarTelefono(String numero) {


        if (numero.length()!= 8) {
            return false;
        }
        else  if (!numero.startsWith("6|7")) {
            return false;
        }
        else  if (EsNumero(numero)) {
            return true;
        } else return false;


    }

    public static Boolean EsNumero(String numero){
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
