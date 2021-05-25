package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DetallesCliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreSocio;
	private String apellidosSocio;
	private String direccion;
	private String telefonoContacto;
	private Date edad;
	
	
	/**
	 * Constructor completo de un Cliente
	 * @param nombreSocio
	 * @param ApellidosSocio
	 * @param direccion
	 * @param telefonoContacto
	 * @param edad
	 *  
	 * */
	
	public DetallesCliente(String nombreSocio, String apellidosSocio, String direccion, String telefonoContacto,
			Date edad) {
		super();
		this.nombreSocio = nombreSocio;
		this.apellidosSocio = apellidosSocio;
		this.direccion = direccion;
		this.telefonoContacto = telefonoContacto;
		this.edad = edad;
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

}
