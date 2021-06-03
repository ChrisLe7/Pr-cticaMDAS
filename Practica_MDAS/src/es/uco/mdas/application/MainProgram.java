package es.uco.mdas.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {
	
	public static void main(String[] argv) {
		System.out.println("Buenas esta iniciando el Gestor de Socios y Abonados");
		int optionSistema = 1;
		AplicacionSocio aplicacionSocio = new AplicacionSocio();
		AplicacionAbono aplicacionAbono = new AplicacionAbono();
		Scanner opcionElegida;
		while (optionSistema != 0) {
			
			PrintMenu();
			
		    try {
		    	opcionElegida = new Scanner(System.in);
		    	optionSistema = opcionElegida.nextInt();
            }
            catch (InputMismatchException e) 
            {
            	optionSistema = 0;
            	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
            }
		    
		    switch (optionSistema) {
		    	case 1:
		    		// Sistema socios
		    		aplicacionSocio.start();
		    		aplicacionSocio.IniciarTemporizador();
		    	break;
		    	case 2:
		    		// Sistema abonos
		    		aplicacionAbono.start();
		    	break;
		    	case 0: 
		    		System.out.println("Hasta la próximas");
		    	break;
		    		default:
		    			System.out.println("Lo sentimos la opcion deseada no esta todavía desarrollada.");
		    			System.out.println("Vuelva a contactar con los desarrolladores.");
		    } 
		}
	}

	
	private static void PrintMenu() {
		 System.out.println("Posibles Sistemas a Acceder");
		 System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
		 System.out.println("\t -> Introduzca 1 Si desea Acceder al Sistema de Socios");
		 System.out.println("\t -> Introduzca 2 Si desea Acceder al Sistema de Abonos");
	} 
}
