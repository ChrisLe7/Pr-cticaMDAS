package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DetallesSocio  extends DetallesCliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idSocio;
	private Date antiguedad;
	private Categoria categoria;
	
	/**
	 * Constructor completo de un Socio
	 * @param idSocio 
	 * @param nombreSocio
	 * @param ApellidosSocio
	 * @param direccion
	 * @param telefonoContacto
	 * @param edad
	 * @param antiguedad
	 * @param categoria
	 * */
	
	public DetallesSocio(String idSocio, String nombreSocio, String apellidosSocio, String direccion,
			String telefonoContacto, Date edad, Date antiguedad, Categoria categoria) {
		super(nombreSocio, apellidosSocio,direccion,telefonoContacto,edad);
		this.idSocio = idSocio;
		this.antiguedad = antiguedad;
		this.categoria = categoria;
	}
	
	/**
	 * Constructor por defecto de un Socio, solo obligará al id del Socio
	 * @param idSocio 
	 * */
	public DetallesSocio(String idSocio) {
		this(idSocio,"", "", "", "", null, null, Categoria.Adulto);
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
	 * Devuelve la fecha de inicio de la creación del Socio
	 * @return Fecha del Creacion del Socio
	 * */
	public Date getFechaAntiguedad() {
		return antiguedad;
	}

	/**
	 * Asigna la fecha de inicio de la creación del Socio
	 * @param antiguedad Fecha de la Creacion del Socio
	 * */
	public void setFechaAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	/**
	 * Devuelve el numero de años ha sido socio 
	 * @return Tiempo siendo socio
	 * */
	public int getAntiguedad() {
		Period tiempo = Period.between(LocalDate.ofEpochDay(this.antiguedad.getTime()), LocalDate.now());
		return tiempo.getYears();
	}
	/**
	 * Devuelve la categoria del socio
	 * @return Categoria del cliente, la cual podrá ser de los tipos indicados en el Enum Categoria
	 * */
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Asigna como categoria del cliente la categoria pasada.
	 * @param categoria Nueva categoría asignada al cliente
	 * */
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
