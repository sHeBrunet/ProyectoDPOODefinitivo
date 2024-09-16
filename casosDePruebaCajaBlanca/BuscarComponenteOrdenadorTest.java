package casosDePruebaCajaBlanca;
import logica.ComponenteOrdenador;
import logica.TiendaDeComputadoras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BuscarComponenteOrdenadorTest {
	private ArrayList<ComponenteOrdenador> componentes;
	private TiendaDeComputadoras tienda;
	private boolean encont = false;;
	/*************************************BuscarComponente*******************************/
	@Before
	public void setUp() {
		componentes = new ArrayList<>();
		tienda = new TiendaDeComputadoras();

	}

	@Test
	public void testBuscarComponenteListaVacia() {
		ComponenteOrdenador result = tienda.buscarComponente("12345");
		assertNull(result);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testBuscarComponenteUnElementoCoincide() {
		ComponenteOrdenador comp = new ComponenteOrdenador(10, "A45", "Anker", "Hub 7en1 Thunderbolt 3", 12.99f);
		componentes.add(comp);
		tienda.agregarComponenteI(componentes);
		ComponenteOrdenador result = tienda.buscarComponente("A45");
		if(result != null) {
			encont = true;
		}
		equals(encont);
	}

	@Test
	public void testBuscarComponenteSinCoincidencias() {
		componentes.add(new ComponenteOrdenador(10, "A12345", "Amazon Basics", "USB-C a USB-A", 16.99f));
		tienda.agregarComponenteI(componentes);
		ComponenteOrdenador result = tienda.buscarComponente("43D");
		assertNull(result);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testBuscarComponenteCoincidenciaPrimeraIteracion() {
		ComponenteOrdenador comp = new ComponenteOrdenador(10, "A12345", "Amazon Basics", "USB-C a USB-A", 16.99f);
		componentes.add(comp);
		componentes.add(new ComponenteOrdenador(10, "Ae12345", "ViTech", "HDMI a VGA", 28.99f));
		tienda.agregarComponenteI(componentes);
		ComponenteOrdenador result = tienda.buscarComponente("A12345");
		if(result != null) {
			encont = true;
		}
		equals(encont);
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testBuscarComponenteCoincidenciaSegundaIteracion() {
		componentes.add(new ComponenteOrdenador(10, "A45", "Anker", "Hub 7en1 Thunderbolt 3", 12.99f));
		ComponenteOrdenador comp = new ComponenteOrdenador(10, "Ae12345", "ViTech", "HDMI a VGA", 28.99f);
		componentes.add(comp);
		tienda.agregarComponenteI(componentes);
		ComponenteOrdenador result = tienda.buscarComponente("Ae12345");
		if(result != null) {
			encont = true;
		}
		equals(encont);
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testBuscarComponenteCoincidenciaUltimaIteracion() {
		componentes.add(new ComponenteOrdenador(10, "A12345", "ViTech", "HDMI a VGA", 28.99f));
		componentes.add(new ComponenteOrdenador(10, "Ae12345", "Amazon Basics", "USB-C a USB-A", 16.99f));
		ComponenteOrdenador comp = new ComponenteOrdenador(10, "A45", "Anker", "Hub 7en1 Thunderbolt 3", 12.99f);
		componentes.add(comp);
		tienda.agregarComponenteI(componentes);
		ComponenteOrdenador result = tienda.buscarComponente("A45");
		if(result != null) {
			encont = true;
		}
		equals(encont);
	}



}