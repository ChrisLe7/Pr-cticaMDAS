package es.uco.mdas.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {
	
	public static void main(String[] argv) {
		System.out.println("Buenas esta iniciando el Gestor de Socios y Abonados");
		int optionSistema = 1;
		Scanner opcionElegida ;
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
		    		//Sistema Socios
		    	break;
		    	case 2:
		    		//Sistema Abonos
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

	private static void PrintMenuAbonos()  {
		 System.out.println("Opciones Permitidas");
		 	System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
	        System.out.println("\t -> Introduzca 1 Si desea Obtener Informacion Abono ");
	        System.out.println("\t -> Introduzca 2 Si desea Registrar Nuevo para un Socio");	
		 	System.out.println("\t -> Introduzca 3 Si desea Renovar Abono de un Socio");
		 	System.out.println("\t -> Introduzca 4 Si desea Cancelar Abono de un Socio");
		 	System.out.println("\t -> Introduzca 5 Si desea Modificar Localidad de un Abono ");
		 	
	}
	
	
	private static void PrintMenu() {
		 System.out.println("Posibles Sistemas a Acceder");
		 System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
		 System.out.println("\t -> Introduzca 1 Si desea Acceder al Sistema de Socios");
		 System.out.println("\t -> Introduzca 2 Si desea Acceder al Sistema de Abonos");
	}
}
