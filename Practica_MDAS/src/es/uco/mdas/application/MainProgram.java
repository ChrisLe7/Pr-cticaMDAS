package es.uco.mdas.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {
	
	public static void main(String[] argv) {
		System.out.println("Buenas esta iniciando el Gestor de Socios y Abonados");
		int option = 0;
		Scanner opcionElegida ;
		while (option != 0) {
			
			PrintMenu();
			
		    try {
		    	opcionElegida = new Scanner(System.in);
                option = opcionElegida.nextInt();
            }
            catch (InputMismatchException e) 
            {
                option = 0;
            	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
            }
		    
		    
		}
	}

	private static void PrintMenu() {
		 System.out.println("Opciones Permitidas");
		 	System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
		 	System.out.println("\t -> Introduzca 1 Si desea Registra un nuevo Cliente");
	        System.out.println("\t -> Introduzca 2 Si desea Eliminar un Cliente");
	        System.out.println("\t -> Introduzca 3 Si desea Actualizar la Categoria de un Cliente");
	        System.out.println("\t -> Introduzca 4 Si desea Actualizar ");
	        System.out.println("\t -> Introduzca 5 Si desea Buscar un Contacto");
	        
		
	}
}
