package es.uco.mdas.business.instalaciondeportiva;

import java.util.ArrayList;

public interface VentaEntrada {

	/**
	 * Vende una entrada disponible
	 * 
	 * @param entrada Entrada que se vende
	 * @return True si se vende y false en caso contrario
	 */
	public boolean venderEntrada(DetallesEntrada entrada);
	
	/**
	 * Devuelve una lista con todas las entradas disponibles para vender
	 * 
	 * @return Lista de entradas disponibles para vender
	 */
	public ArrayList<DetallesEntrada> obtenerEntradasDisponibles();
	
}
