package es.uco.mdas.business.instalaciondeportiva;

import java.util.ArrayList;

public interface GestionarEspacioComercial {

	public ArrayList<DetallesEspacioComercial> obtenerListadoEspacios();
	public DetallesEspacioComercial getEspacioComercial(String idEspacioComercial);
	
}
