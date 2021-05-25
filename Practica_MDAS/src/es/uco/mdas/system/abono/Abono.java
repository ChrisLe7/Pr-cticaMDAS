package es.uco.mdas.system.abono;

import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;

public interface Abono {

	public DetallesAbono obtenerInformacionAbono(String idSocio);
	
	public boolean renovarAbono(String idAbono);
	
	public DetallesLocalidad cancelarAbono(String idAbono);
	
	public void modificarLocalidadAbono(String idAbono);
	
	public void actualizarCuotaAbono(String idAbono, float nuevoPrecio);
	
	public void registrarAbono(DetallesAbono abono);
}
