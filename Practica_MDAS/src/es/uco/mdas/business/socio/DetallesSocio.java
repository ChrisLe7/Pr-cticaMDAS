package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public abstract class DetallesSocio implements Serializable{

	private static final long serialVersionUID = 1L;	
	protected String idSocio;
	protected String nombreSocio;
	protected String apellidosSocio;
	protected String direccion;
	protected String telefonoContacto;
	protected Date edad;
	protected Date antiguedad;
	protected String categoria;
	protected float descuento;
	
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
	protected DetallesSocio(String idSocio, String nombreSocio, String apellidosSocio, String direccion,
			String telefonoContacto, Date edad, Date antiguedad) {
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
	 * @param idSocio Id del socio
	 */
	protected DetallesSocio(String idSocio) {
		this(idSocio,"", "", "", "", null, null);
	}
	
	/**
	 * Contructor de socio a partir de la id y de datos de un cliente
	 * @param idSocio Id del socio
	 * @param cliente Datos del cliente
	 */
	protected DetallesSocio (String idSocio, DetallesCliente cliente) {
		this(idSocio,cliente.getNombreSocio(), cliente.getApellidosSocio(), cliente.getDireccion(), cliente.getTelefonoContacto(), 
	        		cliente.getFechaNacimiento(), new Date());      
	}

	/**
	 * Devuelve el Identificador del Socio
	 * 	@return ID del Socio
	 */
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
	
	/**
	 * Devuelve la fecha de inicio de la creación del Socio
	 * @return Fecha del Creacion del Socio
	 */
	public Date getFechaAntiguedad() {
		return antiguedad;
	}

	/**
	 * Asigna la fecha de inicio de la creación del Socio
	 * @param antiguedad Fecha de la Creacion del Socio
	 */
	public void setFechaAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	/**
	 * Devuelve el numero de años ha sido socio 
	 * @return Tiempo siendo socio
	 */
	public int getAntiguedad() {
		Calendar asociacion = Calendar.getInstance();
		asociacion.setTime(this.antiguedad);
		Calendar hoy = Calendar.getInstance();
		hoy.setTime(new Date());
		int antiguedad = hoy.get(Calendar.YEAR) - asociacion.get(Calendar.YEAR);
		return antiguedad;
	}
	
	/**
	 * Devuelve la categoria del socio
	 * @return Categoria del cliente, la cual podrá ser de los tipos indicados en el Enum Categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	
	/**
	 * Asigna como categoria del cliente la categoria pasada.
	 * @param categoria Nueva categoría asignada al cliente
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Devuelve el descuente del socio
	 * @return Descuento del socio
	 */
	public float getDescuento() {
		return descuento;
	}

	/**
	 * Asigna un descuento al socio
	 * @param descuento Descuento del socio a asignar
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	@Override
	/**
	 * Devuelve una cadena con todos los datos del socio
	 * @return Cadena con los datos del socio
	 */
	public String toString() {
		return "DetallesSocio [idSocio=" + idSocio + ", nombreSocio=" + nombreSocio + ", apellidosSocio="
				+ apellidosSocio + ", direccion=" + direccion + ", telefonoContacto=" + telefonoContacto + ", edad="
				+ edad + ", antiguedad=" + antiguedad + ", categoria=" + categoria + ", descuento=" + descuento + "]";
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
		DetallesSocio other = (DetallesSocio) obj;
		if (antiguedad == null) {
			if (other.antiguedad != null)
				return false;
		} else if (!antiguedad.equals(other.antiguedad))
			return false;
		if (apellidosSocio == null) {
			if (other.apellidosSocio != null)
				return false;
		} else if (!apellidosSocio.equals(other.apellidosSocio))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (Float.floatToIntBits(descuento) != Float.floatToIntBits(other.descuento))
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
		if (idSocio == null) {
			if (other.idSocio != null)
				return false;
		} else if (!idSocio.equals(other.idSocio))
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
