package es.uco.mdas.business.socio;

import java.util.HashMap;

import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.AbonoDAOImpFicheros;
import es.uco.mdas.datos.SocioDAO;
import es.uco.mdas.datos.SocioDAOImpFicheros;

public class SocioMgt {

	
	public DetallesAbono obtenerInformacionAbono(String idSocio) {
		DetallesAbono abonoSocio = null;
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		return abonoDAO.queryAbono(idSocio);
	}
	
	
	public boolean registrarAbono (DetallesAbono abono) {

		
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		return abonoDAO.insertAbono(abono);
		
	}
	
	
	public boolean renovarAbono (String idAbono ) {
		return true;
	}
	
	
	public boolean cancelarAbono(String idAbono) {
		return true;
	}
	
	public boolean actualizarAbono (DetallesAbono nuevoAbono) {
		return true;
	}
	public boolean registrarDatosCliente (DetallesCliente cliente) {
		String idSocio = "";
		DetallesSocio socio = new DetallesSocio(idSocio, cliente);
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		return socioDAO.insertSocio(socio);
	}
	
	public boolean eliminarDatosCliente (String idSocio ) {
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		return socioDAO.deleteSocio(idSocio);
	}  
	
	
	public boolean asignarCategoria (DetallesSocio socio, Categoria categoria) {
		
		socio.setCategoria(categoria);
		
		return this.updateSocio(socio);
		
	}

	
	public HashMap<String, DetallesSocio> getSocios () {
	
		// Crear una clase que devuelve el listado de socios ya sean leidos de una BD o de un fichero
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		HashMap<String, DetallesSocio> listadoSocios = socioDAO.querySocios();
		
		return listadoSocios;
	}
	
	
	public boolean updateSocio (DetallesSocio socio) {
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		return socioDAO.updateSocio(socio);
			
	}
	

}
