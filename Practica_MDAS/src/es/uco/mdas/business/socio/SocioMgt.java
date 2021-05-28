package es.uco.mdas.business.socio;

import java.util.HashMap;

public interface SocioMgt {
	
	public DetallesAbono obtenerInformacionAbono(String idSocio);
	
	public boolean registrarAbono(DetallesAbono abono);
	
	public boolean renovarAbono(String idAbono );
	
	public boolean cancelarAbono(String idAbono);
	
	public boolean actualizarAbono(DetallesAbono nuevoAbono);
	
	public boolean registrarDatosCliente(DetallesCliente cliente);
	
	public boolean eliminarDatosCliente(String idSocio);
	
	public boolean asignarCategoria (DetallesSocio socio, Categoria categoria);

	public HashMap<String, DetallesSocio> getSocios();
	
	public boolean updateSocio (DetallesSocio socio);	

}
