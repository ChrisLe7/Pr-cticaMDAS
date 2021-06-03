package es.uco.mdas.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.business.socio.TipoAbono;
import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.system.abono.impl.AbonoImpl;
import es.uco.mdas.system.localidad.Localidad;
import es.uco.mdas.system.localidad.imp.LocalidadImp;
import es.uco.mdas.system.socio.Socio;
import es.uco.mdas.system.socio.impl.SocioImpl;



public class AplicacionAbono {
	
	private Abono sistemaAbono = null;
	private Localidad sistemaLocalidad = null;
	private Socio sistemaSocio = null;
	
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
		sistemaAbono = new AbonoImpl (); 
		sistemaLocalidad = new LocalidadImp ();
		sistemaSocio = new SocioImpl ();
		String idSocioABuscarAbono = null;
		while (opcionDeseada != 0) {
			
			PrintMenuAbonos();
			
			 try {
			    	opcionElegida = new Scanner(System.in);
			    	opcionDeseada = opcionElegida.nextInt();
	            }
	            catch (InputMismatchException e) 
	            {
	            	opcionDeseada = -1;
	            	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
	            }
			 
			switch (opcionDeseada) {
			 	case 0:
		    		System.out.println("Cerrando el Sistema de Socios");
		    	break;
		    	case 1:
		    		idSocioABuscarAbono = ElegirSocio();
		    		DetallesAbono informacionAbonoBuscado = sistemaAbono.obtenerInformacionAbono(idSocioABuscarAbono);
		    		if (informacionAbonoBuscado != null) {
			    		showAbono(informacionAbonoBuscado);
		    		}
		    		else {
		    			System.out.println("El Socio al que busca no tiene abono");
		    		}
		    	break;
		    	case 2:
		    		DetallesAbono nuevoAbono = RegistrarAbono();
		    		System.out.println(nuevoAbono.getIdSocio());
		    		System.out.println(nuevoAbono.getIdAbono());
		    		
		    		if (!sistemaAbono.registrarAbono(nuevoAbono)) {
		    			System.out.println("No se ha podido registrar el nuevo socio, debido a que ya posee uno");
		    		}else {
		    			
		    			DetallesLocalidad localidadAAsignar = new DetallesLocalidad(nuevoAbono.getIdLocalidad());
		    			
		    			if (sistemaLocalidad.asignarLocalidad(localidadAAsignar, nuevoAbono.getIdAbono())) {
		    				
		    				System.out.println("Se ha registrado con exito el nuevo Abono");
		    			}
		    			
		    			else{
		    				
		    				System.out.println("Error al registrar el nuevo Abono debido a que la localidad asignada no esta disponible");
		    			}
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
		    		if (sistemaAbono.modificarLocalidadAbono(idSocioABuscarAbono,idLocalidadEscogida)) {
		    			System.out.println("Se ha modificado la localidad del abono con exito");
		    		}else {
		    			System.out.println("Lo sentimos pero no existe ningún abono para ese socio");
		    		}
		    	break;
		    	
		    	default:
		    		
		    		System.out.println("Para más funcionalidades ponganse en contacto con los administradores. :)");
			}
		}
	}
	
	
	private DetallesAbono RegistrarAbono() {
		String idSocio = null;
		String idAbono = "";
		DetallesSocio informacionSocioAAbonar = null;
		Scanner scannerRegistrar = new Scanner(System.in);
		while (informacionSocioAAbonar == null) {
			System.out.println("Introduzca el ID del Socio");
			
			idSocio = scannerRegistrar.nextLine();
			
			informacionSocioAAbonar = sistemaSocio.obtenerInformacionSocio(idSocio);
			if (informacionSocioAAbonar == null) {
				System.out.println("El id del Socio que ha introducido no existe");
			}
			
			}
		idAbono = idSocio;
		
		DetallesAbono abonoARegistrar = new DetallesAbono(idSocio, idAbono);
		
		String idLocalidad = ElegirLocalidad();

		String tipoAbono = ElegirTipoAbono();
		
		abonoARegistrar.setIdLocalidad(idLocalidad);
		
		
		TipoAbono tipoAbonoSeleccionado = TipoAbono.valueOf(tipoAbono);
		abonoARegistrar.setTipoAbono(tipoAbono);
		abonoARegistrar.setPrecio(tipoAbonoSeleccionado.getValue());
		
		System.out.println("Instroduzca el deporte deseado");
		String deporteAsignado = scannerRegistrar.nextLine();
		abonoARegistrar.setDeporteAsignado(deporteAsignado);
		return abonoARegistrar;
	}

	private String ElegirTipoAbono() {
		
		int TipoAbono = 0;
		Scanner scannerRegistrar = new Scanner(System.in);
		
			PrintMenuTipoAbonos();
		 try {
			 
			  TipoAbono = Integer.parseInt(scannerRegistrar.next());
         }
         catch (InputMismatchException e) 
         {
        	 TipoAbono = -1;
         	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
         }
		
		while(TipoAbono != 1 && TipoAbono != 2 && TipoAbono != 3 ) {
			
			PrintMenuTipoAbonos();
			
			try {
				TipoAbono = Integer.parseInt(scannerRegistrar.next());
            }
            catch (InputMismatchException e) 
            {
            	TipoAbono = -1;
            	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
            }
		}
		
		if(TipoAbono == 1) {
			
			return "AbonoCompleto";
		}
		
		else if (TipoAbono == 2){
			
			return "AbonoLiga";
		}
		
		else {
			
			return "AbonoCopa";
		}
	}

	private String ElegirLocalidad() {
		
		ArrayList <DetallesLocalidad> localidadesLibres = sistemaLocalidad.obtenerLocalidadesLibres();
		
		ArrayList <String> idLocalidadesLibres = new ArrayList <String>();
		
		for(DetallesLocalidad localidad : localidadesLibres) {
			
			idLocalidadesLibres.add(localidad.getIdLocalidad());
		}
		
		System.out.println("Introduzca la id del asiento a elegir entre los siguientes: ");
		System.out.println(idLocalidadesLibres);
		
		Scanner scannerRegistrar = new Scanner(System.in);
		String idAsiento = scannerRegistrar.next();
		
		while(!idLocalidadesLibres.contains(idAsiento)) {
			
			System.out.println("Introduzca una id de asiento valida a elegir entre los siguientes: ");
			System.out.println(idLocalidadesLibres);
			
			idAsiento = scannerRegistrar.next();
		}
		
		
		
		return idAsiento;
	}

	private String ElegirSocio() {
		System.out.println("Introduzca el ID del Socio");
		String idSocio = null;
		Scanner scannerEliminar = new Scanner(System.in);
		idSocio = scannerEliminar.nextLine();

		return idSocio;
	}
	
	private void showAbono(DetallesAbono abono) {
		System.out.println(abono.toString());
	}
	
	private void PrintMenuTipoAbonos() {
		System.out.println("Introduzca el tipo de abono a elegir: ");
		System.out.println("\t -> Introduzca 1 para abono completo ");
		System.out.println("\t -> Introduzca 2 para abono de liga");
		System.out.println("\t -> Introduzca 3 para abono de copa");
	}
	
	
	
}
