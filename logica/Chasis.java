package logica;

public class Chasis extends ComponenteOrdenador {
	private String material;

	public Chasis(int cantDisponible, String numSerie, String marca, String modelo, float precio, String material) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setMaterial(material);
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		if(material != null && material != "") {
			this.material = material;
		}
		else {
			throw new IllegalArgumentException("El nombre del material no debe de estar vacío");
		}
	}
	
	public void setPrecio(float precio) {
		this.precio = 40.99f + precio;
	}


}
