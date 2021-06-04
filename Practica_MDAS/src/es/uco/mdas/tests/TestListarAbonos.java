package es.uco.mdas.tests;

import java.util.HashMap;

import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.socio.data.AbonoDAO;
import es.uco.mdas.business.socio.data.AbonoDAOImpFicheros;

public class TestListarAbonos {

public static void main(String[] args) {
		
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		System.out.println("TestListarAbonos");
		
		HashMap<String, DetallesAbono> abonos = abonoDAO.queryAll();
		
		System.out.println("Se han recuperado " + abonos.size() + " abonos");
		
		for (String abono : abonos.keySet()) {
			System.out.println(abonos.get(abono).toString());
		}
		
		System.out.println("Exito");
		
	}
	
}
