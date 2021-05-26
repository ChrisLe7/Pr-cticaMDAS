package es.uco.mdas.system.abono;

import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;

public interface Abono {

	/**
	 * Obtiene la información respectiva a un abono
	 * 
	 * @param idSocio ID del socio del abono
	 * @return Datos del abono
	 */	
	public DetallesAbono obtenerInformacionAbono(String idSocio);
	
	/**
	 * Renueva el abono de un socio
	 * 
	 * @param idAbono ID del abono
	 * @return True si se renueva y false en caso contrario
	 */	
	public boolean renovarAbono(String idAbono);
	
	
	/**
	 * Cancela el abono de un socio
	 * 
	 * @param idAbono ID del abono
	 * @return True si se cancela y false en caso contrario
	 */	
	public DetallesLocalidad cancelarAbono(String idAbono);
	
	
	/**
	 * Modifica la localidad asignada a un abono
	 * 
	 * @param idAbono ID del abono
	 */	
	public void modificarLocalidadAbono(String idAbono);
	
	
	/**
	 * Actualiza la cuota asociada a un abono
	 * 
	 * @param idAbono ID del abono
	 * @param nuevoPrecio Precio actualizado del abono
	 */	
	public void actualizarCuotaAbono(String idAbono, float nuevoPrecio);
	
	
	/**
	 * Registra un abono
	 * 
	 * @param abono Detalles necesarios para el registro del abono
	 */	
	public void registrarAbono(DetallesAbono abono);
}
