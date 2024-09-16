package logica;

public class MemoriaRam extends ComponenteOrdenador {
	private boolean espacio; // MB true, GB false 
	private double cantEspacio;
	private String tipoDeMemoria;

	public MemoriaRam(int cantDisponible, String numSerie, String marca, String modelo, float precio,  boolean espacio, double cantEspacio, String tipoDeMemoria) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setCantEspacio(cantEspacio);
		setEspacio(espacio);
		setTipoDeMemoria(tipoDeMemoria);
	}

	public double getCantEspacio() {
		return cantEspacio;
	}
	public void setCantEspacio(double cantEspacio2) {
		if(isEspacio() == true) {
			if(cantEspacio2 >= 4096 && cantEspacio2 <= 131072) {
				this.cantEspacio = cantEspacio2;
			}
		}
		else if(isEspacio() == false) {
			if(cantEspacio2 >= 4 && cantEspacio2 <= 128) {
				this.cantEspacio = cantEspacio2;
			}
		}
		else {
			throw new IllegalArgumentException("La cantidad de espacio de una memoria RAM debe de estar entre 4096-131072 MB  lo que equivale a 4-128 GB");
		}
	}
	public String getTipoDeMemoria() {
		return tipoDeMemoria;
	}
	public void setTipoDeMemoria(String tipoDeMemoria) {
		if(tipoDeMemoria.equalsIgnoreCase("DDR-3") || tipoDeMemoria.equalsIgnoreCase("DDR-4")|| tipoDeMemoria.equalsIgnoreCase("DDR-5")) {
			this.tipoDeMemoria = tipoDeMemoria;
		}
		else {
			throw new IllegalArgumentException("El tipo de memoria debe de ser de tipo (DDR-3, DDR-4, DDR-5)");
		}
	}

	public boolean isEspacio() {
		return espacio;
	}

	public void setEspacio(boolean espacio) {
		this.espacio = espacio;
	}
	public void setPrecio(float precio) {
		this.precio = 25.99f + precio;
	}


}
