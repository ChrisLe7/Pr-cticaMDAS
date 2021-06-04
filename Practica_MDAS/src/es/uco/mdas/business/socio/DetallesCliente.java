package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class DetallesCliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombreSocio;
	private String apellidosSocio;
	private String direccion;
	private String telefonoContacto;
	private Date edad;
	
	/**
	 * Constructor completo de un cliente
	 * @param nombreSocio Nombre del cliente
	 * @param ApellidosSocio Apellidos del cliente
	 * @param direccion Direccion del cliente
	 * @param telefonoContacto Telefono del cliente
	 * @param edad Fecha de nacimiento del cliente
	 */
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
	 */	
	public String getNombreSocio() {
		return nombreSocio;
	}
	
	/**
	 * Asigna un Nombre al socio
	 * @param nombreSocio Nombre a asignar al socio
	 */
	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
	
	/**
	 * Devuelve los Apellidos del Socio
	 * @return Apellidos del Socio
	 * 
	 */
	public String getApellidosSocio() {
		return apellidosSocio;
	}
	
	/**
	 * Asigna los Apellidos al socio
	 * 
	 * @paramr apellidosSocio Apellidos a asignar al socio.
	 */
	public void setApellidosSocio(String apellidosSocio) {
		this.apellidosSocio = apellidosSocio;
	}
	
	
	/**
	 * Devuelve la Direccion de Contacto del Socio
	 * @return Direccion del cliente
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Asigna la direccion de contacto al socio.
	 * @param direccion Direccion de contacto del socio a asignar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Devuelve el Telefono de Contacto del Socio
	 * @return Telefono contacto del cliente
	 */
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
	 * @return Fecha de Nacimiento del Socio
	 */
	public Date getFechaNacimiento() {
		return edad;
	}

	/**
	 * Asigna la fecha de nacimiento al socio.
	 * @param edad Fecha de nacimiento del socio a asignar.
	 */
	public void setFechaNacimiento(Date edad) {
		this.edad = edad;
	}
	
	/**
	 * Devuelve la edad que tiene el Socio
	 * @return Edad del Socio
	 */
	public int getEdad() {
		Calendar nacimiento = Calendar.getInstance();
		nacimiento.setTime(this.edad);
		Calendar hoy = Calendar.getInstance();
		hoy.setTime(new Date());
		int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
		return edad;
	}

	@Override
	/**
	 * Devuelve una cadena con todos los datos del cliente
	 * @return Cadena con los datos del cliente
	 */
	public String toString() {
		return "DetallesCliente [nombreSocio=" + nombreSocio + ", apellidosSocio=" + apellidosSocio + ", direccion="
				+ direccion + ", telefonoContacto=" + telefonoContacto + ", edad=" + edad + "]";
	}

	@Override
	/**
	 * Compara si dos clientes son iguales
	 * @return True si son iguales y false en caso contrario
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallesCliente other = (DetallesCliente) obj;
		if (apellidosSocio == null) {
			if (other.apellidosSocio != null)
				return false;
		} else if (!apellidosSocio.equals(other.apellidosSocio))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (nombreSocio == null) {
			if (other.nombreSocio != null)
				return false;
		} else if (!nombreSocio.equals(other.nombreSocio))
			return false;
		if (telefonoContacto == null) {
			if (other.telefonoContacto != null)
				return false;
		} else if (!telefonoContacto.equals(other.telefonoContacto))
			return false;
		return true;
	}

}
