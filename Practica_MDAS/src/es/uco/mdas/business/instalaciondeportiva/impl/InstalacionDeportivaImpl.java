package es.uco.mdas.business.instalaciondeportiva.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import es.uco.mdas.business.instalaciondeportiva.DetallesContrato;
import es.uco.mdas.business.instalaciondeportiva.DetallesDespacho;
import es.uco.mdas.business.instalaciondeportiva.DetallesEspacioComercial;
import es.uco.mdas.business.instalaciondeportiva.DetallesEstadio;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.DetallesPresupuesto;
import es.uco.mdas.business.instalaciondeportiva.GestionarAbono;
import es.uco.mdas.business.instalaciondeportiva.GestionarDespacho;
import es.uco.mdas.business.instalaciondeportiva.GestionarEspacioComercial;
import es.uco.mdas.business.instalaciondeportiva.RealizacionContrato;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.ContratoDAO;
import es.uco.mdas.datos.DespachoDAO;
import es.uco.mdas.datos.EspacioComercialDAO;
import es.uco.mdas.datos.LocalidadDAO;


public class InstalacionDeportivaImpl implements GestionarAbono, RealizacionContrato, GestionarDespacho, GestionarEspacioComercial{

	private AbonoDAO abonoDAO;
	private ContratoDAO contratoDAO;
	private DespachoDAO despachoDAO;
	private EspacioComercialDAO espacioComercialDAO;
	private LocalidadDAO localidadDAO;
	
	
	
	public InstalacionDeportivaImpl(AbonoDAO abonoDAO, ContratoDAO contratoDAO, DespachoDAO despachoDAO,
			EspacioComercialDAO espacioComercialDAO, LocalidadDAO localidadDAO) {
		super();
		this.abonoDAO = abonoDAO;
		this.contratoDAO = contratoDAO;
		this.despachoDAO = despachoDAO;
		this.espacioComercialDAO = espacioComercialDAO;
		this.localidadDAO = localidadDAO;
	}

	public InstalacionDeportivaImpl(AbonoDAO abonoDAO) {
		this(abonoDAO,null,null, null, null);
	}
	
	
	
	public InstalacionDeportivaImpl(AbonoDAO abonoDAO, LocalidadDAO localidadDAO) {
		this(abonoDAO,null,null, null, localidadDAO);
	}
	
	public InstalacionDeportivaImpl(LocalidadDAO localidadDAO) {
		this(null,null,null, null, localidadDAO);
	}
	//Según el resto de componentes del sistema completo deberíamos de realizar las diferentes combinaciones necesarias.
	
	@Override
	public ArrayList<DetallesLocalidad> getLocalidadesDisponibles() {
		HashMap<String, DetallesLocalidad> listadoLocalidades = localidadDAO.queryAll();
		
		ArrayList<DetallesLocalidad> localidadesLibres = new ArrayList<>();
		for (String idLocalidad : listadoLocalidades.keySet()) {
			DetallesLocalidad registroLocalidad = listadoLocalidades.get(idLocalidad);
			if (registroLocalidad.getIdSocio().equals("")) {
				localidadesLibres.add(registroLocalidad);
			}
		}
		
		return localidadesLibres;
	}

