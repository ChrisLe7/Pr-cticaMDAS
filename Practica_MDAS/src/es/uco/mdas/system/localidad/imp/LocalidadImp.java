package es.uco.mdas.system.localidad.imp;

import java.util.ArrayList;
import java.util.HashMap;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.datos.LocalidadDAO;
import es.uco.mdas.datos.LocalidadDAOImpFicheros;
import es.uco.mdas.system.localidad.Localidad;

public class LocalidadImp implements Localidad{

	@Override
	public ArrayList<DetallesLocalidad> obtenerLocalidadesLibres() {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		HashMap <String, DetallesLocalidad> listadoTodasLasLocalidades = localidadDAO.queryAll();
		ArrayList<DetallesLocalidad> localidadesLibres = new ArrayList<>();
		for (String idLocalidad : listadoTodasLasLocalidades.keySet()) {
			DetallesLocalidad registroLocalidad = listadoTodasLasLocalidades.get(idLocalidad);
			if (registroLocalidad.getIdSocio().equals("")) {
				localidadesLibres.add(registroLocalidad);
			}
		}
	
		return localidadesLibres;
	}

	@Override
	public boolean asignarLocalidad(DetallesLocalidad localidad, String idSocio) {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		DetallesLocalidad registroLocalidad = localidadDAO.queryById(localidad.getIdLocalidad());
		
		if (registroLocalidad.getIdSocio().equals("")) {
			registroLocalidad.setIdSocio(idSocio);
			localidadDAO.update(registroLocalidad);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean liberarLocalidad(DetallesLocalidad localidad) {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		System.out.println(localidad.toString());
		
		DetallesLocalidad registroLocalidad = localidadDAO.queryById(localidad.getIdLocalidad());
		
		System.out.println(registroLocalidad.toString());
		
		if (!registroLocalidad.getIdSocio().equals("")) {
			registroLocalidad.setIdSocio("");
			localidadDAO.update(registroLocalidad);
			return true;
		}
		
		return false;
	}

}
