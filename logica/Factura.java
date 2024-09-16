package logica;

import java.time.LocalDate;
import java.util.ArrayList;


public class Factura {
	private ArrayList<ComponenteOrdenador> com;
	private ArrayList <Integer> cantidadXPieza;
	private LocalDate fecha;
	private ArrayList <Boolean> ensamblado;
	private float precioEnsamblado;

	public Factura(LocalDate fecha) {
		com = new ArrayList<>();
		cantidadXPieza = new ArrayList<>();
		ensamblado = new ArrayList<Boolean>();
		setFecha(fecha);
		setPrecioEnsamblado(precioEnsamblado);
	}


	public float getPrecioEnsamblado() {
		return precioEnsamblado;
	}


	public void setPrecioEnsamblado(float precioEnsamblado) {
	if(precioEnsamblado >= 0) {
		this.precioEnsamblado = precioEnsamblado;
	}
	else {
		throw new IllegalArgumentException("Error. El precio del ensamblado debe de ser mayor que cero si se realiza el ensamblado");
	}
	}


	public ArrayList<Boolean> getEnsamblado() {
		return ensamblado;
	}


	public void setEnsamblado(ArrayList<Boolean> ensamblado) {
		this.ensamblado = ensamblado;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<ComponenteOrdenador> getCom() {
		return com;
	}

	public void setCom(ArrayList<ComponenteOrdenador> com) {
		this.com = com;
	}
	public ArrayList<Integer> getCantidadXPieza() {
		return cantidadXPieza;
	}

	public void setCantidadXPieza(ArrayList<Integer> cantidadXPieza) {
		this.cantidadXPieza = cantidadXPieza;
	}


	public float calcularMontoXPieza(ComponenteOrdenador c) {
		float dinero = 0;
		boolean parada = false;
		for(int i = 0; i < com.size() && !parada; i++) {
			if(com.get(i).equals(c)) {
				dinero = cantidadXPieza.get(i) * com.get(i).getPrecio();
				parada = true;
				System.out.println("Componente: " + c + ", Cantidad: " + cantidadXPieza.get(i) + ", Precio: " + com.get(i).getPrecio() + ", Monto: " + dinero);
			}
		}
		return dinero;
	}
}
