package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.util.Calendar;

public class DetallesAbono implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idSocio;
	private String idAbono;
	
	private String idLocalidad;
	
	private String tipoAbono; //Podria hacerse una ENUM pero no lo hemos dicho en ningún lado
	
	private String deporteAsignado ; 
	
	private float precio;

	private Calendar fechaCancelacion; 
	
	/**
	 * Constructor completo de un Abonado
	 * @param idSocio
	 * @param idAbono
	 * @param idLocalidad
	 * @param tipoAbono
	 * @param deporteAsignado
	 * @param precio
	 * */
	
	public DetallesAbono(String idSocio, String idAbono, String idLocalidad, String tipoAbono, String deporteAsignado,
			float precio, Calendar fechaCancelacion) {
		super();
		this.idSocio = idSocio;
		this.idAbono = idAbono;
		this.idLocalidad = idLocalidad;
		this.tipoAbono = tipoAbono;
		this.deporteAsignado = deporteAsignado;
		this.precio = precio;
		this.fechaCancelacion = fechaCancelacion;
	}
	
	/**
	 * Constructor por defecto de un Abono, solo obligará al id del Socio y del Abono
	 * @param idSocio 
	 * @param idAbono 
	 * */

	public DetallesAbono(String idSocio, String idAbono) {
		this(idSocio, idAbono, "", "", "", 0, null);
	}


	/**
	 * Devuelve el Identificador del Socio
	 * 	@return ID del Socio
	 * */
	
	public String getIdSocio() {
		return idSocio;
	}
	/**
	 * Asigna una id al socio
	 * 
	 * @param idSocio Id a asignar al socio
	 */
	
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}

	/**
	 * Devuelve el Identificador del Abono
	 * 	@return ID del Abono
	 * */
	
	public String getIdAbono() {
		return idAbono;
	}
	
	/**
	 * Asigna una id al Abono
	 * 
	 * @param idAbono Id a asignar al Abono
	 */

	public void setIdAbono(String idAbono) {
		this.idAbono = idAbono;
	}
	
	/**
	 * Devuelve el ID de la localidad asignada
	 * @return idLocalidad asignada al abono
	 * */
	public String getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(String idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getTipoAbono() {
		return tipoAbono;
	}

	public void setTipoAbono(String tipoAbono) {
		this.tipoAbono = tipoAbono;
	}

	public String getDeporteAsignado() {
		return deporteAsignado;
	}

	public void setDeporteAsignado(String deporteAsignado) {
		this.deporteAsignado = deporteAsignado;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Calendar getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Calendar fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	
	
	
}
