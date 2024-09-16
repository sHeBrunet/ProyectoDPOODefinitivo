package logica;
import inicializaciones.InicializacionDeDatos;
import java.util.ArrayList;

public class Monitor extends ComponenteOrdenador {
	private String resolucion;

	public Monitor(int cantDisponible, String numSerie, String marca, String modelo, float precio, String resolucion) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setResolucion(resolucion);
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		boolean correcto = false;
		ArrayList<String> resoluciones = new ArrayList<String>();
		resoluciones = InicializacionDeDatos.resolucionVideo();
		for(String r: resoluciones) {
			if(resolucion.equalsIgnoreCase(r)) {
				correcto = true;
				this.resolucion = resolucion;
			}
		}
		if(!correcto) {
			throw new IllegalArgumentException("La resolucion debe de ser de tipo (1080p, 4k, 5k");
		}
	}
	public void setPrecio(float precio) {
		this.precio = 20.99f + precio;
	}

}
