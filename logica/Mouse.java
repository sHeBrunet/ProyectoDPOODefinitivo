package logica;

public class Mouse extends ComponenteOrdenador {
	private String conectividad;

	public Mouse(int cantDisponible, String numSerie, String marca, String modelo, float precio, String conectividad) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setConectividad(conectividad);
	}
	public String getConectividad() {
		return conectividad;
	}
	public void setConectividad(String conectividad) {
		if(conectividad.equalsIgnoreCase("cable") || conectividad.equalsIgnoreCase("inal�mbrica")) {
			this.conectividad = conectividad;
		}
		else {
			throw new IllegalArgumentException("El tipo de conectividad debe de ser inal�mbrica o por cable");
		}
	}
	
	public void setPrecio(float precio) {
		this.precio = 10.99f + precio;
	}
}
