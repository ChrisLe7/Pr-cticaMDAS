package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;
import java.util.Date;

public class DetallesEntrada implements Serializable {

	private static final long serialVersionUID = 1L;
	private String localizacion;
	private Date fecha;
	private String asiento;
	private float precio;
	
	/**
	 * Constructor completo de una entrada
	 * 
	 * @param localizacion Id de la instalacion deportiva para la que es valida la entrada
	 * @param fecha Fecha para la que es valida la entrada
	 * @param asiento Id de la localidad asignada a la entrada
	 * @param precio Precio de la entrada
	 */
	public DetallesEntrada(String localizacion, Date fecha, String asiento, float precio) {
		this.localizacion = localizacion;
		this.fecha = fecha;
		this.asiento = asiento;
		this.precio = precio;
	}

	/**
	 * Devuelve la id de la instalacion deportiva para la que es valida la entrada
	 * 
	 * @return Id de la instalacion deportiva para la que es valida la entrada
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * Asigna una id de la instalacion deportiva para la que es valida la entrada
	 * 
	 * @param localizacion Id de la instalacion deportiva para la que es valida la entrada a asignar
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * Devuelve la fecha para la que es valida la entrada
	 * 
	 * @return Fecha para la que es valida la entrada
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Asigna una fehca para la que es valida la entrada
	 * 
	 * @param fecha Fecha para la que es valida la entrada a asignar
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve la id de la localidad asignada a la entrada
	 * 
	 * @return Id de la localidad asignada a la entrada
	 */
	public String getAsiento() {
		return asiento;
	}

	/**
	 * Asigna una id de la localidad asignada a la entrada
	 * 
	 * @param asiento Id de la localidad asignada a la entrada a asignar
	 */
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	/**
	 * Devuelve el precio de la entrada
	 * 
	 * @return Precio de la entrada
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Asigna un precio a la entrada
	 * 
	 * @param precio Precio a asignar
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
