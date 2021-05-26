package es.uco.mdas.business.instalaciondeportiva;

import java.util.ArrayList;

public interface GestionarDespacho {

	public ArrayList<DetallesDespacho> getDespachosLibresEstadio();
	public void asignarDespachoEstadio(DetallesEstadio estadio, DetallesDespacho despacho, String idMiembro);
	
}
