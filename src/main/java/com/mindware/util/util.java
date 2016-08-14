package com.mindware.util;

public class util {
	
	public Boolean validarTelefono(String numero) {
       
	   if (numero.length()!= 8) {
    	   return false;
       }
       else return true;
		
	}
	
	public Boolean esNumero(String numero){
		try {
			Integer.parseInt(numero);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}

}
