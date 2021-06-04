package es.uco.mdas.tests;

import java.util.HashMap;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.data.LocalidadDAO;
import es.uco.mdas.business.instalaciondeportiva.data.LocalidadDAOImpFicheros;

public class TestListarLocalidades {

public static void main(String[] args) {
		
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		System.out.println("TestListarLocalidades");
		
		HashMap<String, DetallesLocalidad> localidades = localidadDAO.queryAll();
		
		System.out.println("Se han recuperado " + localidades.size() + " localidades");
		
		for (DetallesLocalidad localidad : localidades.values()) {
			System.out.println(localidad.toString());
		}
		
		System.out.println("Exito");
		
	}
	
}
