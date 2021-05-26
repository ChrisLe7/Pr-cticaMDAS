package es.uco.mdas.datos;

import java.util.HashMap;

import es.uco.mdas.business.socio.DetallesAbono;

public interface AbonoDAO {
	public HashMap <String, DetallesAbono> queryAbonos();
	
	public DetallesAbono queryAbono(String idSocio);
	
	public boolean updateAbono(DetallesAbono abono);
	
	public boolean insertAbono(DetallesAbono abono);
	
	public boolean deleteAbono(String idabono);
}
