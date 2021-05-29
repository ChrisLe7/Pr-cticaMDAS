package es.uco.mdas.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.datos.SocioDAO;
import es.uco.mdas.datos.SocioDAOImpFicheros;

public class TestSocioDAO {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		DetallesCliente cliente = new DetallesCliente("nombre", "apellidos", "direccion", "telefono", formato.parse("27-10-2000"));
		DetallesSocio socio = new DetallesSocio("1", cliente);
		
		System.out.println("TestSocioDAO");
		
		assert socioDAO.insert(socio) : "Error al escribir el socio en el fichero";
				
		DetallesSocio queryRes = socioDAO.queryById(socio.getIdSocio());
		
		assert queryRes != null : "Error en la lectura del socio del fichero";
		
		assert queryRes.equals(socio) : "Error comparando el socio";
		
		socio.setNombreSocio("nombreModificado");
		socio.setDireccion("direccionModificada");
		socio.setTelefonoContacto("telefonoModificado");
		
		assert socioDAO.update(socio) : "Error al actualizar el socio";
		
		queryRes = socioDAO.queryById(socio.getIdSocio());
		
		assert queryRes.equals(socio) : "Error en la lectura del socio modificado del fichero";
		
		assert socioDAO.delete(socio.getIdSocio()) : "Error al eliminar el socio del fichero";
		
		queryRes = socioDAO.queryById(socio.getIdSocio());
		
		assert queryRes == null : "Error se ha encontrado un socio borrado";
		
		System.out.println("Exito");
		
	}
	
}
