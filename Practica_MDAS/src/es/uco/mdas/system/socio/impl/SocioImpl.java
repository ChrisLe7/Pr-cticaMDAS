package es.uco.mdas.system.socio.impl;

import java.util.HashMap;

import es.uco.mdas.business.socio.Categoria;
import es.uco.mdas.business.socio.DetallesCliente;
import es.uco.mdas.business.socio.DetallesSocio;
import es.uco.mdas.business.socio.SocioMgt;
import es.uco.mdas.business.socio.data.AbonoDAOImpFicheros;
import es.uco.mdas.business.socio.data.SocioDAOImpFicheros;
import es.uco.mdas.business.socio.impl.SocioMgtImpl;
import es.uco.mdas.system.socio.Socio;

public class SocioImpl implements Socio {
	
	private SocioMgt socioMgt;
	public SocioImpl() {
		this.socioMgt = new SocioMgtImpl(new AbonoDAOImpFicheros(), new SocioDAOImpFicheros());
	}

	@Override
	public DetallesSocio registrarDatosCliente(DetallesCliente cliente) {
		DetallesSocio socio = socioMgt.registrarDatosCliente(cliente);
		return socio;
	}

	@Override
	public boolean eliminarDatosCliente(String idSocio) {
		return socioMgt.eliminarDatosCliente(idSocio);
	}

	@Override
	public void asignarCategoria(DetallesSocio socio, Categoria categoria) {
		socioMgt.asignarCategoria(socio, categoria);
		
	}

	@Override
	public void comprobarTiempoVinculacion() {
		HashMap<String, DetallesSocio> socios = socioMgt.getSocios();
		
		for (String idSocio : socios.keySet()) {
			DetallesSocio socio = socios.get(idSocio);
			Categoria nuevaCategoria = comprobarTiempoVinculacion(socio);
			
			if (nuevaCategoria != socio.getCategoria()) {
				asignarCategoria(socio, nuevaCategoria);
			}
		}
	}

	@Override
	public Categoria comprobarTiempoVinculacion(DetallesSocio socio) {
		int aniosSocioOro = 65; // edad minima requerida para ser socio de oro
		int aniosSocioPlata = 25; // anios consecutivos asociado para ser socio de plata
		int aniosSocioAdulto = 18; // edad minima requerida para ser socio adulto
				
		if (socio.getEdad() >= aniosSocioOro) {
			return Categoria.Oro;
		}
				
		if (socio.getAntiguedad() >= aniosSocioPlata) {
			return Categoria.Plata;
		}
		
		if (socio.getEdad() >= aniosSocioAdulto) {
			return Categoria.Adulto;
		}
		
		return Categoria.Infantil;
	}

	@Override
	public DetallesSocio obtenerInformacionSocio(String idSocio) {
		return socioMgt.getSocio(idSocio);
	}

}
