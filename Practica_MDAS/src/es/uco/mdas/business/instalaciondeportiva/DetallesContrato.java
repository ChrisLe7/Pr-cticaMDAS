package es.uco.mdas.business.instalaciondeportiva;

import java.io.Serializable;
import java.util.Date;

public class DetallesContrato implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idContrato;
	private String idEmpresa;
	private String cuentaBancaria;
	private String idEspacio;
	private Date fechaRestriccion;
	
	/**
	 * Constructor completo de contrato
	 * 
	 * @param idContrato Id del contrato
	 * @param idEmpresa Id de la empresa arrendataria
	 * @param cuentaBancaria Cuenta bancaria utilizada en el contrato
	 * @param idEspacio Id del espacio comercial
	 * @param fechaRestriccion Fecha de finalizacion del contrato
	 */
	public DetallesContrato(String idContrato, String idEmpresa, String cuentaBancaria, String idEspacio, Date fechaRestriccion) {
		this.idContrato = idContrato;
		this.idEmpresa = idEmpresa;
		this.cuentaBancaria = cuentaBancaria;
		this.idEspacio = idEspacio;
		this.fechaRestriccion = fechaRestriccion;
	}

	/**
	 * Devuelve la id del contrato
	 * 
	 * @return Id del contrato
	 */
	public String getIdContrato() {
		return idContrato;
	}

	/**
	 * Asigna una id al contrato
	 * 
	 * @param idContrato Id del contrato a asignar
	 */
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}

	/**
	 * Devuelve la id de la empresa arrendataria del contrato
	 * 
	 * @return Id de la empresa arrendataria del contrato
	 */
	public String getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * Asigna una id de empresa arrendataria al contrato
	 * 
	 * @param idEmpresa Id de la empresa arrendataria a asignar
	 */
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * Devuelve la cuenta bancaria usada en el contrato
	 * 
	 * @return Cuenta bancaria usada en el contrat
	 */
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	/**
	 * Asigna una cuenta bancaria al contrato
	 * 
	 * @param cuentaBancaria Cuenta bancaria a asignar
	 */
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	/**
	 * Devuelve la id del espacio comercial del contrato
	 * 
	 * @return Id del espacio comercial del contrato
	 */
	public String getIdEspacio() {
		return idEspacio;
	}

	/**
	 * Asiga una id del espacio comercial al contrato
	 * 
	 * @param idEspacio Id del espacio comercial a asignar
	 */
	public void setIdEspacio(String idEspacio) {
		this.idEspacio = idEspacio;
	}

	/**
	 * Devuelve la fecha de finalizacion del contrato
	 * 
	 * @return Fecha de finalizacion del contrato
	 */
	public Date getFechaRestriccion() {
		return fechaRestriccion;
	}

	/**
	 * Asigna una fecha de finalizacion al contrato
	 * 
	 * @param fechaRestriccion Fecha de finalizacion a asignar
	 */
	public void setFechaRestriccion(Date fechaRestriccion) {
		this.fechaRestriccion = fechaRestriccion;
	}
	
}
