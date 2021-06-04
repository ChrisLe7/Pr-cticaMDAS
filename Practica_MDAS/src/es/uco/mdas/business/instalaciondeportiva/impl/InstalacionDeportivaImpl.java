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
import es.uco.mdas.datos.AbonoDAOImpFicheros;
import es.uco.mdas.datos.ContratoDAO;
import es.uco.mdas.datos.ContratoDAOImpFicheros;
import es.uco.mdas.datos.DespachoDAO;
import es.uco.mdas.datos.DespachoDAOImpFicheros;
import es.uco.mdas.datos.EspacioComercialDAO;
import es.uco.mdas.datos.EspacioComercialDAOImpFicheros;
import es.uco.mdas.datos.LocalidadDAO;
import es.uco.mdas.datos.LocalidadDAOImpFicheros;

public class InstalacionDeportivaImpl implements GestionarAbono, RealizacionContrato, GestionarDespacho, GestionarEspacioComercial{

	@Override
	public ArrayList<DetallesLocalidad> getLocalidadesDisponibles() {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		

		HashMap<String, DetallesLocalidad> listadoLocalidades = localidadDAO.queryAll();
		Collection<DetallesLocalidad> localidades = listadoLocalidades.values();
		
		ArrayList<DetallesLocalidad> localidadesDisponibles = new ArrayList<> (localidades);
		
		return localidadesDisponibles;
	}

	@Override
	public void asignarLocalidad(DetallesLocalidad localidad, String idSocio) {
		localidad.setIdSocio(idSocio);
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		localidadDAO.update(localidad);
		
		
	}

	@Override
	public void liberarLocalidad(DetallesLocalidad localidad) {
		localidad.setIdSocio("");
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		localidadDAO.update(localidad);
		
	}

	@Override
	public boolean liberarAbono(String idAbono) {
		
		boolean estado = false;
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		DetallesAbono informacionAbono = abonoDAO.queryById(idAbono);
		
		String idLocalidad = informacionAbono.getIdLocalidad();
		
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
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
		
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		
		DetallesLocalidad informacionLocalidad = localidadDAO.queryById(idLocalidad);
		
		if (informacionLocalidad.getIdSocio() == "" ) {
			informacionLocalidad.setIdSocio(abono.getIdAbono());
			estado = !estado;
		}
		
		return estado;
	}
	
	@Override
	public DetallesLocalidad getDetallesLocalidad(String idLocalidad) {
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
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
		
		EspacioComercialDAO espacioComercialDAO = new EspacioComercialDAOImpFicheros();
		
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
		ContratoDAO contratoDAO = new ContratoDAOImpFicheros();
		
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
		ContratoDAO contratoDAO = new ContratoDAOImpFicheros();
		
		DetallesContrato contratoACancelar = contratoDAO.queryById(idContrato);
		
		if (contratoACancelar != null) {
			contratoACancelar.setFechaRestriccion(new Date());
			
			contratoDAO.update(contratoACancelar);

		}
	
		
	}

	@Override
	public void liberarEspacioComercial(String idEspacioComercial) {
		
		EspacioComercialDAO espacioComercialDAO = new EspacioComercialDAOImpFicheros();
		DetallesEspacioComercial espacioComercialLiberar = espacioComercialDAO.queryById(idEspacioComercial);
		espacioComercialLiberar.setArrendado("");
		espacioComercialDAO.update(espacioComercialLiberar);
		
	}

	@Override
	public ArrayList<DetallesDespacho> getDespachosLibresEstadio() {
		
		DespachoDAO despachoDAO = new DespachoDAOImpFicheros();
		
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
		
		DespachoDAO despachoDAO = new DespachoDAOImpFicheros();
		
		if (!despachoDAO.update(despacho)) {
			despachoDAO.insert(despacho);
		} 
	}

	@Override
	public ArrayList<DetallesEspacioComercial> obtenerListadoEspacios() {
		
		EspacioComercialDAO espacioComercialDAO = new EspacioComercialDAOImpFicheros();
		HashMap<String, DetallesEspacioComercial> listadoespacioComerciales = espacioComercialDAO.queryAll();
		Collection<DetallesEspacioComercial> espaciosComerciales = listadoespacioComerciales.values();
		
		ArrayList<DetallesEspacioComercial> listadoEspaciosComerciales = new ArrayList<> (espaciosComerciales);
		
		return listadoEspaciosComerciales;
	}

	@Override
	public DetallesEspacioComercial getEspacioComercial(String idEspacioComercial) {
		
		EspacioComercialDAO espacioComercialDAO = new EspacioComercialDAOImpFicheros();
		DetallesEspacioComercial infoEspacioComercialDeseado = espacioComercialDAO.queryById(idEspacioComercial);
		return infoEspacioComercialDeseado;
	}



}
