package es.uco.mdas.business.socio.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import es.uco.mdas.business.socio.Categoria;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.business.socio.SocioMgt;
import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.AbonoDAOImpFicheros;
import es.uco.mdas.datos.SocioDAO;
import es.uco.mdas.datos.SocioDAOImpFicheros;

public class SocioMgtImpl implements SocioMgt {

	public DetallesAbono obtenerInformacionAbono(String idSocio) {
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		DetallesAbono abonoSocio = abonoDAO.queryById(idSocio);
		return abonoSocio;
	}
	
	public boolean registrarAbono (DetallesAbono abono) {		
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		return abonoDAO.insert(abono);
	}
	
	public boolean renovarAbono(String idAbono ) {
		boolean estado = false;
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		DetallesAbono abonoSocio = abonoDAO.queryById(idAbono);

		if (abonoSocio != null ) {
			//Actualiar fecha cancelación abonoSocio.setFecha (FechaACTUAL + 1 año) 
			Date fechaNuevaCancelacion = abonoSocio.getFechaCancelacion();
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(fechaNuevaCancelacion);
			calendario.add(Calendar.YEAR, 1);
			abonoSocio.setFechaCancelacion(calendario.getTime());
			abonoDAO.update(abonoSocio);
			estado = !estado;
		}
		
		return estado;
	}
	
	public boolean cancelarAbono(String idAbono) {
		boolean estado = false;
		Date today = new Date();
		
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		DetallesAbono abonoSocio = abonoDAO.queryById(idAbono);

		if (abonoSocio != null && abonoSocio.getFechaCancelacion().after(today)) {
			abonoSocio.setFechaCancelacion(new Date());
			abonoDAO.update(abonoSocio);
			estado = !estado;
			
		}
		
		return estado;
	}
	
	public boolean actualizarAbono(DetallesAbono nuevoAbono) {

		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		return abonoDAO.update(nuevoAbono);
	}
	
	public boolean registrarDatosCliente (DetallesCliente cliente) {
		String idSocio = "";
		DetallesSocio socio = new DetallesSocio(idSocio, cliente);
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		return socioDAO.insert(socio);
	}
	
	public boolean eliminarDatosCliente (String idSocio ) {
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		return socioDAO.delete(idSocio);
	}
	
	public boolean asignarCategoria (DetallesSocio socio, Categoria categoria) {
		
		socio.setCategoria(categoria);
		
		return this.updateSocio(socio);
		
	}
	
	public HashMap<String, DetallesSocio> getSocios () {
		
		// Crear una clase que devuelve el listado de socios ya sean leidos de una BD o de un fichero
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		HashMap<String, DetallesSocio> listadoSocios = socioDAO.queryAll();
		
		return listadoSocios;
	}
	
	public boolean updateSocio (DetallesSocio socio) {
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		return socioDAO.update(socio);
			
	}
	
}
