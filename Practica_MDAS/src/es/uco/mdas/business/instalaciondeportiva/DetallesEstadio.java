package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;

public class DetallesEstadio implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idEstadio;
	private String localizacion;
	private int aforo;
	private String dimensiones;
	
	/**
	 * Constructor completo de estadio
	 * 
	 * @param idEstadio Id del estadio
	 * @param localizacion Localizacion del estadio
	 * @param aforo Aforo del estadio
	 * @param anchura Anchura del estadio
	 * @param longitud Longitud del estadio
	 */
	public DetallesEstadio(String idEstadio, String localizacion, int aforo, float anchura, float longitud) {
		this.idEstadio = idEstadio;
		this.localizacion = localizacion;
		this.aforo = aforo;
		this.dimensiones = anchura + "x" + longitud;
	}

	/**
	 * Devuelve el id del estadio
	 * 
	 * @return Id del estadio
	 */
	public String getIdEstadio() {
		return idEstadio;
	}

	/**
	 * Asigna una id al estadio
	 * 
	 * @param idEstadio Id del estadio a asignar
	 */
	public void setIdEstadio(String idEstadio) {
		this.idEstadio = idEstadio;
	}

	/**
	 * Devuelve la localizacion del estadio
	 * 
	 * @return Localizacion del estadio
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * Asigna una localizacion al estadio
	 * 
	 * @param localizacion Localizacion del estadio a asignar
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * Devuelve el aforo del estadio
	 * 
	 * @return Aforo del estadio
	 */
	public int getAforo() {
		return aforo;
	}

	/**
	 * Asigna un aforo al estadio
	 * 
	 * @param aforo Aforo del estadio a asignar
	 */
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	/**
	 * Devuelve las dimensiones del estadio
	 * 
	 * @return Dimensiones del estadio
	 */
	public String getDimensiones() {
		return dimensiones;
	}

	/**
	 * Asigna una dimensiones al estadio
	 * 
	 * @param anchura Anchura del estadio a asignar
	 * @param longitud Longitud del estadio a asignar
	 */
	public void setDimensiones(float anchura, float longitud) {
		this.dimensiones = anchura + "x" + longitud;
	}

	@Override
	/**
	 * Devuelve una cadena con todos los datos del estadio
	 * 
	 * @return Cadena con los datos del estadio
	 */
	public String toString() {
		return "DetallesEstadio [idEstadio=" + idEstadio + ", localizacion=" + localizacion + ", aforo=" + aforo
				+ ", dimensiones=" + dimensiones + "]";
	}

	@Override
	/**
	 * Compara si dos estadios son iguales
	 * @return True si son iguales y false en caso contrario
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallesEstadio other = (DetallesEstadio) obj;
		if (aforo != other.aforo)
			return false;
		if (dimensiones == null) {
			if (other.dimensiones != null)
				return false;
		} else if (!dimensiones.equals(other.dimensiones))
			return false;
		if (idEstadio == null) {
			if (other.idEstadio != null)
				return false;
		} else if (!idEstadio.equals(other.idEstadio))
			return false;
		if (localizacion == null) {
			if (other.localizacion != null)
				return false;
		} else if (!localizacion.equals(other.localizacion))
			return false;
		return true;
	}
	
}
