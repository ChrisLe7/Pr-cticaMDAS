package es.uco.mdas.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.AbonoDAOImpFicheros;

public class TestAbonoDAO {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat ("dd-MM-yyyy");
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		DetallesAbono abonoTest = new DetallesAbono ("1", "2", "IdLocalidad", "tipoAbono", "deporte", (float) 10, formatoFecha.parse("27-10-2021"));
		
		System.out.println("TestAbonoDAO");
		
		assert abonoDAO.insert(abonoTest) : "Error al escribir el abono en el fichero";
		
		DetallesAbono queryRes = abonoDAO.queryById(abonoTest.getIdSocio());
		
		assert queryRes != null : "Error en la lectura del abono del fichero";
				
		assert queryRes.equals(abonoTest) : "Error comparando el abono";
		
		abonoTest.setIdLocalidad("IdLocalidadModificada");
		abonoTest.setTipoAbono("tipoAbonoModificada");
		abonoTest.setDeporteAsignado("deporteModificada");
		
		assert abonoDAO.update(abonoTest) : "Error al actualizar el abono";
		
		queryRes = abonoDAO.queryById(abonoTest.getIdSocio());
		
		assert queryRes.equals(abonoTest) : "Error en la lectura del abono modificado del fichero";
		
		assert abonoDAO.delete(abonoTest.getIdAbono()) : "Error al eliminar el abono del fichero";
		
		queryRes = abonoDAO.queryById(abonoTest.getIdSocio());
		
		assert queryRes == null : "Error se ha encontrado un abono borrado";
		
		System.out.println("Exito");
	}
	
}
