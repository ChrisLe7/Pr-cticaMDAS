package es.uco.mdas.tests;

import java.util.HashMap;

import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.datos.SocioDAO;
import es.uco.mdas.datos.SocioDAOImpFicheros;

public class TestListarSocios {

	public static void main(String[] args) {
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		System.out.println("TestListarSocios");
		
		HashMap<String, DetallesSocio> socios = socioDAO.queryAll();
		
		System.out.println("Se han recuperado " + socios.size() + " socios");
		
		for (DetallesSocio socio : socios.values()) {
			System.out.println(socio.toString());
		}
		
		System.out.println("Exito");
		
	}
	
}
