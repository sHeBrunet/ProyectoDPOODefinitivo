package logica;

import java.util.ArrayList;

import inicializaciones.InicializacionDeDatos;

public class TarjetaMadre extends ComponenteOrdenador {
private String tipoDeConector; // Debe de coincidir con el de los microprocesadores // falta poner una relacion en el UML entre tarjetaMadre y Microprocesadores
private ArrayList<DiscoDuro> discos;
private ArrayList<MemoriaRam> memoriasR;
private Microprocesador micro;

	public TarjetaMadre(int cantDisponible, String numSerie, String marca, String modelo, float precio, String tipoDeConector) {
		super(cantDisponible, numSerie, marca, modelo, precio);
		setTipoDeConector(tipoDeConector);
		discos = new ArrayList<DiscoDuro>();
		memoriasR = new ArrayList<MemoriaRam>();
		setProcesadorCompatible(micro);
	}
	public String getTipoDeConector() {
		return tipoDeConector;
	}

	public void setTipoDeConector(String tipoDeConector) {
		boolean correcto = false;
		ArrayList<String> conectores = new ArrayList<String>();
		conectores = InicializacionDeDatos.conectores();
		for(String r: conectores) {
			if(tipoDeConector.equalsIgnoreCase(r)) {
				correcto = true;
				this.tipoDeConector = tipoDeConector;
			}
		}
		if(!correcto) {
			throw new IllegalArgumentException("El conector debe de ser  de tipo(LGA 1151, LGA1200, LGA 1700, AM4, AM3+, TR4)");
		}
		
	}
	public ArrayList<DiscoDuro> getDiscos() {
		return discos;
	}

	public ArrayList<MemoriaRam> getMemoriasR() {
		return memoriasR;
	}
	 public void agregarDiscoDuroCompatible(DiscoDuro d) {
		 if(d != null) {
		 discos.add(d); 
		 }
		 else
		 {
			 throw new IllegalArgumentException("la tarjeta madre debe de tener un disco duro compatible");
		 }
	 }
	 public void agregarMemoriaRAMCompatible(MemoriaRam m) {
		 if(m != null) {
			 memoriasR.add(m); 
			 }
			 else
			 {
				 throw new IllegalArgumentException("la tarjeta madre debe de tener una memoria RAM compatible");
			 }
		 }
	 public Microprocesador getMicro() {
			return micro;
		}
		
	 public void setProcesadorCompatible(Microprocesador micro) {
		this.micro =micro;
	 }
	
	 public void setPrecio(float precio) {
			this.precio = 55.99f + precio;
		}

}
