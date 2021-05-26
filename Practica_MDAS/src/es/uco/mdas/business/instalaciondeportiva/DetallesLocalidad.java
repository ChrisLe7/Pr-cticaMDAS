package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;

public class DetallesLocalidad implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idLocalidad;
	private int fila;
	private int sector;
	private int zona;
	private String idInstalacionDeportiva;
	private String idSocio;
	
	/**
	 * Constructor completo de una localidad
	 * 
	 * @param idLocalidad Id de la localidad
	 * @param fila Fila de la localidad
	 * @param sector Sector de la localidad
	 * @param zona Zona de la localidad
	 * @param idInstalacionDeportiva Id de la instalacion deportiva a la que pertenece la localidad
	 * @param idSocio Id del socio asociado a la localidad
	 */
	public DetallesLocalidad(String idLocalidad, int fila, int sector, int zona, String idInstalacionDeportiva, String idSocio) {
		this.idLocalidad = idLocalidad;
		this.fila = fila;
		this.sector = sector;
		this.zona = zona;
		this.idInstalacionDeportiva = idInstalacionDeportiva;
		this.idSocio = idSocio;
	}

	/**
	 * Devuelve la id de la localidad
	 * 
	 * @return Id de la localidad
	 */
	public String getIdLocalidad() {
		return idLocalidad;
	}

	/**
	 * Asigna un id a la localidad
	 * 
	 * @param Id a asignar a la localidad
	 */
	public void setIdLocalidad(String idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	/**
	 * Devuelve la fila de la localidad
	 * 
	 * @return Fila de la localidad
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Asigna una fila a la localidad
	 * 
	 * @param fila Fila a asignar a la localidad
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}

	/**
	 * Devuelve el sector de la localidad
	 * 
	 * @return Sector de la localidad
	 */
	public int getSector() {
		return sector;
	}

	/**
	 * Asigna un sector a la localidad
	 * 
	 * @param sector Sector a asignar a la localidad
	 */
	public void setSector(int sector) {
		this.sector = sector;
	}

	/**
	 * Devuelve la zona de la localidad
	 * 
	 * @return Zona de la localidad
	 */
	public int getZona() {
		return zona;
	}

	/**
	 * Asigna una zona a la localidad
	 * 
	 * @param zona Zona a asignar a la localidad
	 */
	public void setZona(int zona) {
		this.zona = zona;
	}

	/**
	 * Devuelve la id de la instalacion deportiva a la que pertenece la localidad
	 * 
	 * @return Id de la instalacion deportiva a la que pertenece la localidad
	 */
	public String getIdInstalacionDeportiva() {
		return idInstalacionDeportiva;
	}

	/**
	 * Asigna una id de la instalacion deportiva a la que pertenece la localidad
	 * 
	 * @param idInstalacionDeportiva Id de la instalacion deportiva a asignar
	 */
	public void setIdInstalacionDeportiva(String idInstalacionDeportiva) {
		this.idInstalacionDeportiva = idInstalacionDeportiva;
	}

	/**
	 * Devuelve la id del socio asignado a la localidad
	 * 
	 * @return Id del socio asignado a la localidad
	 */
	public String getIdSocio() {
		return idSocio;
	}

	/**
	 * Asigna una id del socio asignado a la localidad
	 * 
	 * @param idSocio Id del socio a asignar
	 */
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}

}
