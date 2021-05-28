package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;

public class DetallesDespacho implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idDespacho;
	private String localizacion;
	private TipoDespacho tipo;
	
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
	
}
