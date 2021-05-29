package es.uco.mdas.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.system.abono.impl.AbonoImpl;

public class AplicacionAbono {
	
	private static void PrintMenuAbonos()  {
	 	System.out.println("Opciones Permitidas");
	 	System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
        System.out.println("\t -> Introduzca 1 Si desea Obtener Informacion Abono ");
        System.out.println("\t -> Introduzca 2 Si desea Registrar Nuevo Abono para un Socio");	
	 	System.out.println("\t -> Introduzca 3 Si desea Renovar Abono de un Socio");
	 	System.out.println("\t -> Introduzca 4 Si desea Cancelar Abono de un Socio");
	 	System.out.println("\t -> Introduzca 5 Si desea Modificar Localidad de un Abono ");
	 	
	}
	
	public void start () {
		System.out.println("---------------------------");
		System.out.println("Sistema Abonos");
		System.out.println("---------------------------");
		
		Scanner opcionElegida ;
		int opcionDeseada = 1;
		Abono sistemaAbono = new AbonoImpl (); //No entiendo porque habeis hecho que este componente tengamos que pasarle una instancia del MGT
		while (opcionDeseada != 0) {
			
			PrintMenuAbonos();
			
			 try {
			    	opcionElegida = new Scanner(System.in);
			    	opcionDeseada = opcionElegida.nextInt();
	            }
	            catch (InputMismatchException e) 
	            {
	            	opcionDeseada = 0;
	            	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
	            }
			 
			switch (opcionDeseada) {
			 	case 0:
		    		System.out.println("Cerrando el Sistema de Socios");
		    	break;
		    	case 1:
		    		String idSocioABuscarAbono = ElegirSocio();
		    		DetallesAbono informacionAbonoBuscado = sistemaAbono.obtenerInformacionAbono(idSocioABuscarAbono);
		    		showAbono(informacionAbonoBuscado);
		    	break;
		    	case 2:
		    		DetallesAbono nuevoAbono = RegistrarAbono();
		    		if (!sistemaAbono.registrarAbono(nuevoAbono)) {
		    			System.out.println("No se ha podido registrar el nuevo socio, debido a que ya posee uno");
		    		}else {
		    			System.out.println("Se ha registrado con exito el nuevo Abono");
		    		}
		    	break;
		    	case 3:
		    		String idSocioABuscarAbono = ElegirSocio();
		    		if (sistemaAbono.renovarAbono(idAbono)) {
		    			System.out.println("Se ha renovado el abono con exito");
		    		}else {
		    			System.out.println("Lo sentimos pero no existe ningún abono para ese socio");
		    		}
		    	break;
		    	case 4:
		    		String idSocioABuscarAbono = ElegirSocio();
		    		if (sistemaAbono.cancelarAbono(idAbono)) {
		    			System.out.println("Se ha cancelador el abono con exito");
		    		}else {
		    			System.out.println("Lo sentimos pero no existe ningún abono para ese socio");
		    		}
		    	break;
		    	case 5:
		    		//No se puede implementar de forma completa
		    	break;
		    		
			}
		}
	}
	
	
	private String ElegirSocio() {
		System.out.println("Introduzca el ID del Socio");
		String idSocio = null;
		Scanner scannerEliminar = new Scanner(System.in);
		idSocio = scannerEliminar.nextLine();
		
		scannerEliminar.close();
		return idSocio;
	}
	
	private void showAbono(DetallesAbono abono) {
		System.out.println(abono.toString());
	}
	
	
	
	
}
