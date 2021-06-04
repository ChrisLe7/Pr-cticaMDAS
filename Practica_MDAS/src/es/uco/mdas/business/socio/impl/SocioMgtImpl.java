package es.uco.mdas.business.socio.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.business.socio.DetallesSocioInfantil;
import es.uco.mdas.business.socio.DetallesSocioAdulto;
import es.uco.mdas.business.socio.DetallesSocioOro;
import es.uco.mdas.business.socio.SocioMgt;
import es.uco.mdas.business.socio.data.AbonoDAO;
import es.uco.mdas.business.socio.data.SocioDAO;

public class SocioMgtImpl implements SocioMgt {
	
	private AbonoDAO abonoDAO;
	private SocioDAO socioDAO;
	public SocioMgtImpl(AbonoDAO abonoDAO, SocioDAO socioDAO) {
		this.abonoDAO = abonoDAO;
		this.socioDAO = socioDAO;		
	}
	
	public DetallesAbono obtenerInformacionAbono(String idSocio) {
		DetallesAbono abonoSocio = abonoDAO.queryById(idSocio);
		return abonoSocio;
	}
	
	public boolean registrarAbono (DetallesAbono abono) {		
		
		if (abonoDAO.queryById(abono.getIdSocio()) != null) {
			
			return false;
		}
		
		return abonoDAO.insert(abono);
	}
	
	public boolean renovarAbono(String idAbono ) {
		boolean estado = false;
		
		DetallesAbono abonoSocio = abonoDAO.queryById(idAbono);

		if (abonoSocio != null ) {
			
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
		DetallesAbono abonoSocio = obtenerInformacionAbono(idAbono);		
		
		if (abonoSocio != null ) {
			abonoDAO.delete(idAbono);
			estado = !estado;
			
		}
		
		return estado;
	}
	
	public boolean actualizarAbono(DetallesAbono nuevoAbono) {
		return abonoDAO.update(nuevoAbono);
	}
	
	public DetallesSocio registrarDatosCliente (DetallesCliente cliente) {
		Random generador = new Random();
		String idSocio = "" + generador.nextInt(10000);
		DetallesSocio socio = crearSocio(idSocio, cliente);
		if (socioDAO.insert(socio)) {
			return socio;
		}
		return null;
	}
	
	public boolean eliminarDatosCliente (String idSocio ) {
		return socioDAO.delete(idSocio);
	}
	
	public boolean asignarCategoria (DetallesSocio socio, String categoria) {
		socio.setCategoria(categoria);
		return this.updateSocio(socio);
		
	}
	
	public HashMap<String, DetallesSocio> getSocios() {
		HashMap<String, DetallesSocio> listadoSocios = socioDAO.queryAll();
		return listadoSocios;
	}
	
	public boolean updateSocio (DetallesSocio socio) {
		return socioDAO.update(socio);	
	}
	
	public DetallesSocio getSocio(String idSocio) {
		return socioDAO.queryById(idSocio);
	}
	
	private DetallesSocio crearSocio(String idSocio, DetallesCliente cliente) {
		int aniosSocioOro = 65; // edad minima requerida para ser socio de oro
        int aniosSocioAdulto = 18; // edad minima requerida para ser socio adulto
        
        if (cliente.getEdad() >= aniosSocioOro) {
        	return new DetallesSocioOro(idSocio, cliente);
        }
        else { 
	        if (cliente.getEdad() >= aniosSocioAdulto) {
	        	return new DetallesSocioAdulto(idSocio, cliente);
	        }	        
	        else {
	            return new DetallesSocioInfantil(idSocio, cliente);
	        }
        }
	}
	
}
