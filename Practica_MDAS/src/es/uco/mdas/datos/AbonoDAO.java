package es.uco.mdas.datos;

import java.util.HashMap;

import es.uco.mdas.business.socio.DetallesAbono;

public interface AbonoDAO {
	public HashMap <String, DetallesAbono> querySocios();
	public boolean updateAbono(DetallesAbono abono);
	
	public boolean insertAbono(DetallesAbono abono);
	
	public boolean deleteAbono(String idabono);
}
