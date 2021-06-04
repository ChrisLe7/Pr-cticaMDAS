package es.uco.mdas.system.localidad.imp;

import java.util.ArrayList;
import java.util.HashMap;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.GestionarAbono;
import es.uco.mdas.business.instalaciondeportiva.impl.InstalacionDeportivaImpl;
import es.uco.mdas.business.socio.SocioMgt;
import es.uco.mdas.business.socio.impl.SocioMgtImpl;
import es.uco.mdas.datos.AbonoDAOImpFicheros;
import es.uco.mdas.datos.LocalidadDAO;
import es.uco.mdas.datos.LocalidadDAOImpFicheros;
import es.uco.mdas.datos.SocioDAOImpFicheros;
import es.uco.mdas.system.abono.impl.AbonoImpl;
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
