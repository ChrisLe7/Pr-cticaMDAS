package es.uco.mdas.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import es.uco.mdas.business.instalaciondeportiva.DetallesContrato;
import es.uco.mdas.business.instalaciondeportiva.data.ContratoDAO;
import es.uco.mdas.business.instalaciondeportiva.data.ContratoDAOImpFicheros;

public class TestContratoDAO {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat ("dd-MM-yyyy");
		
		ContratoDAO contratoDAO = new ContratoDAOImpFicheros ();
		DetallesContrato contratoTest = new DetallesContrato("idContrato", "idEmpresa", "idCuentaBancaria", "idEspacio",  formatoFecha.parse("27-10-2021"));
		System.out.println("TestContratoDAO");
		
		assert contratoDAO.insert(contratoTest) : "Error al insertar el contrato";
		
		DetallesContrato queryRes = contratoDAO.queryById(contratoTest.getIdContrato());
		
		assert queryRes != null : "Error en la queryById";
		
		assert queryRes.equals(contratoTest) : "Error comparando la Localidad";
		
		contratoTest.setIdEmpresa("idEmpresaModificada");
		contratoTest.setCuentaBancaria("IdCuentaBancariaModificada");
		
		assert contratoDAO.update(contratoTest) : "Error al actualizar la Localidad";
		
		queryRes = contratoDAO.queryById(contratoTest.getIdContrato());
		
		assert queryRes.equals(contratoTest) : "Error comparando la Localidad Modificada";
		
		assert contratoDAO.delete(contratoTest.getIdContrato()) : "Erro al eliminar la localidad";
		
		queryRes = contratoDAO.queryById(contratoTest.getIdContrato());
		
		assert queryRes == null : "Error se ha encontrado una localidad borrada";
		
		System.out.println("Exito");
	}
}
