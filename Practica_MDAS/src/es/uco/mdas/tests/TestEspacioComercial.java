package es.uco.mdas.tests;

import java.text.ParseException;

import es.uco.mdas.business.instalaciondeportiva.DetallesEspacioComercial;
import es.uco.mdas.business.instalaciondeportiva.DetallesEstadio;
import es.uco.mdas.business.instalaciondeportiva.TipoEspacio;
import es.uco.mdas.datos.EspacioComercialDAO;
import es.uco.mdas.datos.EspacioComercialDAOImpFicheros;


public class TestEspacioComercial {
	public static void main(String[] args) throws ParseException {
		EspacioComercialDAO espacioComercialDAO = new EspacioComercialDAOImpFicheros ();
		//Faltan poner los tipos del enum
		DetallesEspacioComercial espacioComercialTest = new DetallesEspacioComercial("idEspacio", TipoEspacio.Tienda, "idLocalizacion", (float) 40, "idEmpresaArrendada");
		
		System.out.println("TestEspacioComercialDAO");
		
		assert espacioComercialDAO.insert(espacioComercialTest) : "Error al escribir el Espacio Comercial en el fichero";
		
		DetallesEspacioComercial queryRes = espacioComercialDAO.queryById(espacioComercialTest.getIdEspacio());
		
		assert queryRes != null : "Error en la lectura del Espacio Comercial del fichero";
				
		assert queryRes.equals(espacioComercialTest) : "Error comparando el Espacio Comercial";
		
		espacioComercialTest.setLocalizacion("idLocalizacionModificada");

		
		
		assert espacioComercialDAO.update(espacioComercialTest) : "Error al actualizar el Espacio Comercial ";
		
		queryRes = espacioComercialDAO.queryById(espacioComercialTest.getIdEspacio());
		
		assert queryRes.equals(espacioComercialTest) : "Error en la lectura del Espacio Comercial modificado del fichero";
		
		assert espacioComercialDAO.delete(espacioComercialTest.getIdEspacio()) : "Error al eliminar el Espacio Comercial del fichero";
		
		queryRes = espacioComercialDAO.queryById(espacioComercialTest.getIdEspacio());
		
		assert queryRes == null : "Error se ha encontrado un Espacio Comercial borrado";
		
		System.out.println("Exito");
	}
}
