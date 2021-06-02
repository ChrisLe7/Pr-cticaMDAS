package es.uco.mdas.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.system.abono.impl.AbonoImpl;
import es.uco.mdas.system.localidad.Localidad;
import es.uco.mdas.system.localidad.imp.LocalidadImp;



public class AplicacionAbono {
	
	private Abono sistemaAbono = null;
	private Localidad sistemaLocalidad = null;
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
		sistemaAbono = new AbonoImpl (); //No entiendo porque habeis hecho que este componente tengamos que pasarle una instancia del MGT
		sistemaLocalidad = new LocalidadImp ();
		String idSocioABuscarAbono = null;
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
		    		idSocioABuscarAbono = ElegirSocio();
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
		    		String idSocioAbonado = ElegirSocio();
		    		if (sistemaAbono.renovarAbono(idSocioAbonado)) {
		    			System.out.println("Se ha renovado el abono con exito");
		    		}else {
		    			System.out.println("Lo sentimos pero no existe ningún abono para ese socio");
		    		}
		    	break;
		    	case 4:
		    		idSocioABuscarAbono = ElegirSocio();
		    		DetallesLocalidad localidadALiberar = sistemaAbono.cancelarAbono(idSocioABuscarAbono);
		    		if (localidadALiberar != null) {
		    			if (sistemaLocalidad.liberarLocalidad(localidadALiberar)) {
			    			System.out.println("Se ha cancelador el abono con exito");		    				
		    			}else {
		    				System.out.println("Ha ocurrido un error al liberar la localidad");
		    			}
		    			
		    		}else {
		    			System.out.println("Lo sentimos pero no existe ningún abono para ese socio");
		    		}
		    	break;
		    	case 5:
		    		idSocioABuscarAbono = ElegirSocio();
		    		String idLocalidadEscogida = ElegirLocalidad();
		    		if (sistemaAbono.modificarLocalidadAbono(idLocalidadEscogida,idLocalidadEscogida)) {
		    			System.out.println("Se ha modificado la localidad del abono con exito");
		    		}else {
		    			System.out.println("Lo sentimos pero no existe ningún abono para ese socio");
		    		}
		    	break;
		    		
			}
		}
	}
	
	
	private DetallesAbono RegistrarAbono() {
		String idSocio = null;
		String idAbono = ""; //Hay que hacer alguna función para generar las IDS.
		System.out.println("Introduzca el ID del Socio");
		Scanner scannerRegistrar = new Scanner(System.in);
		idSocio = scannerRegistrar.nextLine();
		DetallesAbono abonoARegistrar = new DetallesAbono(idSocio, idAbono);
		
		String idLocalidad = ElegirLocalidad();

		String tipoAbono = ElegirTipoAbono();
		abonoARegistrar.setIdLocalidad(idLocalidad);
		abonoARegistrar.setTipoAbono(tipoAbono);
		
		String deporteAsignado = scannerRegistrar.nextLine();
		abonoARegistrar.setDeporteAsignado(deporteAsignado);
		return abonoARegistrar;
	}

	private String ElegirTipoAbono() {
		// TODO Auto-generated method stub
		return null;
	}

	private String ElegirLocalidad() {
		// TODO Auto-generated method stub
		return null;
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
