package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;

public class DetallesDespacho implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idDespacho;
	private String localizacion;
	private TipoDespacho tipo;
	private String idMiembro;
	/**
	 * Constructor completo de despacho
	 * 
	 * @param idDespacho Id del despacho
	 * @param localizacion Localizacion del despacho
	 * @param tipo Tipo del despacho
	 */
	public DetallesDespacho(String idDespacho, String localizacion, TipoDespacho tipo) {
		this.idDespacho = idDespacho;
		this.localizacion = localizacion;
		this.tipo = tipo;
	}

	/**
	 * Devuelve el id del despacho
	 * 
	 * @return Id del despacho
	 */
	public String getIdDespacho() {
		return idDespacho;
	}

	/**
	 * Asigna una id al despacho
	 * 
	 * @param idDespacho Id del despacho a asignar
	 */
	public void setIdDespacho(String idDespacho) {
		this.idDespacho = idDespacho;
	}

	/**
	 * Devuelve la localizacion del despacho
	 * 
	 * @return Localizacion del despacho
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * Asigna una localizacion al despacho
	 * 
	 * @param localizacion Localizacion del despacho a asignar
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * Devuelve el tipo del despacho
	 * 
	 * @return Tipo del despacho
	 */
	public TipoDespacho getTipo() {
		return tipo;
	}

	/**
	 * Asigna un tipo al despacho
	 * 
	 * @param tipo Tipo del despacho a asignar
	 */
	public void setTipo(TipoDespacho tipo) {
		this.tipo = tipo;
	}

	public String getIdMiembro() {
		return idMiembro;
	}

	public void setIdMiembro(String idMiembro) {
		this.idMiembro = idMiembro;
	}

	@Override
	/**
	 * Devuelve una cadena con todos los datos del Despacho
	 * 
	 * @return Cadena con los datos del Despacho
	 */
	public String toString() {
		return "DetallesDespacho [idDespacho=" + idDespacho + ", localizacion=" + localizacion + ", tipo=" + tipo
				+ ", idMiembro=" + idMiembro + "]";
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
		DetallesDespacho other = (DetallesDespacho) obj;
		if (this.idDespacho == null) {
			if (other.idDespacho != null)
				return false;
		} else if (!this.idDespacho.equals(other.idDespacho))
			return false;
		if (this.localizacion == null) {
			if (other.localizacion != null)
				return false;
		} else if (!this.localizacion.equals(other.localizacion))
			return false;
		if (this.tipo != other.tipo)
			return false;
		if (this.idMiembro == null) {
			if (other.idMiembro != null)
				return false;
		} else if (!this.idMiembro.equals(other.idMiembro))
			return false;
		return true;
	}
	
}
