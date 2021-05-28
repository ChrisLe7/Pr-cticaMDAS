package es.uco.mdas.system.abono.impl;

import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.socio.SocioMgt;

public class AbonoImpl implements Abono {
	
	private SocioMgt socioMgt;
	
	public AbonoImpl(SocioMgt socioMgt) {
		
		this.socioMgt = socioMgt;
	}
	
	@Override
	public DetallesAbono obtenerInformacionAbono(String idSocio) {
		
		DetallesAbono abono = new DetallesAbono("", "");
				
		abono = socioMgt.obtenerInformacionAbono(idSocio);
		
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
	public void modificarLocalidadAbono(String idAbono) {
		
		DetallesAbono abono = obtenerInformacionAbono(idAbono);
		///Liberar localidad antigua y reasignar la nueva al abonodo
		abono.setIdLocalidad(idAbono);
		
		socioMgt.actualizarAbono(abono);
	}
	
	@Override
	public void actualizarCuotaAbono(String idAbono, float nuevoPrecio) {
		
		DetallesAbono abono = obtenerInformacionAbono(idAbono);		
		
		abono.setPrecio(nuevoPrecio);
		
		socioMgt.actualizarAbono(abono);
	}
	
	@Override
	public void registrarAbono(DetallesAbono abono) {
		
		socioMgt.registrarAbono(abono);		
	}
}
