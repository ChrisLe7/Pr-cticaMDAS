package es.uco.mdas.system.localidad.imp;

import java.util.ArrayList;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.GestionarAbono;
import es.uco.mdas.business.instalaciondeportiva.data.LocalidadDAOImpFicheros;
import es.uco.mdas.business.instalaciondeportiva.impl.InstalacionDeportivaImpl;
import es.uco.mdas.system.localidad.Localidad;

public class LocalidadImp implements Localidad{

	private GestionarAbono localidadMgt;
	
	public LocalidadImp() {
		
		this.localidadMgt = new InstalacionDeportivaImpl(new LocalidadDAOImpFicheros());
	}
	
	
	@Override
	public ArrayList<DetallesLocalidad> obtenerLocalidadesLibres() {
			
		ArrayList<DetallesLocalidad> localidadesLibres = localidadMgt.getLocalidadesDisponibles();
		
		return localidadesLibres;
	}

	@Override
	public boolean asignarLocalidad(DetallesLocalidad localidad, String idSocio) {
		
		return localidadMgt.asignarLocalidad(localidad, idSocio);
	}

	@Override
	public boolean liberarLocalidad(DetallesLocalidad localidad) {
		
		return localidadMgt.liberarLocalidad(localidad);
	}

}
