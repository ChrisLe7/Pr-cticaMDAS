package es.uco.mdas.business.instalaciondeportiva.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

import es.uco.mdas.business.instalaciondeportiva.DetallesContrato;
import es.uco.mdas.business.instalaciondeportiva.DetallesEspacioComercial;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.instalaciondeportiva.DetallesPresupuesto;
import es.uco.mdas.business.instalaciondeportiva.GestionarAbono;
import es.uco.mdas.business.instalaciondeportiva.RealizacionContrato;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.datos.AbonoDAO;
import es.uco.mdas.datos.ContratoDAO;
import es.uco.mdas.datos.LocalidadDAO;

public class InstalacionDeportivaImpl implements GestionarAbono, RealizacionContrato {

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
		// TODO Auto-generated method stub
		boolean estado = false;
		AbonoDAO abonoDAO = new AbonoDAOImpFicheros();
		
		DetallesAbono informacionAbono = abonoDAO.queryAbono(idAbono);
		
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
		// TODO Auto-generated method stub
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
	public void asignarEspacioComercial(String idEspacioComercial, String idEmpresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetallesContrato renovarContrato(String idContrato) {
		ContratoDAO contratoDAO = new ContratoDAOImpFicheros();
		
		DetallesContrato contratoARenovar = contratoDAO.queryById(idContrato);
		
		Calendar fechaRenovacionContrato = contratoARenovar.getFechaRestriccion();
		int nuevaFecha = fechaRenovacionContrato.get(Calendar.YEAR) + 1;
		fechaRenovacionContrato.set(Calendar.YEAR, nuevaFecha);
		contratoARenovar.setFechaRestriccion(fechaRenovacionContrato);
		
		contratoDAO.update(contratoARenovar);
		return contratoARenovar;
	}

	@Override //PODRIA DEVOLVER UN BOOLEANO
	public void cancelarContrato(String idContrato) {
		ContratoDAO contratoDAO = new ContratoDAOImpFicheros();
		
		DetallesContrato contratoACancelar = contratoDAO.queryById(idContrato);
		
		if (contratoACancelar != null ) {
			Calendar fechaCancelacion = Calendar.getInstance();
			contratoACancelar.setFechaRestriccion(fechaCancelacion);
			
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

}