	@Override
	public boolean asignarLocalidad(DetallesLocalidad localidad, String idSocio) {
		
		DetallesLocalidad registroLocalidad = localidadDAO.queryById(localidad.getIdLocalidad());
		
		if (registroLocalidad.getIdSocio().equals("")) {
			registroLocalidad.setIdSocio(idSocio);
			localidadDAO.update(registroLocalidad);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean liberarLocalidad(DetallesLocalidad localidad) {
		DetallesLocalidad registroLocalidad = localidadDAO.queryById(localidad.getIdLocalidad());
		
		if (!registroLocalidad.getIdSocio().equals("")) {
			registroLocalidad.setIdSocio("");
			
		
			return localidadDAO.update(registroLocalidad);
		}
		
		return false;
	}

	@Override
	public boolean liberarAbono(String idAbono) {
		
		boolean estado = false;
		
		DetallesAbono informacionAbono = abonoDAO.queryById(idAbono);
		
		String idLocalidad = informacionAbono.getIdLocalidad();
				
		DetallesLocalidad informacionLocalidad = localidadDAO.queryById(idLocalidad);
		
		if (informacionLocalidad != null) {
			this.liberarLocalidad(informacionLocalidad);
			estado = !estado;
		}
		
		return estado;
	}

	@Override
	public boolean registrarAbono(DetallesAbono abono) {
		
		boolean estado = false;
	
		String idLocalidad = abono.getIdLocalidad();
		
		DetallesLocalidad informacionLocalidad = localidadDAO.queryById(idLocalidad);
		
		if (informacionLocalidad.getIdSocio() == "" ) {
			informacionLocalidad.setIdSocio(abono.getIdAbono());
			estado = !estado;
		}
		
		return estado;
	}
	
	@Override
	public DetallesLocalidad getDetallesLocalidad(String idLocalidad) {

		DetallesLocalidad infoLocalidad = localidadDAO.queryById(idLocalidad);
		return infoLocalidad;
	}

	@Override
	public DetallesPresupuesto generarPresupuesto(DetallesEspacioComercial espacioComercial) {
		String idPresupuesto = "";
		
		String idEspacioAComprar = espacioComercial.getIdEspacio();
		float precioParaPresupuesto = espacioComercial.getPrecio();
		DetallesPresupuesto presupuestoGenerado  = new DetallesPresupuesto(idPresupuesto, idEspacioAComprar, precioParaPresupuesto);
		
		return presupuestoGenerado;
	}

	@Override
	public DetallesContrato realizarContrato(String idEmpresa, String cuentaBancaria, String idEstadio) {
		
		return null;
	}

	@Override
	public boolean asignarEspacioComercial(String idEspacioComercial, String idEmpresa) {
				
		DetallesEspacioComercial espacioComercialAAsignar = espacioComercialDAO.queryById(idEspacioComercial);
		
		if (espacioComercialAAsignar != null) {
			if (espacioComercialAAsignar.getArrendado().equals("")) {
				espacioComercialAAsignar.setArrendado(idEmpresa);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public DetallesContrato renovarContrato(String idContrato) {
		
		DetallesContrato contratoARenovar = contratoDAO.queryById(idContrato);
		
		Date fechaRenovacionContrato = contratoARenovar.getFechaRestriccion();
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fechaRenovacionContrato);
		calendario.add(Calendar.YEAR, 1);
		contratoARenovar.setFechaRestriccion(calendario.getTime());
		
		contratoDAO.update(contratoARenovar);
		return contratoARenovar;
	}

	@Override 
	public void cancelarContrato(String idContrato) {
		
		DetallesContrato contratoACancelar = contratoDAO.queryById(idContrato);
		
		if (contratoACancelar != null) {
			contratoACancelar.setFechaRestriccion(new Date());
			
			contratoDAO.update(contratoACancelar);

		}
	
		
	}

	@Override
	public void liberarEspacioComercial(String idEspacioComercial) {
		
		DetallesEspacioComercial espacioComercialLiberar = espacioComercialDAO.queryById(idEspacioComercial);
		espacioComercialLiberar.setArrendado("");
		espacioComercialDAO.update(espacioComercialLiberar);
		
	}

	@Override
	public ArrayList<DetallesDespacho> getDespachosLibresEstadio() {
				
		HashMap<String, DetallesDespacho> listadoCompletoDespachos = despachoDAO.queryAll();
		
		ArrayList<DetallesDespacho> despachosDisponibles = new ArrayList<> ();
		
		for (String idDespacho : listadoCompletoDespachos.keySet()) {
			DetallesDespacho informacionDespacho = listadoCompletoDespachos.get(idDespacho);
			if ( informacionDespacho.getIdMiembro() != null || !informacionDespacho.getIdMiembro().equals(""))  {
				despachosDisponibles.add(informacionDespacho);
			}
		}
			
		
		return despachosDisponibles;
		
	}

	@Override 
	public void asignarDespachoEstadio(DetallesEstadio estadio, DetallesDespacho despacho, String idMiembro) {
		
		despacho.setIdMiembro(idMiembro);
		despacho.setLocalizacion(estadio.getIdEstadio());
		
		if (!despachoDAO.update(despacho)) {
			despachoDAO.insert(despacho);
		} 
	}

	@Override
	public ArrayList<DetallesEspacioComercial> obtenerListadoEspacios() {
		
		HashMap<String, DetallesEspacioComercial> listadoespacioComerciales = espacioComercialDAO.queryAll();
		Collection<DetallesEspacioComercial> espaciosComerciales = listadoespacioComerciales.values();
		
		ArrayList<DetallesEspacioComercial> listadoEspaciosComerciales = new ArrayList<> (espaciosComerciales);
		
		return listadoEspaciosComerciales;
	}

	@Override
	public DetallesEspacioComercial getEspacioComercial(String idEspacioComercial) {
		
		DetallesEspacioComercial infoEspacioComercialDeseado = espacioComercialDAO.queryById(idEspacioComercial);
		return infoEspacioComercialDeseado;
	}



}
