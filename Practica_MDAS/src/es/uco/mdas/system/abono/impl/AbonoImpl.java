package es.uco.mdas.system.abono.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.socio.impl.SocioMgtImpl;
import es.uco.mdas.datos.LocalidadDAO;
import es.uco.mdas.datos.LocalidadDAOImpFicheros;
import es.uco.mdas.business.socio.SocioMgt;
import es.uco.mdas.business.instalaciondeportiva.GestionarAbono;
import es.uco.mdas.business.instalaciondeportiva.impl.InstalacionDeportivaImpl;

public class AbonoImpl implements Abono {
	
	private SocioMgt socioMgt;
	private GestionarAbono abonoMgt;
	
	public AbonoImpl() {
		
		this.socioMgt = new SocioMgtImpl();
		this.abonoMgt = new InstalacionDeportivaImpl();
	}
	
		
	@Override
	public DetallesAbono obtenerInformacionAbono(String idSocio) {
		
		DetallesAbono abono = socioMgt.obtenerInformacionAbono(idSocio);

		return abono;
	}
	
	@Override
	public boolean renovarAbono(String idAbono) {
		
		return socioMgt.renovarAbono(idAbono);
	}
	
	@Override
	public DetallesLocalidad cancelarAbono(String idAbono) {
		
		boolean estado = false;
				
		DetallesLocalidad localidad = new DetallesLocalidad("", 0, 0, 0, "", "");
			
		estado = socioMgt.cancelarAbono(idAbono);
			
		if(estado) {
			
			return localidad;
		}
						
		return null;
	}
	
	@Override
	public boolean modificarLocalidadAbono(String idAbono, String localidadNewId) {
		
		boolean estado = false;
			
		DetallesAbono abono = obtenerInformacionAbono(idAbono);
		///Liberar localidad antigua y reasignar la nueva al abonado
		
		String localidadOldId = abono.getIdLocalidad();
		DetallesLocalidad localidadOld= abonoMgt.getDetallesLocalidad(localidadOldId);
		abonoMgt.liberarLocalidad(localidadOld);
		
		
	
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		HashMap <String, DetallesLocalidad> listadoTodasLasLocalidades = localidadDAO.queryAll();
		
		
		if (listadoTodasLasLocalidades.containsKey(localidadNewId)) {
			DetallesLocalidad localidadNew = listadoTodasLasLocalidades.get(localidadNewId);
			abonoMgt.asignarLocalidad(localidadNew, abono.getIdAbono()); //Actualizar El fichero de Localidades
			abono.setIdLocalidad(localidadNewId);
			estado = socioMgt.actualizarAbono(abono); //Actualizar el listado de Socios
		}
			
		return estado;
	}
	
	@Override
	public boolean actualizarCuotaAbono(String idAbono, float nuevoPrecio) {
		
		boolean estado = false;
		
		DetallesAbono abono = obtenerInformacionAbono(idAbono);		
		
		abono.setPrecio(nuevoPrecio);
		
		estado = socioMgt.actualizarAbono(abono);
		
		return estado;
	}
	
	@Override
	public boolean registrarAbono(DetallesAbono abono) {
		
		return socioMgt.registrarAbono(abono);
	}
	

}