package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class DetallesSocio  extends DetallesCliente implements Serializable{

	private static final long serialVersionUID = 1L;	
	private String idSocio;
	private Date antiguedad;
	private Categoria categoria;
	
	/**
	 * Constructor completo de un Socio
	 * @param idSocio Id del socio
	 * @param nombreSocio Nombre del socio
	 * @param ApellidosSocio Apellidos del socio
	 * @param direccion Direccion del socio
	 * @param telefonoContacto Telefono del socio
	 * @param edad Fecha de nacimiento del socio
	 * @param antiguedad Fecha de asociacion del socio
	 * @param categoria Categoria del socio
	 */
	public DetallesSocio(String idSocio, String nombreSocio, String apellidosSocio, String direccion,
			String telefonoContacto, Date edad, Date antiguedad, Categoria categoria) {
		super(nombreSocio, apellidosSocio, direccion, telefonoContacto, edad);
		this.idSocio = idSocio;
		this.antiguedad = antiguedad;
		this.categoria = categoria;
	}
	
	/**
	 * Constructor por defecto de un Socio, solo obligará al id del Socio
	 * @param idSocio Id del socio
	 */
	public DetallesSocio(String idSocio) {
		this(idSocio,"", "", "", "", null, null, Categoria.Adulto);
	}
	
	/**
	 * Contructor de socio a partir de la id y de datos de un cliente
	 * @param idSocio Id del socio
	 * @param cliente Datos del cliente
	 */
	public DetallesSocio (String idSocio, DetallesCliente cliente) {
		this(idSocio,cliente.getNombreSocio(), cliente.getApellidosSocio(), cliente.getDireccion(), cliente.getTelefonoContacto(), 
	        		cliente.getFechaNacimiento(), new Date(), Categoria.Adulto);
		 
		int aniosSocioOro = 65; // edad minima requerida para ser socio de oro
        int aniosSocioAdulto = 18; // edad minima requerida para ser socio adulto
        Categoria categoria;
        
        if (cliente.getEdad() >= aniosSocioOro) {
        	categoria = Categoria.Oro;
        }
        else { 
	        if (cliente.getEdad() >= aniosSocioAdulto) {
	        	categoria = Categoria.Adulto;
	        }	        
	        else {
	            categoria =  Categoria.Infantil;
	        }
        }
        
        this.categoria = categoria;
       
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
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Asigna como categoria del cliente la categoria pasada.
	 * @param categoria Nueva categoría asignada al cliente
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	/**
	 * Devuelve una cadena con todos los datos del socio
	 * 
	 * @return Cadena con los datos del socio
	 */
	public String toString() {
		return "DetallesSocio [idSocio=" + idSocio + ", nombreSocio=" + nombreSocio + ", apellidosSocio=" + apellidosSocio
				+ ", direccion=" + direccion + ", telefonoContacto=" + telefonoContacto + ", edad=" + edad
				+ ", antiguedad=" + antiguedad + ", categoria=" + categoria + "]";
	}

	@Override
	/**
	 * Compara si dos socios son iguales
	 * @return True si son iguales y false en caso contrario
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallesSocio other = (DetallesSocio) obj;
		if (antiguedad == null) {
			if (other.antiguedad != null)
				return false;
		} else if (!antiguedad.equals(other.antiguedad))
			return false;
		if (categoria != other.categoria)
			return false;
		if (idSocio == null) {
			if (other.idSocio != null)
				return false;
		} else if (!idSocio.equals(other.idSocio))
			return false;
		return true;
	}

}
