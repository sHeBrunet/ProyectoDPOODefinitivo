package logica;

import java.util.ArrayList;

import inicializaciones.InicializacionDeDatos;

public class Microprocesador extends ComponenteOrdenador {
	private String tipoDeConexion;
	private double velocidadDeProcesamiento;
	private boolean velocidad; // true MHz  false GHz.
	


	public Microprocesador(int cantDisponible, String numSerie, String marca, String modelo, float precio,String tipoDeConexion,double d) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setTipoDeConexion(tipoDeConexion);
		setVelocidadDeProcesamiento(d);
		setVelocidad(velocidad);

	}

	public String getTipoDeConexion() {
		return tipoDeConexion;
	}

	public void setTipoDeConexion(String tipoDeConexion) {
		boolean correcto = false;
		ArrayList<String> conexiones = new ArrayList<String>();
		conexiones = InicializacionDeDatos.conexionesIntel();
		conexiones.addAll(InicializacionDeDatos.conexionesAMD());
		for(String r: conexiones) {
			if(tipoDeConexion.equalsIgnoreCase(r)) {
				correcto = true;
				this.tipoDeConexion = tipoDeConexion;
			}
		}
		if(!correcto) {
			throw new IllegalArgumentException("Las conexiones deben de ser tipo (LGA 1151,LGA 1200,LGA 1700,AM3,AM4,AM5,TR4).");
		}
	}

	public double getVelocidadDeProcesamiento() {
		return velocidadDeProcesamiento;
	}

	public void setVelocidadDeProcesamiento(double d) {
		if(isVelocidad() == true) {
			if(d >= 2000 && d <= 8000) {
				this.velocidadDeProcesamiento = d;
			}
		}
		else if(isVelocidad() == false) {
			if(d >= 2 && d <= 8 ) {
				this.velocidadDeProcesamiento = d;
			}
		}
	}

	public boolean isVelocidad() {
		return velocidad;
	}

	public void setVelocidad(boolean velocidad) {
		this.velocidad = velocidad;
	}

	public void setPrecio(float precio) {
		this.precio = 55.99f + precio;
	}

}
