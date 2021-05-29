package es.uco.mdas.tests;

import java.text.ParseException;

import es.uco.mdas.business.instalaciondeportiva.DetallesEstadio;
import es.uco.mdas.datos.EstadioDAO;
import es.uco.mdas.datos.EstadioDAOImpFicheros;

public class TestEstadioDAO {
	public static void main(String[] args) throws ParseException {
		EstadioDAO estadioDAO = new EstadioDAOImpFicheros ();
		DetallesEstadio estadioTest = new DetallesEstadio("idEstadio", "idLocalizacion", 50, (float) 40 , (float) 40);
		
		System.out.println("TestEstadioDAO");
		
		assert estadioDAO.insert(estadioTest) : "Error al escribir el Estadio en el fichero";
		
		DetallesEstadio queryRes = estadioDAO.queryById(estadioTest.getIdEstadio());
		
		assert queryRes != null : "Error en la lectura del Estadio del fichero";
				
		assert queryRes.equals(estadioTest) : "Error comparando el Estadio";
		
		estadioTest.setLocalizacion("idLocalizacionModificada");
		estadioTest.setAforo(70);
		
		
		assert estadioDAO.update(estadioTest) : "Error al actualizar el Estadio";
		
		queryRes = estadioDAO.queryById(estadioTest.getIdEstadio());
		
		assert queryRes.equals(estadioTest) : "Error en la lectura del Estadio modificado del fichero";
		
		assert estadioDAO.delete(estadioTest.getIdEstadio()) : "Error al eliminar el Estadio del fichero";
		
		queryRes = estadioDAO.queryById(estadioTest.getIdEstadio());
		
		assert queryRes == null : "Error se ha encontrado un Estadio borrado";
		
		System.out.println("Exito");
	}
}	
