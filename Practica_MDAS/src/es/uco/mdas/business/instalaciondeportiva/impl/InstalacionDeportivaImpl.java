package es.uco.mdas.business.instalaciondeportiva.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.GestionarAbono;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.LocalidadDAO;

public class InstalacionDeportivaImpl implements GestionarAbono {

	@Override
	public ArrayList<DetallesLocalidad> getLocalidadesDisponibles() {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		

		HashMap<String, DetallesLocalidad> listadoLocalidades = localidadDAO.queryAll();
		Collection<DetallesLocalidad> localidades = listadoLocalidades.values();
		
		ArrayList<DetallesLocalidad> localidadesDisponibles = new ArrayList<> (localidades);
		
		return localidadesDisponibles;
	}

	@Override
	public void asignarLocalidad(DetallesLocalidad localidad, String idSocio) {
		localidad.setIdSocio(idSocio);
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		localidadDAO.update(localidad);
		
		
	}

	@Override
	public void liberarLocalidad(DetallesLocalidad localidad) {
		localidad.setIdSocio("");
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		localidadDAO.update(localidad);
		
	}

	@Override
	public boolean liberarAbono(String idAbono) {
		// TODO Auto-generated method stub
		boolean estado = false;
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		DetallesAbono informacionAbono = abonoDAO.queryAbono(idAbono);
		
		String idLocalidad = informacionAbono.getIdLocalidad();
		
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		DetallesLocalidad informacionLocalidad = localidadDAO.queryById(idLocalidad);
		
		if (informacionLocalidad != null) {
			this.liberarLocalidad(informacionLocalidad);
			estado = !estado;
		}
		
		return estado;
	}

	@Override
	public boolean registrarAbono(DetallesAbono abono) {
		// TODO Auto-generated method stub
		boolean estado = false;
	
		String idLocalidad = abono.getIdLocalidad();
		
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		DetallesLocalidad informacionLocalidad = localidadDAO.queryById(idLocalidad);
		
		if (informacionLocalidad.getIdSocio() == "" ) {
			informacionLocalidad.setIdSocio(abono.getIdAbono());
			estado = !estado;
		}
		
		return estado;
	}

}
