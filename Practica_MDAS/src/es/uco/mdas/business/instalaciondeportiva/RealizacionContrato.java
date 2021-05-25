package es.uco.mdas.business.instalaciondeportiva;

public interface RealizacionContrato {

	public DetallesPresupuesto generarPresupuesto(DetallesEspacioComercial espacioComercial);
	public DetallesContrato realizarContrato(String idEmpresa, String cuentaBancaria, String idEstadio);
	public void asignarEspacioComercial(String idEspacioComercial, String idEmpresa);
	public DetallesContrato renovarContrato(String idContrato);
	public void cancelarContrato(String idContrato);
	public void liberarEspacioComercial(String idEspacioComercial);
	
}
