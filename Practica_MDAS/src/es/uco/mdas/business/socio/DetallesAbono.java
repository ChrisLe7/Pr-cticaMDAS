package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.util.Date;

public class DetallesAbono implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idSocio;
	private String idAbono;
	
	private String idLocalidad;
	
	private String tipoAbono; //Podria hacerse una ENUM pero no lo hemos dicho en ningún lado
	
	private String deporteAsignado ; 
	
	private float precio;

	private Date fechaCancelacion; 
	
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
			float precio, Date fechaCancelacion) {
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

	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	@Override
	/**
	 * Devuelve una cadena con todos los datos del socio
	 * 
	 * @return Cadena con los datos del socio
	 */
	public String toString() {
		return "DetallesAbono [idSocio=" + idSocio + ", idAbono=" + idAbono + ", idLocalidad=" + idLocalidad
				+ ", tipoAbono=" + tipoAbono + ", deporteAsignado=" + deporteAsignado + ", precio=" + precio
				+ ", fechaCancelacion=" + fechaCancelacion + "]";
	}

	@Override
	/**
	 * Compara si dos abonos son iguales
	 * @return True si son iguales y false en caso contrario
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallesAbono other = (DetallesAbono) obj;
		if (deporteAsignado == null) {
			if (other.deporteAsignado != null)
				return false;
		} else if (!deporteAsignado.equals(other.deporteAsignado))
			return false;
		if (fechaCancelacion == null) {
			if (other.fechaCancelacion != null)
				return false;
		} else if (!fechaCancelacion.equals(other.fechaCancelacion))
			return false;
		if (idAbono == null) {
			if (other.idAbono != null)
				return false;
		} else if (!idAbono.equals(other.idAbono))
			return false;
		if (idLocalidad == null) {
			if (other.idLocalidad != null)
				return false;
		} else if (!idLocalidad.equals(other.idLocalidad))
			return false;
		if (idSocio == null) {
			if (other.idSocio != null)
				return false;
		} else if (!idSocio.equals(other.idSocio))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (tipoAbono == null) {
			if (other.tipoAbono != null)
				return false;
		} else if (!tipoAbono.equals(other.tipoAbono))
			return false;
		return true;
	}
	
}
