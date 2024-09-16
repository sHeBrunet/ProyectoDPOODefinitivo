package logica;

public class ComponenteOrdenador {
	protected int cantDisponible;
	protected String numSerie;
	protected String marca;
	protected String modelo;
	protected float precio;

	public ComponenteOrdenador(int cantDisponible, String numSerie, String marca, String modelo, float precio) {
		this.cantDisponible = cantDisponible;
		this.numSerie = numSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	public int getCantDisponible() {
		return cantDisponible;
	}

	public void setCantDisponible(int cantDisponible) {
		if(cantDisponible >= 0 && cantDisponible <= 1000) {
			this.cantDisponible = cantDisponible;
		}
		else {
			throw new IllegalArgumentException("La cantidad disponible debe de estar entre 0 y 1000");
		}
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		if(numSerie.length() >=  3&& numSerie.length() <= 20) {
			this.numSerie = numSerie;
		}
		else {
			throw new IllegalArgumentException("El numero de serie debe de tener entre 3 y 20 caracteres");
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca != null && marca != "") {
			this.marca = marca;
		}
		else {
			throw new IllegalArgumentException("El nombre de la marca no debe de estar vacío");
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo != null && modelo != "") {
			this.modelo = modelo;
		}
		else {
			throw new IllegalArgumentException("El nombre del modelo no debe de estar vacío");
		}
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


}
