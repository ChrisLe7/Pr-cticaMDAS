package es.uco.mdas.system.abono.impl;

import java.util.ArrayList;
import java.util.Arrays;
import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.socio.impl.SocioMgtImpl;
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
		
		ArrayList <String> libres = simulacionLocalidades(); //cargo los disponibles
	
		if (libres.contains(localidadNewId)) {
			
			libres.remove(localidadNewId); //con esto indico que lo quitaria de los disponibles
			abono.setIdLocalidad(localidadNewId);
			estado = socioMgt.actualizarAbono(abono);
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
		
		boolean estado = false;
		
		ArrayList <String> libres = simulacionLocalidades(); //cargo los disponibles
						
		if (libres.contains(abono.getIdLocalidad())) {
			libres.remove(abono.getIdLocalidad()); //con esto indico que lo quitaria de los disponibles
		}
		
		estado = socioMgt.registrarAbono(abono);		
		
		return estado;
	}
	
	public ArrayList <String> simulacionLocalidades() { //simular localidades disponibles
		
		ArrayList <String> libres = new ArrayList <String>(Arrays.asList("2", "6", "7", "9", "15", "16"));
				
		return libres;
	}
}