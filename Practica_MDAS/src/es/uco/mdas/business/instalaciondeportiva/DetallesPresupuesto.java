package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;

public class DetallesPresupuesto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idPresupuesto;
	private String idEspacio;
	private float precio;
	
	/**
	 * Contructor completo de presupuesto
	 * 
	 * @param idPresupuesto Id del presupuesto
	 * @param idEspacio Id del espacio comercial
	 * @param precio Precio acordado
	 */
	public DetallesPresupuesto(String idPresupuesto, String idEspacio, float precio) {
		super();
		this.idPresupuesto = idPresupuesto;
		this.idEspacio = idEspacio;
		this.precio = precio;
	}

	/**
	 * Devuelve la id del presupuesto
	 * 
	 * @return Id del presupuesto
	 */
	public String getIdPresupuesto() {
		return idPresupuesto;
	}

	/**
	 * Asigna una id al presupuesto
	 * 
	 * @param idPresupuesto Id del presupuesto a asignar
	 */
	public void setIdPresupuesto(String idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	/**
	 * Devuelve la id del espacio comercial del que es el presupuesto
	 * 
	 * @return Id del espacio comercial del que es el presupuesto
	 */
	public String getIdEspacio() {
		return idEspacio;
	}

	/**
	 * Asigna una id del espacio comercial del que es el presupuesto
	 * 
	 * @param idEspacio Id del espacio comercial del que es el presupuesto a asignar
	 */
	public void setIdEspacio(String idEspacio) {
		this.idEspacio = idEspacio;
	}

	/**
	 * Devuelve el precio acordado en el presupuesto
	 * 
	 * @return Precio acordado en el presupuesto
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Asigna un precio al presupuesto
	 * 
	 * @param precio Precio del presupuesto a asignar
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	/**
	 * Devuelve una cadena con todos los datos del presupuesto
	 * 
	 * @return Cadena con los datos del presupuesto
	 */
	public String toString() {
		return "DetallesPresupuesto [idPresupuesto=" + idPresupuesto + ", idEspacio=" + idEspacio + ", precio=" + precio
				+ "]";
	}

	@Override
	/**
	 * Compara si dos presupuestos son iguales
	 * @return True si son iguales y false en caso contrario
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallesPresupuesto other = (DetallesPresupuesto) obj;
		if (idEspacio == null) {
			if (other.idEspacio != null)
				return false;
		} else if (!idEspacio.equals(other.idEspacio))
			return false;
		if (idPresupuesto == null) {
			if (other.idPresupuesto != null)
				return false;
		} else if (!idPresupuesto.equals(other.idPresupuesto))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		return true;
	}
	
	

}
