package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DetallesSocio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idSocio;
	private String nombreSocio;
	private String apellidosSocio;
	private String direccion;
	private String telefonoContacto;
	private Date edad;
	private Date antiguedad;
	
	/**
	 * Constructor completo de un Socio
	 * @param idSocio 
	 * @param nombreSocio
	 * @param ApellidosSocio
	 * @param direccion
	 * @param telefonoContacto
	 * @param edad
	 * @param antiguedad
	 *  
	 * */
	
	public DetallesSocio(String idSocio, String nombreSocio, String apellidosSocio, String direccion,
			String telefonoContacto, Date edad, Date antiguedad) {
		super();
		this.idSocio = idSocio;
		this.nombreSocio = nombreSocio;
		this.apellidosSocio = apellidosSocio;
		this.direccion = direccion;
		this.telefonoContacto = telefonoContacto;
		this.edad = edad;
		this.antiguedad = antiguedad;
	}
	
	/**
	 * Constructor por defecto de un Socio, solo obligará al id del Socio
	 * @param idSocio 
	 * */
	public DetallesSocio(String idSocio) {
		this(idSocio,"", "", "", "", null, null);
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
	 * Devuelve el Nombre del Socio
	 * @return Nombre del Socio
	 * 
	 * */
		
	public String getNombreSocio() {
		return nombreSocio;
	}
	
	/**
	 * Asigna un Nombre al socio
	 * 
	 * @param nombreSocio Nombre a asignar al socio
	 * */
	
	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
	
	/**
	 * Devuelve los Apellidos del Socio
	 * @return Apellidos del Socio
	 * 
	 * */	
	
	public String getApellidosSocio() {
		return apellidosSocio;
	}
	
	/**
	 * Asigna los Apellidos al socio
	 * 
	 * @paramr apellidosSocio Apellidos a asignar al socio.
	 * */
	
	public void setApellidosSocio(String apellidosSocio) {
		this.apellidosSocio = apellidosSocio;
	}
	
	
	/**
	 * Devuelve la Direccion de Contacto del Socio
	 * @return Direccion del cliente
	 * */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Asigna la direccion de contacto al socio.
	 * @param direccion Direccion de contacto del socio a asignar.
	 * */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Devuelve el Telefono de Contacto del Socio
	 * @return Telefono contacto del cliente
	 * */
	
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	
	
	/**
	 * Asigna el telefono de contacto al socio.
	 * @param telefonoContacto Telefono de contacto del socio a asignar.
	 * */
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	/**
	 * Devuelve la fecha de Nacimiento del Socio
	 * @return Telefono contacto del cliente
	 * */
	
	public Date getFechaNacimiento() {
		return edad;
	}

	/**
	 * Asigna el telefono de contacto al socio.
	 * @param telefonoContacto Telefono de contacto del socio a asignar.
	 * */
	
	public void setFechaNacimiento(Date edad) {
		this.edad = edad;
	}
	
	
	/**
	 * Devuelve la edad que tiene el Socio
	 * @return Edad del Socio
	 * */
	public int getEdad() {
		Period edad = Period.between(LocalDate.ofEpochDay(this.edad.getTime()), LocalDate.now());
		return edad.getYears();
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
		Period tiempo = Period.between(LocalDate.ofEpochDay(this.edad.getTime()), LocalDate.now());
		return tiempo.getYears();
	}

}
