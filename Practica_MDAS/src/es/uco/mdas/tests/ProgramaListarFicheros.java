package es.uco.mdas.tests;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.data.LocalidadDAO;
import es.uco.mdas.business.instalaciondeportiva.data.LocalidadDAOImpFicheros;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.business.socio.data.AbonoDAO;
import es.uco.mdas.business.socio.data.AbonoDAOImpFicheros;
import es.uco.mdas.business.socio.data.SocioDAO;
import es.uco.mdas.business.socio.data.SocioDAOImpFicheros;

public class ProgramaListarFicheros {

	public static void listarSocios() {

		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		System.out.println("TestListarSocios");
		
		HashMap<String, DetallesSocio> socios = socioDAO.queryAll();
		
		System.out.println("Se han recuperado " + socios.size() + " socios");
		
		for (DetallesSocio socio : socios.values()) {
			System.out.println(socio.toString());
		}
		
	}
	
	public static void listarAbonos() {
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		System.out.println("TestListarAbonos");
		
		HashMap<String, DetallesAbono> abonos = abonoDAO.queryAll();
		
		System.out.println("Se han recuperado " + abonos.size() + " abonos");
		
		for (String abono : abonos.keySet()) {
			System.out.println(abonos.get(abono).toString());
		}
		
		
	}	
	
	public static void listarLocalidades() {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
			
		System.out.println("TestListarLocalidades");
			
		HashMap<String, DetallesLocalidad> localidades = localidadDAO.queryAll();
			
		System.out.println("Se han recuperado " + localidades.size() + " localidades");
			
		for (DetallesLocalidad localidad : localidades.values()) {
				System.out.println(localidad.toString());
			}
			
	}
	
	public static void crearLocalidades () {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		Random generador = new Random();
		
		for (int i = 0; i < 10; i++) {
			String idLocalidad = "" + generador.nextInt(1000);
			DetallesLocalidad localidad = new DetallesLocalidad(idLocalidad, 1, 1, 1, "idInstalacion", "");
			System.out.println(localidad.toString());
			localidadDAO.insert(localidad);
		}
		
	}

	public static void PrintMenu() {
		 System.out.println("Posibles Sistemas a Acceder");
		 System.out.println("\t -> Introduzca 0 Si desea Finalizar el Programa");
		 System.out.println("\t -> Introduzca 1 Si desea Listar los Socios");
		 System.out.println("\t -> Introduzca 2 Si desea Listar los Abonos");
		 System.out.println("\t -> Introduzca 3 Si desea Listar las Localidades");
		 System.out.println("\t -> Introduzca 4 Si desea Crear mas Localidades");
		 
	}
	public static void main(String[] args) {
		int opcionSistema = 1;
		Scanner opcionElegida = new Scanner (System.in);
		while (opcionSistema != 0) {
			
			PrintMenu();
			
		    try {
		    	opcionElegida = new Scanner(System.in);
		    	opcionSistema = opcionElegida.nextInt();
            }
            catch (InputMismatchException e) 
            {
            	opcionSistema = 0;
            	System.out.println("Lo sentimos pero en este menu solamente se permiten introducir numeros");
            }
		    switch(opcionSistema) {
		    case 0:
		    	System.out.println("Esperemos que estuviera todo de acuerdo con sus expectativas");
		    	break;
		    case 1:
		    	listarSocios();
		    	break;
		    case 2:
		    	listarAbonos();
		    case 3:
		     	listarLocalidades();
		    break;
		    case 4: 
		    	System.out.println("Se crearan las siguientes localidades");
		    	crearLocalidades();
		    break;
		  
		    }
		    
		    
		}
		opcionElegida.close();
	}

}
