package es.uco.mdas.tests;

import java.text.ParseException;

import es.uco.mdas.business.instalaciondeportiva.DetallesDespacho;
import es.uco.mdas.business.instalaciondeportiva.TipoDespacho;
import es.uco.mdas.datos.DespachoDAO;
import es.uco.mdas.datos.DespachoDAOImpFicheros;

public class TestDespachoDAO {
	public static void main(String[] args) throws ParseException {
		DespachoDAO despachoDAO = new DespachoDAOImpFicheros();
		DetallesDespacho despachoTest = new DetallesDespacho ("idDespacho","idLocalizacion", TipoDespacho.Individual);
		
		System.out.println("TestDespachoDAO");
		
		assert despachoDAO.insert(despachoTest) : "Error al insertar el Despacho";
		
		DetallesDespacho queryRes = despachoDAO.queryById(despachoTest.getIdDespacho());
		assert queryRes != null : "Error en la queryById";
		
		assert queryRes.equals(despachoTest) : "Error comparando el Despacho";
	
		despachoTest.setIdMiembro("NuevoMiembro");
		despachoTest.setLocalizacion("NuevaLocalizacion");
		
		assert despachoDAO.update(despachoTest) : "Error al actualizar la Localidad";

		queryRes = despachoDAO.queryById(despachoTest.getIdDespacho());
	
		assert queryRes != null : "Error en la queryById";
		
		assert queryRes.equals(despachoTest) : "Error comparando el Despacho";
	
		assert despachoDAO.delete(despachoTest.getIdDespacho()) : "Erro al eliminar la localidad";
	
		queryRes = despachoDAO.queryById(despachoTest.getIdDespacho());
		
		assert queryRes == null : "Error se ha encontrado un Despacho borrado";
		
		System.out.println("Exito");
		
	}
	
}
