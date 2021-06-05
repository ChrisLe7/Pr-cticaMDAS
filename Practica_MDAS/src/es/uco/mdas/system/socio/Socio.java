package es.uco.mdas.system.socio;

import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;

public interface Socio {

	/**
	 * Registra los datos de un cliente
	 * 
	 * @param cliente Cliente a registrar
	 * @return Datos del socio registrado
	 */
	public DetallesSocio registrarDatosCliente(DetallesCliente cliente);
	
	/**
	 * Elimina los datos de un cliente
	 * 
	 * @param idSocio Id del socio a borrar
	 * @return True si se borra y false en caso contrario
	 */
	public boolean eliminarDatosCliente(String idSocio);
	
	/**
	 * Asigna una nueva categoria al socio
	 * 
	 * @param socio Socio cuya categoria se a modificar
	 * @param categoria Categoria nueva a asignar
	 */
	public void asignarCategoria(DetallesSocio socio, String categoria);
	
	/**
	 * Comprueba el tiempo de vinculacion de los socios
	 */
	public void comprobarTiempoVinculacion();
	
	/**
	 * Comprueba el tiempo de vinculacion de un socio para ver si hay que asignar una nueva categoria
	 * 
	 * @param socio Socio cuyo tiempo de vinculacion se va a comprobar
	 * @return Categoria asociada al tiempo de vinculacion
	 */
	public String comprobarTiempoVinculacion(DetallesSocio socio);
	
	/**
	 * Devuelve la informacion del socio
	 * 
	 * @param idSocio Id del socio a mostrar
	 * @return Socio a mostrar
	 */
	public DetallesSocio obtenerInformacionSocio(String idSocio);
	
}
