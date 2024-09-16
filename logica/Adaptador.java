package logica;

public class Adaptador extends ComponenteOrdenador{

	public Adaptador(int cantDisponible, String numSerie, String marca, String modelo, float precio) {
		super(cantDisponible, numSerie, marca, modelo, precio);

	}
	
	public void setPrecio(float precio) {
		this.precio = 5.99f + precio;
	}
}
