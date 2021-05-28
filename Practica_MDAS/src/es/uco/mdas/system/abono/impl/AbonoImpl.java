package es.uco.mdas.system.abono.impl;

import es.uco.mdas.system.abono.Abono;
import es.uco.mdas.business.socio.DetallesAbono;
import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.business.socio.impl.SocioMgtImpl;
import es.uco.mdas.business.socio.SocioMgt;
import es.uco.mdas.business.instalaciondeportiva.GestionarAbono;
import es.uco.mdas.business.instalaciondeportiva.impl.InstalacionDeportivaImpl;


public class AbonoImpl implements Abono {
	
	private SocioMgt socioMgt;
	private GestionarAbono abono;
	
	public AbonoImpl() {
		
		this.socioMgt = new SocioMgtImpl();
		this.abono = new InstalacionDeportivaImpl();
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
	public boolean modificarLocalidadAbono(String idAbono) {
		
		boolean estado = false;
		
		DetallesAbono abono = obtenerInformacionAbono(idAbono);
		///Liberar localidad antigua y reasignar la nueva al abonodo
		abono.setIdLocalidad(idAbono);
		
		estado = socioMgt.actualizarAbono(abono);
		
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
		
		estado = socioMgt.registrarAbono(abono);		
		
		return estado;
	}
}
