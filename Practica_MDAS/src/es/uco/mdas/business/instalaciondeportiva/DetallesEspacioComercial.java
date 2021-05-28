package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;

public class DetallesEspacioComercial implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idEspacio;
	private TipoEspacio tipoEspacio;
	private String localizacion;
	private float precio;
	private String arrendado;
	
	/**
	 * Constructor completo de espacio comercial
	 * 
	 * @param idEspacio Id del espacio comercial
	 * @param tipoEspacio Tipo del espacio comercial
	 * @param localizacion Localizacion del espacio comercial
	 * @param precio Precio del espacio comercial
	 * @param arrendado Empresa arrendataria del espacio comercial
	 */
	public DetallesEspacioComercial(String idEspacio, TipoEspacio tipoEspacio, String localizacion, float precio, String arrendado) {
		this.idEspacio = idEspacio;
		this.tipoEspacio = tipoEspacio;
		this.localizacion = localizacion;
		this.precio = precio;
		this.arrendado = arrendado;
	}

	/**
	 * Devuelve la id del espacio comercial
	 * 
	 * @return Id del espacio comercial
	 */
	public String getIdEspacio() {
		return idEspacio;
	}

	/**
	 * Asigna una id al espacio comercial
	 * 
	 * @param idEspacio Id del espacio comercial a asignar
	 */
	public void setIdEspacio(String idEspacio) {
		this.idEspacio = idEspacio;
	}

	/**
	 * Devuelve el tipo del espacio comercial
	 * 
	 * @return Tipo del espacio comercial
	 */
	public TipoEspacio getTipoEspacio() {
		return tipoEspacio;
	}

	/**
	 * Asigna un tipo al espacio comercial
	 * 
	 * @param tipoEspacio Tipo del espacio comercial a asignar
	 */
	public void setTipoEspacio(TipoEspacio tipoEspacio) {
		this.tipoEspacio = tipoEspacio;
	}

	/**
	 * Devuelve la localizacion del espacio comercial
	 * 
	 * @return Localizacion del espacio comercial
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * Asigna una localizacion al espacio comercial
	 * 
	 * @param localizacion Localizacion del espacio comercial a asignar
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * Devuelve el precio del espacio comercial
	 * 
	 * @return Precio del espacio comercial
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Asigna un precio al espacio comercial
	 * 
	 * @param precio Precio del espacio comercial a asignar
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve la empresa arrendataria del espacio comercial
	 * 
	 * @return Empresa arrendataria del espacio comercial
	 */
	public String getArrendado() {
		return arrendado;
	}

	/**
	 * Asigna una empreda arrendataria al espacio comercial
	 * 
	 * @param arrendado Empresa arrendataria del espacio comercial a asignar
	 */
	public void setArrendado(String arrendado) {
		this.arrendado = arrendado;
	}
	
}
