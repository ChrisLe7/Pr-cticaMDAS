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
		DetallesEntrada entradaTest = new DetallesEntrada ("idEntrada","idLocalizacion", formatoFecha.parse("27-10-2021") ,"Asiento", (float) 10);
		
		System.out.println("TestEntradaDAO");
		
		assert entradaDAO.insert(entradaTest) : "Error al escribir el Espacio Comercial en el fichero";
		
		DetallesEntrada queryRes = entradaDAO.queryById(entradaTest.getIdEntrada());
		
		assert queryRes != null : "Error en la lectura del Espacio Comercial del fichero";
				
		assert queryRes.equals(entradaTest) : "Error comparando el Espacio Comercial";
		
		entradaTest.setLocalizacion("idLocalizacionModificada");

		
		
		assert entradaDAO.update(entradaTest) : "Error al actualizar el Espacio Comercial ";
		
		queryRes = entradaDAO.queryById(entradaTest.getIdEntrada());
		
		assert queryRes.equals(entradaTest) : "Error en la lectura del Espacio Comercial modificado del fichero";
		
		assert entradaDAO.delete(entradaTest.getIdEntrada()) : "Error al eliminar el Espacio Comercial del fichero";
		
		queryRes = entradaDAO.queryById(entradaTest.getIdEntrada());
		
		assert queryRes == null : "Error se ha encontrado un Espacio Comercial borrado";
		
		System.out.println("Exito");	
	}
}
