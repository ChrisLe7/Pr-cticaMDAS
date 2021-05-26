package es.uco.mdas.datos;

import java.util.HashMap;

import es.uco.mdas.business.socio.DetallesSocio;

public interface SocioDAO {
	
	public HashMap <String, DetallesSocio> querySocios();
	public boolean updateSocio(DetallesSocio socio);
	
	public boolean insertSocio(DetallesSocio socio);
	
	public boolean deleteSocio(String idSocio);
	

}
