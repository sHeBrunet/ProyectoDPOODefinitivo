package logica;

public class Teclado extends ComponenteOrdenador {
	private int retroiluminacion; // 0 si es falso, 1 si es verdadero
	public Teclado(int cantDisponible, String numSerie, String marca, String modelo, float precio, int retroiluminacion) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setRetroiluminacion(retroiluminacion);
	}
	public int getRetroiluminacion() {
		return retroiluminacion;
	}
	public boolean isRetroiluminacion() {
		boolean r = false;
		if(retroiluminacion == 1)
			r = true;
		return r;
	}
	public void setRetroiluminacion(int retroiluminacion) {
		if(retroiluminacion == 0 || retroiluminacion == 1) {
			this.retroiluminacion = retroiluminacion;
		}
		else
			throw new IllegalArgumentException("Solo se permite 0 para falso y 1 para verdadero");
	}
	public void setPrecio(float precio) {
		this.precio = 15.99f + precio;
	}
}