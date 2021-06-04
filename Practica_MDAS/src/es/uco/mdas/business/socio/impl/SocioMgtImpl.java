package es.uco.mdas.business.socio.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import es.uco.mdas.business.socio.Categoria;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.business.socio.SocioMgt;
import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.AbonoDAOImpFicheros;
import es.uco.mdas.datos.SocioDAO;
import es.uco.mdas.datos.SocioDAOImpFicheros;
import es.uco.mdas.system.abono.impl.AbonoImpl;

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
		
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		AbonoImpl abonoMGT = new AbonoImpl();

		DetallesAbono abonoSocio = abonoMGT.obtenerInformacionAbono(idAbono);		
		
		if (abonoSocio != null ) {
			abonoDAO.delete(idAbono);
			estado = !estado;
			
		}
		
		return estado;
	}
	
	public boolean actualizarAbono(DetallesAbono nuevoAbono) {

		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		return abonoDAO.update(nuevoAbono);
	}
	
	public DetallesSocio registrarDatosCliente (DetallesCliente cliente) {
		Random generador = new Random();
		String idSocio = "" + generador.nextInt(10000);
		DetallesSocio socio = new DetallesSocio(idSocio, cliente);
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		if (socioDAO.insert(socio)) {
			return socio;
		}
		return null;
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
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		HashMap<String, DetallesSocio> listadoSocios = socioDAO.queryAll();
		
		return listadoSocios;
	}
	
	public boolean updateSocio (DetallesSocio socio) {
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		
		return socioDAO.update(socio);
			
	}
	
	public DetallesSocio getSocio(String idSocio) {
		
		SocioDAO socioDAO = new SocioDAOImpFicheros();
		return socioDAO.queryById(idSocio);
	}
	
}
