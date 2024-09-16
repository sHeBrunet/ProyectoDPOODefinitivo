package logica;

public class Fuente extends ComponenteOrdenador {
	private String eficiencia;
	
	public Fuente(int cantDisponible, String numSerie, String marca, String modelo, float precio, String eficiencia) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setEficiencia(eficiencia);
	}

	public String getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(String eficiencia) {
		if(eficiencia.equalsIgnoreCase("80 PLUS") || eficiencia.equalsIgnoreCase("Bronze") || eficiencia.equalsIgnoreCase("Silver") || eficiencia.equalsIgnoreCase("Gold") || eficiencia.equalsIgnoreCase("Platinum")) {
			this.eficiencia  = eficiencia;
		}
		else {
			throw new IllegalArgumentException("El tipo de eficiencia debe de ser de tipo (80 PLUS, Bronze, Silver, Gold, Platinum)");
		}
	}
	public void setPrecio(float precio) {
		this.precio = 25.99f + precio;
	}

}
