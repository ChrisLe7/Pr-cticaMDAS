package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.util.Date;

public class DetallesSocioPlata extends DetallesSocio implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor completo de un Socio
	 * @param idSocio Id del socio
	 * @param nombreSocio Nombre del socio
	 * @param ApellidosSocio Apellidos del socio
	 * @param direccion Direccion del socio
	 * @param telefonoContacto Telefono del socio
	 * @param edad Fecha de nacimiento del socio
	 * @param antiguedad Fecha de asociacion del socio
	 */
	public DetallesSocioPlata(String idSocio, String nombreSocio, String apellidosSocio, String direccion,
			String telefonoContacto, Date edad, Date antiguedad) {
		super(idSocio, nombreSocio, apellidosSocio, direccion, telefonoContacto, edad, antiguedad);
		this.categoria = "Plata";
		this.descuento = 15f;
	}
	
	/**
	 * Constructor por defecto de un Socio, solo obligar� al id del Socio
	 * @param idSocio Id del socio
	 */
	public DetallesSocioPlata(String idSocio) {
		super(idSocio);
		this.categoria = "Plata";
		this.descuento = 15f;
	}
	
	/**
	 * Contructor de socio a partir de la id y de datos de un cliente
	 * @param idSocio Id del socio
	 * @param cliente Datos del cliente
	 */
	public DetallesSocioPlata(String idSocio, DetallesCliente cliente) {
		super(idSocio, cliente);
		this.categoria = "Plata";
		this.descuento = 15f;
	}

}
