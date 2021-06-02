package es.uco.mdas.system.localidad;

import java.util.ArrayList;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;

public interface Localidad {
	
	public ArrayList<DetallesLocalidad> obtenerLocalidadesLibres();
	
	public boolean asignarLocalidad(DetallesLocalidad localidad, String idSocio);
	
	public boolean liberarLocalidad(DetallesLocalidad localidad);
	
}	
