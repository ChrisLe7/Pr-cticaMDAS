package es.uco.mdas.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.business.socio.Categoria;
import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.system.socio.Socio;
import es.uco.mdas.system.socio.impl.SocioImpl;

public class AplicacionSocio {
	
	private void PrintMenuSocios() {
		 System.out.println("Opciones Permitidas");
		 	System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
		 	System.out.println("\t -> Introduzca 1 Si desea Registra un nuevo Cliente");
	        System.out.println("\t -> Introduzca 2 Si desea Eliminar un Cliente");
// Debería de ser automatica	        System.out.println("\t -> Introduzca 3 Si desea Actualizar la Categoria de un Cliente");
		
	}
	
	public void start () {
		
		System.out.println("---------------------------");
		System.out.println("Sistema Socios");
		System.out.println("---------------------------");
		
		Scanner opcionElegida ;
		int opcionDeseada = 1;
		Socio sistemaSocio = new SocioImpl (); //No entiendo porque habeis hecho que este componente tengamos que pasarle una instancia del MGT
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
		    		break;
		    	case 2:
		    	
		    		HashMap<String, DetallesSocio> listadoSocios ; 
		    		//=  sistemaSocio.listarSocios();
		    		
		    		MostrarSocios(listadoSocios);
		    		String idsocioElegido  = ElegirSocio();
		    		sistemaSocio.eliminarDatosCliente(idsocioElegido);
		    		
		    		break;
		    	case 3:
		    		
		    		//Modificar Categoria de forma automatica 
		    		
		    		break;
		    	default:
		    		System.out.println("Lo sentimos la opcion deseada no esta todavía desarrollada.");
	    			System.out.println("Vuelva a contactar con los desarrolladores.");
		    }
		}
	}

	private void MostrarSocios(HashMap<String, DetallesSocio> listadoSocios) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------");
		System.out.println("Listado de Socios Actualmente");
		
		for (String idSocio : listadoSocios.keySet()) {
			DetallesSocio socioAMostrar = listadoSocios.get(idSocio);
			System.out.println(socioAMostrar.toString());
		}
		System.out.println("---------------------------");
		
	}

	private DetallesCliente CrearCliente() {
		
		String nombreCliente, apellidosCliente, direccionCliente, telefonoContacto;
		Date edad = null;
		String fechaTexto = "";
		boolean checkFecha = false;
		Scanner scannerCliente = new Scanner(System.in);
		
		System.out.println("\t Introduzca el Nombre");
		
		nombreCliente = scannerCliente.nextLine();
		System.out.println("\t Introduzca el Primer Apellido");
		
		apellidosCliente = scannerCliente.nextLine();
		System.out.println("\t Introduzca el Segundo Apellido");
		
		apellidosCliente = apellidosCliente + ", " + scannerCliente.nextLine();
		
		System.out.println("\t Introduzca la Diccion");

		direccionCliente = scannerCliente.nextLine();
		do {
			System.out.println("\t Introduzca el Telefono");
			
			telefonoContacto = scannerCliente.nextLine();
		}while(!checkTelefono(telefonoContacto));
		
		do {
            System.out.println("\t Introduzca la fecha del contacto ");
            fechaTexto = scannerCliente.nextLine();

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
		scannerCliente.close();
		
		
		return nuevoCliente;
	}

	private boolean checkTelefono(String telefonoContacto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private String ElegirSocio() {
		System.out.println("Introduzca el ID del Socio");
		String idSocio = null;
		Scanner scannerEliminar = new Scanner(System.in);
		idSocio = scannerEliminar.nextLine();
		
		scannerEliminar.close();
		return idSocio;
	}
	
}
