package logica;

import java.util.ArrayList;
import java.util.Random;



public class TiendaDeComputadoras {
	private String nombre;
	private String ID;
	private String direccion;
	private String telefono;
	private Gerente gerente;


	private static TiendaDeComputadoras instancia;
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<ComponenteOrdenador> componentes;
	private ArrayList<Factura> facturas;

	public TiendaDeComputadoras() {
		trabajadores = new ArrayList<>();
		componentes = new ArrayList<>();
		facturas = new ArrayList<>();
	}

	public static TiendaDeComputadoras getInstancia() {
		if(instancia == null) {
			instancia = new TiendaDeComputadoras();
		}
		return instancia;
	}

	public int getCantTrabajadores() {
		return trabajadores.size();
	}
	public int getCantComponenetes() {
		return componentes.size();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Trabajador> getTrabajadores() {
		return (ArrayList<Trabajador>) trabajadores.clone();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ComponenteOrdenador> getComponentes(){
		return (ArrayList<ComponenteOrdenador>) componentes.clone();
	}

	public int buscarTrabajador(String ci){
		int pos = -1;
		int i = 0;
		boolean found = false;
		while (i < trabajadores.size() && !found){
			if (trabajadores.get(i).getCI() == ci) {
				pos = i;
				found = true;
			} else
				i++;
		}
		return pos;		
	}
	public boolean agregarT(ArrayList<Trabajador> trabaj) {
		boolean act = false;
		if(!trabaj.isEmpty()) {
			for(Trabajador t: trabaj) {
				trabajadores.add(t);
				act = true;
			}
		}
		return act;
	}
	public boolean encontCI(String ci, ArrayList<Trabajador> trabaj) {
		boolean devolver = false;
		boolean parada = false;
		for(int i = 0; i < trabajadores.size() && !parada ; i++) {
			if(trabajadores.get(i).getCI().equals(ci)) {
				devolver = true; 
				parada = true;
			}
		}
		if(!parada) {
			for(int j = 0; j < trabaj.size() && !parada; j++) {
				if(trabaj.get(j).getCI().equals(ci)) {
					devolver = true; 
					parada = true;
				}
			}
		}
		return devolver;
	}
	public boolean agregarTrabajador(Trabajador trabajador){
		boolean agregado = true;
		if(trabajador == null || buscarTrabajador(trabajador.getCI()) != -1){
			agregado = false;
		}
		else{			
			trabajadores.add(trabajador);
			agregado = true;
		}
		return agregado;
	}

	public boolean agregarProducto(ArrayList<ComponenteOrdenador> piezasAgregadas) {
		int j = 0;
		boolean act = false;
		boolean stop = false;
		if(!piezasAgregadas.isEmpty()) {
			act = true;
			for(int i = 0; i < componentes.size() && !piezasAgregadas.isEmpty(); i++) {
				while(j < piezasAgregadas.size() && !stop) {
					if(componentes.get(i).getMarca().equalsIgnoreCase(piezasAgregadas.get(j).getMarca())) {
						if(componentes.get(i).getModelo().equalsIgnoreCase(piezasAgregadas.get(j).getModelo())) {
							if(componentes.get(i).getNumSerie().equalsIgnoreCase(piezasAgregadas.get(j).getNumSerie())) {
								stop = true;
								int cantidadActual = componentes.get(i).getCantDisponible();
								int cantidadAgregada = piezasAgregadas.get(j).getCantDisponible();
								componentes.get(i).setCantDisponible(cantidadActual + cantidadAgregada);
								piezasAgregadas.remove(j);
							}
							else 
								j++;
						}
						else 
							j++;
					}
					else 
						j++;
				}
				j = 0;
				stop = false;
			}
			if(!piezasAgregadas.isEmpty()) {
				for(ComponenteOrdenador p : piezasAgregadas) {
					componentes.add(p);
				}
			}
		}
		return act;
	}

	/*public boolean agregarP(ComponenteOrdenador c, ArrayList<ComponenteOrdenador> piezasAgregadas) {
		boolean act = false;
		boolean stop = false;
		int j = 1;
		if(!piezasAgregadas.isEmpty()) {
			for(int i = 0; i < piezasAgregadas.size() && !stop; i++) {
				while(j < piezasAgregadas.size() && !stop) {
					if(piezasAgregadas.get(i).getMarca().equalsIgnoreCase(c.getMarca())) {
						if(piezasAgregadas.get(i).getModelo().equalsIgnoreCase(c.getModelo())) {
							if(piezasAgregadas.get(i).getNumSerie().equalsIgnoreCase(c.getNumSerie())) {
								act = true;
								stop = true;
								int cantidadActual = piezasAgregadas.get(i).getCantDisponible();
								piezasAgregadas.get(i).setCantDisponible(cantidadActual + c.getCantDisponible());
							}
							else
								j++;
						}
						else
							j++;
					}
					else
						j++;
				}
				j = 1;
			}
		}
		return act;
	}*/

	public int getUltimoNoTrabajador() {
		return trabajadores.size();
	}

	public void eliminarTrabajador(int posicion, Trabajador trab){
		if(posicion >= 0 && posicion < trabajadores.size()) {
			for(Trabajador t: trabajadores)
				if(t.equals(trab)) {
					trabajadores.remove(trab);
				}
		}

	}

	public void actualizarTrabajador(ArrayList<Trabajador> t) {
		for(Trabajador trabajador: trabajadores) {
			for(Trabajador tra: t) {
				if(!t.contains(trabajador)) {
					trabajadores.remove(trabajador);
				}
			}
		}
	}

	public void eliminarTrabajador1(int posicion){
		if(posicion >= 0 && posicion < trabajadores.size()) {
			trabajadores.remove(posicion);
		}
	}
	public int eliminarTrabajadores(ArrayList <String> trabAElim){
		int count = 0; int i = 0; int j = 0;
		boolean stop = false;
		while(i < trabajadores.size() && !trabAElim.isEmpty()) {
			while(j < trabAElim.size() && !stop) {
				if(trabajadores.get(i).getCI().equalsIgnoreCase(trabAElim.get(j))) {
					trabajadores.remove(i);
					stop = true;
					count++;
					trabAElim.remove(j);
				} else 
					j++;
			}
			if(!stop)
				i++;
			j = 0;
			stop = false;
		}
		return count;
	}


	public int hallarGerentes(ArrayList <String> eliminados) {
		int count = 0;
		for(Trabajador t: trabajadores) {
			if(t instanceof Gerente) {
				for(int i = 0; i < eliminados.size(); i++) {
					if(t.getCI().equals(eliminados.get(i)))
						count++;
				}
			}
		}
		return getGerentes().size() - count;
	}

	public int eliminarPiezas(ArrayList <String> piezasAElim) {
		int count = 0; int i = 0; int j = 0;
		boolean stop = false;
		while(i < componentes.size() && !piezasAElim.isEmpty()) {
			while(j < piezasAElim.size() && !stop) {
				if(componentes.get(i).getNumSerie().equalsIgnoreCase(piezasAElim.get(j))) {
					componentes.remove(i);
					stop = true;
					count++;
					piezasAElim.remove(j);
				} else 
					j++;
			}
			if(!stop)
				i++;
			j = 0;
			stop = false;
		}
		return count;
	}
	public boolean eliminarCantPiezas(Factura f) {
		boolean eliminado = false;
		if(f != null) {
			for(int k = 0; k < componentes.size(); k++) {
				for(int i = 0; i < f.getCom().size(); i++) {
					if(componentes.get(k).equals(f.getCom().get(i))) {
						for(int j = 0; j < 1; j++) {
							if(componentes.get(k).getCantDisponible() - f.getCantidadXPieza().get(j) < 0) {
								componentes.get(k).setCantDisponible(0);
								eliminado = true;
							}
							else {
								componentes.get(k).setCantDisponible(componentes.get(k).getCantDisponible() - f.getCantidadXPieza().get(j));
								eliminado = true;
							}
						}
					}
				}
			}
		}
		return eliminado;
	}
	public void actualizarNo(ComponenteOrdenador c, int num) {
		for(ComponenteOrdenador cmp : componentes) {
			if(cmp.equals(c)) {
				cmp.setCantDisponible(cmp.getCantDisponible() + num);
			}
		}
	}
	public ArrayList<Gerente> getGerentes() {	
		ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
		for(Trabajador t : trabajadores) {
			if(t instanceof Gerente) {
				gerentes.add((Gerente) t);
			}
		}
		return gerentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null && nombre != "") {
			this.nombre = nombre;
		}
		else {
			throw new IllegalArgumentException("El nombre de la tienda no puede estar vacio");
		}	
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if(nombre != null && nombre != "") {
			this.direccion = direccion;
		}
		else {
			throw new IllegalArgumentException("La dirección de la tienda no puede estar vacio");
		}	
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void agregarFactura(Factura factura) {
		facturas.add(factura);
	}
	public boolean buscarIDE(String IDE) {
		boolean encontrada = false;
		for(Trabajador t : trabajadores) {
			if(t.getNumero().equals(IDE)) {
				encontrada = true;
			}
		}
		return encontrada;
	}

	public String generadorDeIDTrabajador(String nombre, String apellidos, String CI) {
		String ID = null;
		String name = nombre.substring(0,1);
		String ape = apellidos.substring(0,1);
		String cI = CI.substring(0,2);
		ID = name.concat(ape).concat(cI);
		boolean stop = false;
		for(int i = 0; i < trabajadores.size() && !stop; i++) {
			if(trabajadores.get(i).getNumero().equalsIgnoreCase(ID)) {
				Random rand = new Random();
				int min = 0;
				int max = 599;
				int random = rand.nextInt(max - min + 1) + min;
				stop = true;
				ID = String.valueOf(random).concat(name).concat(ape).concat(cI);
			}
		}
		return ID;
	}

	public float calcularTotalFactura() {
		float total = 0;
		if (facturas != null) {
			for (Factura f : facturas) {
				if (f != null) {
					for(int j = 0; j < f.getCom().size(); j++) {
					float monto = f.calcularMontoXPieza(f.getCom().get(j));
					System.out.println("Monto de la factura: " + monto);
					total += monto;
					}
					}else {
					System.err.println("Error: Factura nula encontrada en la lista de facturas.");
				}
			}
		} else {
			System.err.println("Error: La lista de facturas es nula.");
		}
		System.out.println("Total calculado: " + total);
		return total;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public void setComponentes(ArrayList<ComponenteOrdenador> componentes) {
		this.componentes = componentes;
	}

	public boolean agregarComponenteI(ArrayList<ComponenteOrdenador> c){
		boolean agregado = true;
		if(c.isEmpty()){
			agregado = false;
		}
		else{			
			agregado = componentes.addAll(c);
		}
		return agregado;
	}
	public boolean agregarComponente(ComponenteOrdenador c){
		boolean agregado = true;
		if(c == null){
			agregado = false;
		}
		else{			
			agregado = componentes.add(c);
		}
		return agregado;
	}
	public void actualizarCantidadComponente(ComponenteOrdenador c, int cantidad) {
		for(ComponenteOrdenador cmp : componentes) {
			if(cmp.equals(c)) {
				cmp.setCantDisponible(cmp.getCantDisponible() - cantidad);
			}
		}

	}
	public void actualizarCantidadComponenteAgregar(ComponenteOrdenador c, int cantidad) {
		for(ComponenteOrdenador cmp : componentes) {
			if(cmp.equals(c)) {
				cmp.setCantDisponible(cmp.getCantDisponible() + cantidad);
			}
		}

	}

	/*public void actualizarCant(ArrayList <Integer> cantidades, ArrayList <ComponenteOrdenador> comp) {
		int i = 0;
		while(i < componentes.size() && !comp.isEmpty()) {
			for(int j = 0; j < comp.size(); j++) {
				if(componentes.get(i).getNumSerie().equalsIgnoreCase(comp.get(j).getNumSerie())) {
					componentes.get(i).setCantDisponible(componentes.get(i).cantDisponible + cantidades.get(j));
				}
			}
			i++;
		}
	}*/

	public ComponenteOrdenador buscarComponente(String numSerie) {
		ComponenteOrdenador comp = null;
		boolean stop = false;
		for(int i = 0; i < componentes.size() && !stop; i++) {
			if(componentes.get(i).getNumSerie().equals(numSerie))
				comp = componentes.get(i);
		}
		return comp;	
	}

	public float obtenerPrecio(String numSerie) {
		float precio = 0;
		ComponenteOrdenador c = buscarComponente(numSerie);
		if(c != null) {
			precio = c.getPrecio();
		}
		return precio;
	}
	/*******************************Teclado***********************************************/
	public ArrayList<Teclado> encontrarModeloTeclado(String componenteNombre, String marca, String retroiluminacion) {
		ArrayList<Teclado> teclado = new ArrayList<>();
		boolean r = false;
		if (retroiluminacion.equals("Sí")) {
			r = true;
		}
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Teclado) {
					if (c.getMarca().equals(marca)) {
						if (((Teclado) c).isRetroiluminacion() == r) {
							teclado.add((Teclado) c); 
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}

		return teclado;
	}
	public ArrayList<String> modelo(String componenteNombre, String marca, String retroiluminacion){
		ArrayList<Teclado> t = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		t = encontrarModeloTeclado(componenteNombre, marca, retroiluminacion);
		for(int i = 0; i < t.size(); i++) {
			if(!m.contains(t.get(i).getModelo())) {
				m.add(t.get(i).getModelo());
			}

		}
		return m;
	}
	public Teclado encontTeclado(String componenteNombre, String marca, String retroiluminacion, String modelo) {
		ArrayList<Teclado> teclado = new ArrayList<>();
		Teclado t = null;
		boolean parada = false;
		teclado = encontrarModeloTeclado(componenteNombre, marca, retroiluminacion);
		for(int i = 0; i < teclado.size() && !parada ; i++) {
			if(teclado.get(i).getModelo().equals(modelo)) {
				t = teclado.get(i);
				parada = true;
			}
		}
		return t;
	}
	/***********************************Adaptador******************************************************/
	public ArrayList<Adaptador> encontrarModeloAdaptador(String componenteNombre, String marca) {
		ArrayList<Adaptador> adap = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Adaptador) {
					if (c.getMarca().equals(marca)) {
						adap.add((Adaptador) c);

					}
				}
			}
		}
		return adap;
	}
	public ArrayList<String> modeloAdaptador(String componenteNombre, String marca){
		ArrayList<Adaptador> t = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		t = encontrarModeloAdaptador(componenteNombre, marca);
		for(int i = 0; i < t.size(); i++) {
			if(!m.contains(t.get(i).getModelo())) {
				m.add(t.get(i).getModelo());
			}

		}
		return m;
	}
	public Adaptador encontAdaptador(String componenteNombre, String marca, String modelo) {
		ArrayList<Adaptador> adaptador = new ArrayList<>();
		Adaptador a = null;
		boolean parada = false;
		adaptador = encontrarModeloAdaptador(componenteNombre, marca);
		for(int i = 0; i < adaptador.size() && !parada ; i++) {
			if(adaptador.get(i).getModelo().equals(modelo)) {
				a = adaptador.get(i);
				parada = true;
			}
		}
		return a;
	}
	/**************************************Bocina***************************************************/
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<String> modeloBocina(String nombre, String marca, String conectividad) {
		ArrayList<Bocina> b = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		b = encontrarModeloBocina(nombre, marca, conectividad);
		for(int i = 0; i < b.size(); i++) {
			if(!m.contains(b.get(i).getModelo())) {
				m.add(b.get(i).getModelo());
			}

		}
		return m;
	}

	private ArrayList<Bocina> encontrarModeloBocina(String nombre2, String marca, String conectividad) {
		ArrayList<Bocina> bocina= new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Bocina) {
					if (c.getMarca().equals(marca)) {
						if (((Bocina) c).getConectividad().equals(conectividad)) {
							bocina.add((Bocina) c); 
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}

		return bocina;
	}
	public Bocina encontBocina(String componenteNombre, String marca, String conectividad, String modelo) {
		ArrayList<Bocina> bocina = new ArrayList<>();
		Bocina t = null;
		boolean parada = false;
		bocina = encontrarModeloBocina(componenteNombre, marca, conectividad);
		for(int i = 0; i < bocina.size() && !parada ; i++) {
			if(bocina.get(i).getModelo().equals(modelo)) {
				t = bocina.get(i);
				parada = true;
			}
		}
		return t;
	}
	/*************************************Chasis************************************************/
	public ArrayList<String> modeloChasis(String nombre, String marca, String material) {
		ArrayList<Chasis> c = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		c = encontrarModeloChasis(nombre, marca, material);
		for(int i = 0; i < c.size(); i++) {
			if(!m.contains(c.get(i).getModelo())) {
				m.add(c.get(i).getModelo());
			}

		}
		return m;
	}

	private ArrayList<Chasis> encontrarModeloChasis(String nombre2, String marca, String material) {
		ArrayList<Chasis> chasis = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Chasis) {
					if (c.getMarca().equals(marca)) {
						if (((Chasis) c).getMaterial().equals(material)) {
							chasis.add((Chasis) c); 
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}

		return chasis;
	}
	public Chasis encontChasis(String componenteNombre, String marca, String material, String modelo) {
		ArrayList<Chasis> chasis = new ArrayList<>();
		Chasis c = null;
		boolean parada = false;
		chasis = encontrarModeloChasis(componenteNombre, marca, material);
		for(int i = 0; i < chasis.size() && !parada ; i++) {
			if(chasis.get(i).getModelo().equals(modelo)) {
				c = chasis.get(i);
				parada = true;
			}
		}
		return c;
	}
	/*************************************Monitor***********************************************/
	public ArrayList<String> modeloMonitor(String nombre, String marca, String resolucion) {
		ArrayList<Monitor> monitor= new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		monitor = encontrarModeloMonitor(nombre, marca, resolucion);
		for(int i = 0; i < monitor.size(); i++) {
			if(!m.contains(monitor.get(i).getModelo())) {
				m.add(monitor.get(i).getModelo());
			}

		}
		return m;
	}

	private ArrayList<Monitor> encontrarModeloMonitor(String nombre2, String marca, String resolucion) {
		ArrayList<Monitor> monitores = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Monitor) {
					if (c.getMarca().equals(marca)) {
						if (((Monitor) c).getResolucion().equals(resolucion)) {
							monitores.add((Monitor) c); 
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}

		return monitores;
	}
	public Monitor encontMonitor(String componenteNombre, String marca, String resolucion, String modelo) {
		ArrayList<Monitor> monitores = new ArrayList<>();
		Monitor m = null;
		boolean parada = false;
		monitores = encontrarModeloMonitor(componenteNombre, marca, resolucion);
		for(int i = 0; i < monitores.size() && !parada ; i++) {
			if(monitores.get(i).getModelo().equals(modelo)) {
				m = monitores.get(i);
				parada = true;
			}
		}
		return m;
	}
	/**********************************Tarjeta de Video*************************************************/
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<String> modeloTarjetaVideo(String nombre, String marca, String refrigeracion) {
		ArrayList<TarjetaDeVideo> tarjetaVideo = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		tarjetaVideo = encontrarModeloTarjetaVideo(nombre, marca, refrigeracion);
		for(int i = 0; i < tarjetaVideo.size(); i++) {
			if(!m.contains(tarjetaVideo.get(i).getModelo())) {
				m.add(tarjetaVideo.get(i).getModelo());
			}

		}
		return m;
	}
	private ArrayList<TarjetaDeVideo> encontrarModeloTarjetaVideo(String nombre2, String marca, String refrigeracion) {
		ArrayList<TarjetaDeVideo> tarjetasVideo = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof TarjetaDeVideo) {
					if (c.getMarca().equals(marca)) {
						if (((TarjetaDeVideo) c).getRefrigeracion().equals(refrigeracion)) {
							tarjetasVideo.add((TarjetaDeVideo) c); 
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}

		return tarjetasVideo;
	}
	public TarjetaDeVideo encontTarjetaVideo(String componenteNombre, String marca, String refrigeracion, String modelo) {
		ArrayList<TarjetaDeVideo> tarjetasV = new ArrayList<>();
		TarjetaDeVideo t = null;
		boolean parada = false;
		tarjetasV = encontrarModeloTarjetaVideo(componenteNombre, marca, refrigeracion);
		for(int i = 0; i < tarjetasV.size() && !parada ; i++) {
			if(tarjetasV.get(i).getModelo().equals(modelo)) {
				t = tarjetasV.get(i);
				parada = true;
			}
		}
		return t;
	}
	/***************************************Mouse********************************************/
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<String> modeloMouse(String nombre, String marca, String conectividad) {
		ArrayList<Mouse> b = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		b = encontrarModeloMouse(nombre, marca, conectividad);
		for(int i = 0; i < b.size(); i++) {
			if(!m.contains(b.get(i).getModelo())) {
				m.add(b.get(i).getModelo());
			}

		}
		return m;
	}

	private ArrayList<Mouse> encontrarModeloMouse(String nombre2, String marca, String conectividad) {
		ArrayList<Mouse> raton = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Mouse) {
					if (c.getMarca().equals(marca)) {
						if (((Mouse) c).getConectividad().equals(conectividad)) {
							raton.add((Mouse)c); 
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}

		return raton;
	}
	public Mouse encontMouse(String componenteNombre, String marca, String conectividad, String modelo) {
		ArrayList<Mouse> raton = new ArrayList<>();
		Mouse t = null;
		boolean parada = false;
		raton = encontrarModeloMouse(componenteNombre, marca, conectividad);
		for(int i = 0; i < raton.size() && !parada ; i++) {
			if(raton.get(i).getModelo().equals(modelo)) {
				t = raton .get(i);
				parada = true;
			}
		}
		return t;
	}
	/********************************************Fuente**************************************/
	public ArrayList<String> modeloFuente(String nombre, String marca, String eficiencia) {
		ArrayList<Fuente> b = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		b = encontrarModeloFuente(nombre, marca, eficiencia);
		for(int i = 0; i < b.size(); i++) {
			if(!m.contains(b.get(i).getModelo())) {
				m.add(b.get(i).getModelo());
			}

		}
		return m;
	}
	public Fuente encontFuente(String componenteNombre, String marca, String eficiencia, String modelo) {
		ArrayList<Fuente> fuente = new ArrayList<>();
		Fuente f = null;
		boolean parada = false;
		fuente = encontrarModeloFuente(componenteNombre, marca, eficiencia);
		for(int i = 0; i < fuente.size() && !parada ; i++) {
			if(fuente.get(i).getModelo().equals(modelo)) {
				f = fuente .get(i);
				parada = true;
			}
		}
		return f;
	}

	public ArrayList<Fuente> encontrarModeloFuente(String componenteNombre, String marca, String eficiencia) {
		ArrayList<Fuente> f = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Fuente) {
					if (c.getMarca().equals(marca)) {
						if (((Fuente) c).getEficiencia().equals(eficiencia)) {
							f.add((Fuente)c); 
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}

		return f;
	}

	/********************************************Microprocesador**************************************/
	public ArrayList<String> modeloMicroprocesador(String nombre, String marca, String tipoDeConexion, String combo3) {
		ArrayList<Microprocesador> b = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		b = encontrarModeloMicroprocesador(nombre, marca, tipoDeConexion, combo3);
		for(int i = 0; i < b.size(); i++) {
			if(!m.contains(b.get(i).getModelo())) {
				m.add(b.get(i).getModelo());
			}

		}
		return m;
	}

	private ArrayList<Microprocesador> encontrarModeloMicroprocesador(String nombre, String marca,
			String tipoDeConexion, String velocidad) {
		float velocidad1 = Integer.parseInt(velocidad);
		ArrayList<Microprocesador> f = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof Microprocesador) {
					if (c.getMarca().equals(marca)) {
						if (((Microprocesador) c).getTipoDeConexion().equals(tipoDeConexion)) {
							if(((Microprocesador) c).getVelocidadDeProcesamiento() == velocidad1) {
								f.add((Microprocesador) c);
							}
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}
		return f;
	}

	public Microprocesador encontMicro(String componenteNombre, String marca, String tipoDeConexion, String velocidad, String modelo) {
		ArrayList<Microprocesador> micro = new ArrayList<>();
		Microprocesador m = null;
		boolean parada = false;
		micro = encontrarModeloMicroprocesador(componenteNombre, marca, tipoDeConexion, velocidad);
		for(int i = 0; i < micro.size() && !parada ; i++) {
			if(micro.get(i).getModelo().equals(modelo)) {
				m = micro.get(i);
				parada = true;
			}
		}
		return m;
	}
	/********************************************Disco Duro**************************************/
	public ArrayList<String> modeloDiscoDuro(String nombre, String marca, String capacidad, String conexion) {
		ArrayList<DiscoDuro> b = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		b = encontrarModeloDiscoDuro(nombre, marca, capacidad, conexion);
		for(int i = 0; i < b.size(); i++) {
			if(!m.contains(b.get(i).getModelo())) {
				m.add(b.get(i).getModelo());
			}

		}
		return m;
	}

	private ArrayList<DiscoDuro> encontrarModeloDiscoDuro(String nombre, String marca,
			String capacidad, String conexion) {
		float capacidad1 = Integer.parseInt(capacidad);
		ArrayList<DiscoDuro> f = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof DiscoDuro) {
					if (c.getMarca().equals(marca)) {
						if (((DiscoDuro) c).getTipoDeConexion().equals(conexion)) {
							if(((DiscoDuro) c).getCapacidad() == capacidad1) {
								f.add((DiscoDuro) c);
							}
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}
		return f;
	}

	public DiscoDuro encontDiscoDuro(String componenteNombre, String marca, String capacidad, String conexion, String modelo) {
		ArrayList<DiscoDuro> discoD = new ArrayList<>();
		DiscoDuro m = null;
		boolean parada = false;
		discoD = encontrarModeloDiscoDuro(componenteNombre, marca, capacidad, conexion);
		for(int i = 0; i <discoD.size() && !parada ; i++) {
			if(discoD.get(i).getModelo().equals(modelo)) {
				m = discoD.get(i);
				parada = true;
			}
		}
		return m;
	}
	/************************************************RAM************************************************/

	public MemoriaRam encontMemoriaRAM(String componenteNombre, String marca, String capacidad, String memoriaTipo,
			String modelo) {

		ArrayList<MemoriaRam> memoriaRAM = new ArrayList<>();
		MemoriaRam m = null;
		boolean parada = false;
		memoriaRAM = encontrarModeloMemoriaRam(componenteNombre, marca, capacidad, memoriaTipo);
		for(int i = 0; i <memoriaRAM.size() && !parada ; i++) {
			if(memoriaRAM.get(i).getModelo().equals(modelo)) {
				m = memoriaRAM.get(i);
				parada = true;
			}
		}
		return m;
	}
	public ArrayList<String> modeloMemoriaRam(String nombre, String marca, String capacidad, String memoriaTipo) {
		ArrayList<MemoriaRam> b = new ArrayList<>();
		ArrayList<String> m = new ArrayList<String>();
		b = encontrarModeloMemoriaRam(nombre, marca, capacidad, memoriaTipo);
		for(int i = 0; i < b.size(); i++) {
			if(!m.contains(b.get(i).getModelo())) {
				m.add(b.get(i).getModelo());
			}

		}
		return m;
	}

	private  ArrayList<MemoriaRam> encontrarModeloMemoriaRam(String nombre, String marca,
			String capacidad, String memoriaTipo) {
		float capacidad1 = Integer.parseInt(capacidad);
		ArrayList<MemoriaRam> f = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof MemoriaRam) {
					if (c.getMarca().equals(marca)) {
						if (((MemoriaRam) c).getTipoDeMemoria().equals(memoriaTipo)) {
							if(((MemoriaRam) c).getCantEspacio() == capacidad1) {
								f.add((MemoriaRam) c);
							}
						}
					}
				}
			}
		} else {
			System.out.println("La lista de componentes es null");
		}
		return f;
	}


	/************************************************Tarjeta Madre************************************************/
	public ArrayList<TarjetaMadre> modeloTarjetaMadre(String string, String marca, String conector) {
		ArrayList<TarjetaMadre> f = new ArrayList<>();
		if (componentes != null) {
			for (ComponenteOrdenador c : componentes) {
				if (c instanceof TarjetaMadre) {
					if (c.getMarca().equals(marca)) {
						if (((TarjetaMadre) c).getTipoDeConector().equals(conector)) {
							f.add((TarjetaMadre) c);
						}
					}
				}
			}
		}
		return f;
	}

	public TarjetaMadre encontComponente(String marca, String conector, String componente, String modelo) {
		ArrayList<TarjetaMadre> f = new ArrayList<>();
		TarjetaMadre TM = null;
		f = modeloTarjetaMadre("Tarjeta Madre", marca, conector);
		for(int i = 0; i< f.size(); i++) {
			if(f.get(i).getModelo().equals(modelo)) {
				TM = (TarjetaMadre) f.get(i);
			}
		}
		return TM;
	}

	public float obtenerPrecioComp(ComponenteOrdenador c, int compSelecc, int marcaSelecc, int modeloSelecc, int atrib1Selecc, int atrib2Selecc) {
		float precio = 0;
		switch(compSelecc) {
		case 0:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);
				((Adaptador)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 5.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);
			}
			break;
		case 1:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				((Bocina)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 14.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
			}
			break;
		case 2:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				((Chasis)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 40.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
			}
			break;
		case 3:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				precio = obtenerPrecioAtributo2(precio, atrib2Selecc);
				((DiscoDuro)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 20.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				precio = obtenerPrecioAtributo2(precio, atrib2Selecc);
			}
			break;
		case 4:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				((Fuente)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 25.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
			}
			break;
		case 5:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				precio = obtenerPrecioAtributo2(precio, atrib2Selecc);
				((Microprocesador)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 55.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				precio = obtenerPrecioAtributo2(precio, atrib2Selecc);
			}
			break;
		case 6:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				precio = obtenerPrecioAtributo2(precio, atrib2Selecc);
				((MemoriaRam)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 25.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				precio = obtenerPrecioAtributo2(precio, atrib2Selecc);
			}
			break;
		case 7:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				((Monitor)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 20.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
			}
			break;
		case 8:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				((Mouse)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 10.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
			}
			break;
		case 9:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				((TarjetaMadre)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 55.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
			}
			break;
		case 10:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
				((TarjetaDeVideo)c).setPrecio(precio);
				precio = c.getPrecio();
			}
			else {
				precio = 115.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				precio = obtenerPrecioAtributo(precio, atrib1Selecc);
			}
			break;
		case 11:
			if(c != null) {
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				if(atrib1Selecc == 1) {
					precio += 15;
				}
				((Teclado)c).setPrecio(precio);
				precio = c.getPrecio();
			} 
			else {
				precio = 15.99f;
				precio = obtenerPrecioMarca(precio, marcaSelecc);
				precio = obtenerPrecioModelo(precio, modeloSelecc);	
				if(atrib1Selecc == 1) {
					precio += 15;
				}
			}
			break;
		}		
		return precio;
	}

	private float obtenerPrecioMarca(float precio, int marcaSelecc) {
		switch(marcaSelecc) {
		case 0:
			precio += 4;
			break;
		case 1:
			precio += 8;
			break;
		case 2: 
			precio += 12;
			break;
		case 3:
			precio += 16;
			break;
		case 4:
			precio += 20;
			break;
		}
		return precio;
	}

	private float obtenerPrecioModelo(float precio, int modeloSelecc) {
		switch(modeloSelecc) {
		case 0:
			precio += 3;
			break;
		case 1:
			precio += 6;
			break;
		case 2: 
			precio += 9;
			break;
		case 3:
			precio += 12;
			break;
		case 4:
			precio += 15;
			break;
		}
		return precio;
	}

	private float obtenerPrecioAtributo(float precio, int atribSelecc) {
		switch(atribSelecc) {
		case 0:
			precio += 10;
			break;
		case 1:
			precio += 15;
			break;
		case 2: 
			precio += 20;
			break;
		case 3:
			precio += 25;
			break;
		case 4:
			precio += 30;
			break;
		case 5:
			precio += 35;
			break;
		case 6:
			precio += 40;
			break;
		case 7:
			precio += 45;
			break;
		}
		return precio;
	}

	private float obtenerPrecioAtributo2(float precio, int atribSelecc) {
		switch(atribSelecc) {
		case 0:
			precio += 2;
			break;
		case 1:
			precio += 4;
			break;
		case 2: 
			precio += 6;
			break;
		case 3:
			precio += 8;
			break;
		case 4:
			precio += 10;
			break;
		case 5:
			precio += 12;
			break;
		case 6: 
			precio += 14;
			break;
		case 7:
			precio += 16;
			break;
		}
		return precio;
	}

	public ArrayList<ComponenteOrdenador> PiezasMasCaras(){
		ArrayList<ComponenteOrdenador>PiezasMasCaras = new ArrayList<>();
		float mayor = Float.MIN_VALUE;
		for(ComponenteOrdenador p : componentes) {
			if(p.getPrecio()> mayor) {
				mayor = p.getPrecio();
				PiezasMasCaras.clear();
				PiezasMasCaras.add(p);
			}

			else if(p.getPrecio()== mayor) {
				PiezasMasCaras.add(p);

			}
		}
		return PiezasMasCaras;
	}


	//Reporte 2

	public float DineroToTalRecaudado() {
		return calcularTotalFactura();
	}


	//Reporte 3

	public float DineroPorPiezaDada(String Name) {
		float total = 0;  

		for(ComponenteOrdenador c : componentes ) {
			if(c.getClass().getSimpleName() == Name){
				total += c.getPrecio();
			}
		}
		return total;
	}


	//Reporte 4
	public float salarioTotalTrabajadores(){
		float SalarioTotal = 0;
		for(Trabajador t: trabajadores)
			SalarioTotal+= t.getSalarioBasico();

		return SalarioTotal;
	}


	//Reporte 5




	//Reporte 6

	public int cantidadPiezasTotal(){
		int CantidadPiezas = 0;
		for(ComponenteOrdenador c: componentes )
			CantidadPiezas+= c.getCantDisponible();

		return CantidadPiezas;
	}
}
