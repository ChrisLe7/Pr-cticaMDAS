package es.uco.mdas.business.instalaciondeportiva;

import java.util.ArrayList;

import es.uco.mdas.business.socio.DetallesAbono;

public interface GestionarAbono {

	public ArrayList<DetallesLocalidad> getLocalidadesDisponibles();
	public void asignarLocalidad(DetallesLocalidad localidad, String idSocio);
	public void liberarLocalidad(DetallesLocalidad localidad);
	public boolean liberarAbono(String idAbono);
	public boolean registrarAbono(DetallesAbono abono);
	
}
