package logica;

import java.util.ArrayList;

import inicializaciones.InicializacionDeDatos;

public class TarjetaDeVideo extends ComponenteOrdenador {
private String refrigeracion; //En celsius

	public TarjetaDeVideo(int cantDisponible, String numSerie, String marca, String modelo, float precio, String refrigeracion) {
		super(cantDisponible, numSerie, marca, modelo, precio);
	setRefrigeracion(refrigeracion);
	}
	
	public String getRefrigeracion() {
		return refrigeracion;
	}
	public void setRefrigeracion(String refrigeracion) {
		boolean correcto = false;
		ArrayList<String> refrigeraciones = new ArrayList<String>();
		refrigeraciones = InicializacionDeDatos.refrigeracion();
		for(String r: refrigeraciones) {
			if(refrigeracion.equalsIgnoreCase(r)) {
				correcto = true;
				this.refrigeracion= refrigeracion;;
			}
		}
		if(!correcto) {
			throw new IllegalArgumentException("La refrigeracion debe de ser de tipo (aire, líquido, pasivo, mixto)");
		}
	}
	
	public void setPrecio(float precio) {
		this.precio = 115.99f + precio;
	}

}
