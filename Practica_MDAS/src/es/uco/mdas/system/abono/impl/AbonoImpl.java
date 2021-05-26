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
		
				
	}
	
	@Override
	public DetallesLocalidad cancelarAbono(String idAbono) {
		
		
	}
	
	@Override
	public void modificarLocalidadAbono(String idAbono) {
		
		
		
		
	}
	
	@Override
	public void actualizarCuotaAbono(String idAbono, float nuevoPrecio) {
		
		
	}
	
	@Override
	public void registrarAbono(DetallesAbono abono) {
		
		socioMgt.registrarAbono(abono);		
	}
}
