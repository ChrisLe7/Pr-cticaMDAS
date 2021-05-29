package es.uco.mdas.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import es.uco.mdas.business.instalaciondeportiva.DetallesEntrada;
import es.uco.mdas.datos.EntradaDAO;
import es.uco.mdas.datos.EntradaDAOImpFicheros;

public class TestEntradaDAO {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat ("dd-MM-yyyy");
		EntradaDAO entradaDAO = new EntradaDAOImpFicheros ();
		DetallesEntrada entradaTest = new DetallesEntrada ("idLocalizacion", formatoFecha.parse("27-10-2021") ,"Asiento", (float) 10);
		
		System.out.println("TestEntradaDAO");
		
		
	}
}
