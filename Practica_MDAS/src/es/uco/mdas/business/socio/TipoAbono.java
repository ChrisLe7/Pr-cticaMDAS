package es.uco.mdas.business.socio;

public enum TipoAbono {

	AbonoCompleto("Abono completo", 200f),
	AbonoCopa("Abono copa", 100f),
	AbonoLiga("Abono liga", 150f);
	
	public String label;
	public float value;
	
	TipoAbono(String label, float value) {
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	
	public float getValue() {
		return value;
	}
	
}
