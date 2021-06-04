package es.uco.mdas.tests;

import java.text.ParseException;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.data.LocalidadDAO;
import es.uco.mdas.business.instalaciondeportiva.data.LocalidadDAOImpFicheros;

public class TestLocalidadDAO {
	
	public static void main(String [] args) throws ParseException {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		DetallesLocalidad localidadTest = new DetallesLocalidad ("1", 1, 1, 1,"idInstalacion", "idSocio");
		
		System.out.println("TestLocalidadDAO");
		
		assert localidadDAO.insert(localidadTest) : "Error al insertar la localidad";
		
		DetallesLocalidad queryRes = localidadDAO.queryById(localidadTest.getIdLocalidad());
		
		assert queryRes != null : "Error en la queryById";
		
		assert queryRes.equals(localidadTest) : "Error comparando la Localidad";
		
		localidadTest.setIdSocio("idSocioModificada");
		localidadTest.setIdInstalacionDeportiva("IdInstalacionModificada");
		
		assert localidadDAO.update(localidadTest) : "Error al actualizar la Localidad";
		
		queryRes = localidadDAO.queryById(localidadTest.getIdLocalidad());
		
		assert queryRes.equals(localidadTest) : "Error comparando la Localidad Modificada";
		
		assert localidadDAO.delete(localidadTest.getIdLocalidad()) : "Erro al eliminar la localidad";
		
		queryRes = localidadDAO.queryById(localidadTest.getIdLocalidad());
		
		assert queryRes == null : "Error se ha encontrado una localidad borrada";
		
		System.out.println("Exito");
	}
}
