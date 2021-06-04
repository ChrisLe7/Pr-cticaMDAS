package es.uco.mdas.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.business.socio.TipoAbono;
import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.system.abono.impl.AbonoImpl;
import es.uco.mdas.system.localidad.Localidad;
import es.uco.mdas.system.localidad.imp.LocalidadImp;
import es.uco.mdas.system.socio.Socio;
import es.uco.mdas.system.socio.impl.SocioImpl;

public class Programa {
	/*Declaración de Variables*/
	private static Socio sistemaSocio = null;
	private static Abono sistemaAbono = null;
	private static Localidad sistemaLocalidad = null;
	private static Timer temporizador = null;
	private static Scanner opcionElegida;
	private static Scanner scannerSistema;
	public static void main(String[] argv) {
		System.out.println("Buenas esta iniciando el Gestor de Socios y Abonados");
		int optionSistema = 1;
		boolean iniciarTemp = true;
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
		    		
		    		startSistemaSocios();
		    		if (iniciarTemp) {
		    			IniciarTemporizador();
		    			iniciarTemp = !iniciarTemp;
		    		}
		    	break;
		    	case 2:
		    		
		    		startSistemaAbonos();
		    	break;
		    	case 0: 
		    		PararTemporizador();
		    		System.out.println("Hasta la próxima");
		    		opcionElegida.close();
		    		scannerSistema.close();
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
	
	/*----------Funcionalidades para el Sistema de Socios----------*/ 
	
	
	private static void PrintMenuSocios() {
		 System.out.println("Opciones Permitidas");
		 System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
		 System.out.println("\t -> Introduzca 1 Si desea Registra un nuevo Cliente");
	     System.out.println("\t -> Introduzca 2 Si desea Eliminar un Cliente");
	}
	
	public static void startSistemaSocios () {
		
		System.out.println("---------------------------");
		System.out.println("Sistema Socios");
		System.out.println("---------------------------");
		
		int opcionDeseada = 1;
		sistemaSocio = new SocioImpl (); 
		sistemaAbono = new AbonoImpl();
		while (opcionDeseada != 0) {
			
			PrintMenuSocios();
			
		    try {
		    	opcionElegida = new Scanner(System.in);
		    	opcionDeseada = opcionElegida.nextInt();
            }
            catch (InputMismatchException e) 
            {
            	opcionDeseada = 0;
            	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
            }
		    
		    switch(opcionDeseada) {
			    case 0:
		    		System.out.println("Cerrando el Sistema de Socios");
		    	break;
		    	case 1:
		    		DetallesCliente clienteNuevo = CrearCliente();
		    		
		    		DetallesSocio nuevoSocio = sistemaSocio.registrarDatosCliente(clienteNuevo);
		    		
		    		if (nuevoSocio != null) {
			    		System.out.println("El socio se ha registrado con exito");
			    		System.out.println("InfoSocio: " + nuevoSocio.toString());

		    		}
		    		break;
		    	case 2:
		    	
		    		String idsocioElegido  = ElegirSocio();
		    		if (sistemaSocio.eliminarDatosCliente(idsocioElegido)) {
		    			
		    			DetallesLocalidad localidadALiberar = sistemaAbono.cancelarAbono(idsocioElegido);
			    		if (localidadALiberar != null) {
			    			if (sistemaLocalidad.liberarLocalidad(localidadALiberar)) {
				    			System.out.println("Se ha cancelador el abono con exito y liberada su localidad");		    				
			    			}else {
			    				System.out.println("Ha ocurrido un error al liberar la localidad");
			    			}
			    			
			    		}else {
			    			System.out.println("Lo sentimos pero no existe ningún abono para ese socio");
			    		}
			    		
		    			System.out.println("El socio elegido se ha borrado con exito.");
		    		}
		    		
		    		else {
		    			
		    			System.out.println("El socio elegido no existe.");
		    		}
		    		
		    		break;
		    	default:
		    		System.out.println("Lo sentimos la opcion deseada no esta todavÃ­a desarrollada.");
	    			System.out.println("Vuelva a contactar con los desarrolladores.");
		    }
		}
	}

	private static DetallesCliente CrearCliente() {
		
		String nombreCliente, apellidosCliente, direccionCliente, telefonoContacto;
		Date edad = null;
		String fechaTexto = "";
		boolean checkFecha = false;
		scannerSistema = new Scanner(System.in);
		
		System.out.println("\t Introduzca el Nombre");
		
		nombreCliente = scannerSistema.nextLine();
		System.out.println("\t Introduzca el Primer Apellido");
		
		apellidosCliente = scannerSistema.nextLine();
		System.out.println("\t Introduzca el Segundo Apellido");
		
		apellidosCliente = apellidosCliente + ", " + scannerSistema.nextLine();
		
		System.out.println("\t Introduzca la Direccion");

		direccionCliente = scannerSistema.nextLine();
		do {
			System.out.println("\t Introduzca el Telefono");
			
			telefonoContacto = scannerSistema.nextLine();
		}while(!checkTelefono(telefonoContacto));
		
		do {
            System.out.println("\t Introduzca la fecha del socio (dd/mm/yyyy)");
            fechaTexto = scannerSistema.nextLine();

            try {
            	edad = new SimpleDateFormat("dd/MM/yyyy").parse(fechaTexto);
            	checkFecha = true;
            }
            catch (ParseException e) {
                System.out.println("Lo sentimos la fecha debe de seguir el formato : dd/MM/yyyy ");
                checkFecha = false;
            }

        } while (checkFecha == false);
		
		DetallesCliente nuevoCliente = new DetallesCliente (nombreCliente, apellidosCliente, direccionCliente, telefonoContacto, edad);
		
		
		return nuevoCliente;
	}

	private static boolean checkTelefono(String telefonoContacto) {
		Pattern pattern = Pattern.compile("[0-9]{9}");
	    return pattern.matcher(telefonoContacto).matches();
	}
	
	private static String ElegirSocio() {
		System.out.println("Introduzca el ID del Socio");
		String idSocio = null;
		scannerSistema = new Scanner(System.in);
		idSocio = scannerSistema.nextLine();
		
		return idSocio;
	}
	
	public static void IniciarTemporizador() {
		Calendar hoy = Calendar.getInstance();
		
		hoy.set(Calendar.HOUR_OF_DAY, 2);
		hoy.set(Calendar.MINUTE, 0);
		hoy.set(Calendar.SECOND, 0);

		temporizador = new Timer();
		TimerTask tarea = new TimerTask() {
			public void run() {
				
				sistemaSocio.comprobarTiempoVinculacion();
			}
		};
		
		
		temporizador.schedule(tarea, hoy.getTime(), 86400000);
	}
	
	public static void PararTemporizador() {
		if (temporizador == null) return;
		
		temporizador.cancel();
	}
	
	/*----------Funcionalidades para el Sistema de Abonos----------*/ 
	



	
	private static void PrintMenuAbonos()  {
	 	System.out.println("Opciones Permitidas");
	 	System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
        System.out.println("\t -> Introduzca 1 Si desea Obtener Informacion Abono ");
        System.out.println("\t -> Introduzca 2 Si desea Registrar Nuevo Abono para un Socio");	
	 	System.out.println("\t -> Introduzca 3 Si desea Renovar Abono de un Socio");
	 	System.out.println("\t -> Introduzca 4 Si desea Cancelar Abono de un Socio");
	 	System.out.println("\t -> Introduzca 5 Si desea Modificar Localidad de un Abono ");
	 	
	}
	
	public static void startSistemaAbonos () {
		System.out.println("---------------------------");
		System.out.println("Sistema Abonos");
		System.out.println("---------------------------");
		
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
		    		
		    		if (!sistemaAbono.registrarAbono(nuevoAbono)) {
		    			System.out.println("No se ha podido registrar el nuevo socio, debido a que ya posee uno");
		    		}else {
		    			
		    			DetallesLocalidad localidadAAsignar = new DetallesLocalidad(nuevoAbono.getIdLocalidad());
		    			
		    			if (sistemaLocalidad.asignarLocalidad(localidadAAsignar, nuevoAbono.getIdSocio())) {
		    				
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
	
	
	private static DetallesAbono RegistrarAbono() {
		String idSocio = null;
		String idAbono = "";
		DetallesSocio informacionSocioAAbonar = null;
		scannerSistema = new Scanner(System.in);
		while (informacionSocioAAbonar == null) {
			System.out.println("Introduzca el ID del Socio");
			
			idSocio = scannerSistema.nextLine();
			
			informacionSocioAAbonar = sistemaSocio.obtenerInformacionSocio(idSocio);
			if (informacionSocioAAbonar == null) {
				System.out.println("El id del Socio que ha introducido no existe");
			}
			
			}
		idAbono = idSocio + "a";
		
		DetallesAbono abonoARegistrar = new DetallesAbono(idSocio, idAbono);
		
		String idLocalidad = ElegirLocalidad();

		String tipoAbono = ElegirTipoAbono();
		
		abonoARegistrar.setIdLocalidad(idLocalidad);
		
		
		TipoAbono tipoAbonoSeleccionado = TipoAbono.valueOf(tipoAbono);
		abonoARegistrar.setTipoAbono(tipoAbono);
		abonoARegistrar.setPrecio(tipoAbonoSeleccionado.getValue());
		
		System.out.println("Instroduzca el deporte deseado");
		String deporteAsignado = scannerSistema.nextLine();
		abonoARegistrar.setDeporteAsignado(deporteAsignado);
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.DAY_OF_MONTH, 1);
		calendario.set(Calendar.MONTH, 5);
		calendario.set(Calendar.YEAR, calendario.get(Calendar.YEAR) + 1);
		
		abonoARegistrar.setFechaCancelacion(calendario.getTime());
		
		return abonoARegistrar;
	}

	private static String ElegirTipoAbono() {
		
		int TipoAbono = 0;
		scannerSistema = new Scanner(System.in);
		
			PrintMenuTipoAbonos();
		 try {
			 
			  TipoAbono = Integer.parseInt(scannerSistema.next());
         }
         catch (InputMismatchException e) 
         {
        	 TipoAbono = -1;
         	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
         }
		
		while(TipoAbono != 1 && TipoAbono != 2 && TipoAbono != 3 ) {
			
			PrintMenuTipoAbonos();
			
			try {
				TipoAbono = Integer.parseInt(scannerSistema.next());
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

	private static String ElegirLocalidad() {
		
		ArrayList <DetallesLocalidad> localidadesLibres = sistemaLocalidad.obtenerLocalidadesLibres();
		
		ArrayList <String> idLocalidadesLibres = new ArrayList <String>();
		
		for(DetallesLocalidad localidad : localidadesLibres) {
			
			idLocalidadesLibres.add(localidad.getIdLocalidad());
		}
		
		System.out.println("Introduzca la id del asiento a elegir entre los siguientes: ");
		System.out.println(idLocalidadesLibres);
		
		scannerSistema = new Scanner(System.in);
		String idAsiento = scannerSistema.next();
		
		while(!idLocalidadesLibres.contains(idAsiento)) {
			
			System.out.println("Introduzca una id de asiento valida a elegir entre los siguientes: ");
			System.out.println(idLocalidadesLibres);
			
			idAsiento = scannerSistema.next();
		}
		
		
		
		return idAsiento;
	}
	
	private static void showAbono(DetallesAbono abono) {
		System.out.println(abono.toString());
	}
	
	private static void PrintMenuTipoAbonos() {
		System.out.println("Introduzca el tipo de abono a elegir: ");
		System.out.println("\t -> Introduzca 1 para abono completo ");
		System.out.println("\t -> Introduzca 2 para abono de liga");
		System.out.println("\t -> Introduzca 3 para abono de copa");
	}
	
	
	
	
}
