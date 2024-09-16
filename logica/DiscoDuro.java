package logica;

public class DiscoDuro extends ComponenteOrdenador {
	private boolean almacenamiento; // Si es de tipo GB true y  TB false
	private double capacidad;
	private String tipoDeConexion;

	public DiscoDuro(int cantDisponible, String numSerie, String marca, String modelo, float precio, boolean almacenamiento, double capacidad, String tipoDeConexion) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setAlmacenamiento(almacenamiento);
		setCapacidad(capacidad);
		setTipoDeConexion(tipoDeConexion);
	}
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		if(isAlmacenamiento() == true) {
			if(capacidad >= 1000 && capacidad <= 20000) {
		this.capacidad = capacidad;
			}
		}
		else if(isAlmacenamiento() == false) {
			if(capacidad >= 1 && capacidad <= 20) {
				this.capacidad = capacidad;
			}
		}
			else {	
				throw new IllegalArgumentException("El almacenamiento en GB debe de estar entre 1 y 20000 y el almacenamiento en TB entre 1 y 20");
		}
	}
	public String getTipoDeConexion() {
		return tipoDeConexion;
	}
	public void setTipoDeConexion(String tipoDeConexion) {
		if(tipoDeConexion.equalsIgnoreCase("IDE") || tipoDeConexion.equalsIgnoreCase("SAS") || tipoDeConexion.equalsIgnoreCase("SATA-3")) {
		this.tipoDeConexion = tipoDeConexion;
		}
		else {
			throw new IllegalArgumentException("El tipo de conexion del disco duro debe de ser de tipo (IDE, SAS, SATA-3)");
		}
		
	}
	public boolean isAlmacenamiento() {
		return almacenamiento;
	}
	public void setAlmacenamiento(boolean almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	public void setPrecio(float precio) {
		this.precio = 20.99f + precio;
	}

}
