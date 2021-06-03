package es.uco.mdas.tests;

import java.util.HashMap;

import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.AbonoDAOImpFicheros;

public class TestListarAbonos {

public static void main(String[] args) {
		
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		System.out.println("TestListarAbonos");
		
		HashMap<String, DetallesAbono> abonos = abonoDAO.queryAll();
		
		System.out.println("Se han recuperado " + abonos.size() + " abonos");
		
		for (DetallesAbono abono : abonos.values()) {
			System.out.println(abono.toString());
		}
		
		System.out.println("Exito");
		
	}
	
}
