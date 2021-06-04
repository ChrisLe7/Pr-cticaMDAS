package es.uco.mdas.tests;

import java.text.ParseException;

import es.uco.mdas.business.instalaciondeportiva.DetallesPresupuesto;
import es.uco.mdas.business.instalaciondeportiva.data.PresupuestoDAO;
import es.uco.mdas.business.instalaciondeportiva.data.PresupuestoDAOImpFicheros;

public class TestPresupuesto {
	public static void main(String[] args) throws ParseException {
		PresupuestoDAO presupuestoDAO = new PresupuestoDAOImpFicheros ();
		//Faltan poner los tipos del enum
		DetallesPresupuesto presupuestoTest = new DetallesPresupuesto("idPresupuesto", "idEspacio" ,(float) 40);
		
		System.out.println("TestPresupuestoDAO");
		
		assert presupuestoDAO.insert(presupuestoTest) : "Error al escribir el Presupuesto en el fichero";
		
		DetallesPresupuesto queryRes = presupuestoDAO.queryById(presupuestoTest.getIdPresupuesto());
		
		assert queryRes != null : "Error en la lectura del Presupuesto del fichero";
				
		assert queryRes.equals(presupuestoTest) : "Error comparando el Presupuesto";
		
		presupuestoTest.setIdEspacio("idEspacioModificada");
		presupuestoTest.setPrecio((float) 55);

				
		assert presupuestoDAO.update(presupuestoTest) : "Error al actualizar el Presupuesto ";
		
		queryRes = presupuestoDAO.queryById(presupuestoTest.getIdPresupuesto());
		
		assert queryRes.equals(presupuestoTest) : "Error en la lectura del Presupuesto modificado del fichero";
		
		assert presupuestoDAO.delete(presupuestoTest.getIdPresupuesto()) : "Error al eliminar el Presupuesto del fichero";
		
		queryRes = presupuestoDAO.queryById(presupuestoTest.getIdPresupuesto());
		
		assert queryRes == null : "Error se ha encontrado un Presupuesto borrado";
		
		System.out.println("Exito");
	}
}
