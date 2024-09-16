package inicializaciones;
import java.time.LocalDate;
import java.util.ArrayList;

import logica.Adaptador;
import logica.Bocina;
import logica.Chasis;
import logica.ComponenteOrdenador;
import logica.DiscoDuro;
import logica.Fuente;
import logica.Gerente;
import logica.ManejoDeSesion;
import logica.MemoriaRam;
import logica.Microprocesador;
import logica.Monitor;
import logica.Mouse;
import logica.TarjetaDeVideo;
import logica.TarjetaMadre;
import logica.Teclado;
import logica.TiendaDeComputadoras;
import logica.Trabajador;
public class InicializacionDeDatos {
	public static void crearTrabajadores(TiendaDeComputadoras tienda) {

		// Datos para los trabajadores

		tienda.agregarTrabajador(new Trabajador("MG93", "María", "Gómez Gónzalez", "93052789095", 4000,"Preuniversitario", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("PR94", "Pedro", "Rodríguez Villarreal", "94060890136",1000, "Técnico Medio", "Cajero"));
		tienda.agregarTrabajador(new Trabajador("AL95", "Ana", "López Pérez", "95071901456", 900, "Secundaria", "Técnico"));
		tienda.agregarTrabajador(new Trabajador("LM96", "Luis", "Martínez Cordovéz", "96081012753",4500, "Universitario", "Técnico"));
		tienda.agregarTrabajador(new Trabajador("LS87", "Laura", "Sánchez Sueiro", "87090123789",2000, "Preuniversitario", "Técnico"));
		tienda.agregarTrabajador(new Trabajador("CG78", "Carlos", "García Mujillo", "78011234560", 1230, "Secundaria", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("LH89", "Lucía", "Hernández Salazar", "89012345789", 1234, "Secundaria", "Cajero"));
		tienda.agregarTrabajador(new Trabajador("JD90", "Jorge", "Díaz García", "90120256542", 3453, "Universitario", "Técnico"));
		tienda.agregarTrabajador(new Trabajador("SM01", "Sofía", "Morales Montero", "01040567712", 3456, "Preuniversitario", "Cajero"));

		tienda.agregarTrabajador(new Trabajador("AC72", "Andrés", "Castillo Gusmán", "72041679456", 1234, "Secundaria", "Cajero"));
		tienda.agregarTrabajador(new Trabajador("MV93", "Marta", "Vargas Castro", "93051780542", 2000, "Técnico Medio", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("FR84", "Fernando", "Ramírez Montenegro", "84061891789", 3000, "Universitario", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("CT75", "Claudia", "Torres Gutierrez", "75071902542", 4000, "Preuniversitario", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("DR96", "Diego", "Rojas Trujillo", "96081013324", 4000, "Técnico Medio", "Técnico"));

		tienda.agregarTrabajador(new Trabajador("EJ77", "Elena", "Jiménez Pacheco", "77090124785", 3400, "Secundaria", "Auxiliar de Limpieza"));
		tienda.agregarTrabajador(new Trabajador("PM88", "Pablo", "Mendoza Carvajal", "88011235785", 4000, "Universitario", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("TS99", "Teresa", "Salazar Ramos", "99012346654", 3000, "Preuniversitario", "Cajero"));
		tienda.agregarTrabajador(new Trabajador("RC90", "Ricardo", "Cruz Ronaldo", "90122157863", 2300, "Secundaria", "Auxiliar de Limpieza"));
		tienda.agregarTrabajador(new Trabajador("JO01", "Julia", "Ortega Cross", "01031568324", 1000, "Secundaria", "Técnico"));

		tienda.agregarTrabajador(new Trabajador("DA82", "David", "Aguilar Casilla", "82111680452", 1000, "Secundaria", "Auxiliar de Limpieza"));
		tienda.agregarTrabajador(new Trabajador("CG73", "Carmen", "Gómez Piqué", "73021781421", 3000, "Preuniversitario", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("MP64", "Miguel", "Pérez Vázquez", "64061892245", 4000, "Universitario", "Económico"));
		tienda.agregarTrabajador(new Trabajador("PR85", "Patricia", "Rodríguez Machado", "85071903354", 2300, "Técnico Medio", "Cajero"));
		tienda.agregarTrabajador(new Trabajador("AL96", "Alejandro", "López Ramirez", "96081014657", 3000, "Universitario", "Técnico"));

		tienda.agregarTrabajador(new Trabajador("SS78", "Santiago", "Sánchez Cano", "78011236895", 2000, "Secundaria", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("GG89", "Gabriela", "García Mendoza", "89012347741", 2000, "Secundaria", "Asistente"));
		tienda.agregarTrabajador(new Trabajador("RH90", "Raúl", "Hernández García", "90121458101", 1000, "Universitario", "Cajero"));
		tienda.agregarTrabajador(new Trabajador("ID01", "Isabel", "Díaz Ruz", "01011569014", 2000, "Preuniversitario", "Diseñador"));

	}

	//Datos Gerentes
	public static void crearGerentes(TiendaDeComputadoras tienda) {
		try {
			if (tienda == null) {
				throw new IllegalArgumentException("La instancia de TiendaDeComputadoras no puede ser null");
			}
			LocalDate fecha1 = LocalDate.of(2021, 10, 19);
			LocalDate fecha2 = LocalDate.of(2023, 6, 17);
			Trabajador t = new Gerente("JP92", "Juan", "Pérez Carrodegua", "92040678014", 5000, "Universitario", "Gerente", fecha1);
			Trabajador t1 = new Gerente("VM97", "Verónica", "Martínez González", "97090125954", 5000, "Universitario", "Gerente", fecha2);
			tienda.agregarTrabajador((Trabajador)t);
			tienda.agregarTrabajador((Trabajador)t1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void crearUsuarios(TiendaDeComputadoras tienda) {
		crearTrabajadores(tienda);
		for(int i = 0; i <tienda.getCantTrabajadores(); i++) {
			ManejoDeSesion.getInstance().setUsername(tienda.getTrabajadores().get(i) + tienda.getTrabajadores().get(i).getCI());
			ManejoDeSesion.getInstance().setPassword("1234");
		}
	}

	//Llamada a todos los datos de los productos
	public static void llamarInicializaciones(TiendaDeComputadoras tienda) {
		inicializarAdaptadores(tienda);
		inicializarBocinas(tienda);
		inicializarChasis(tienda);
		inicializarDiscosDuros(tienda);
		inicializarFuentes(tienda);
		inicializarMicroprocesador(tienda);
		inicializarMemoriasRAM(tienda);
		inicializarMonitores(tienda);
		inicializarMouses(tienda);
		inicializarTarjetasMadre(tienda);
		inicializarTarjetasVideo(tienda);
		inicializarTeclados(tienda);	
	}

	//Datos para los productos
	public static ArrayList<String> capacidadDiscoDuroTB(){
		ArrayList<String> c = new ArrayList<String>();
		c.add("1");
		c.add("2");
		c.add("4");
		c.add("6");
		c.add("8");
		c.add("10");
		return c;
	}
	public static ArrayList<String> velocidadaMicro(){// En GHz
		ArrayList<String> c = new ArrayList<String>();
		c.add("2");
		c.add("3.5");
		c.add("4");
		c.add("5.5");
		c.add("6");
		c.add("7.5");
		return c;
	}	
	public static ArrayList<String> espacioRAM(){// En GB
		ArrayList<String> c = new ArrayList<String>();
		c.add("4");
		c.add("8");
		c.add("16");
		c.add("32");
		return c;
	}	

	/*********************************Adaptadores*************************************************************/
	public static void inicializarAdaptadores(TiendaDeComputadoras tienda) {
		ArrayList<Adaptador> adaptadores = new ArrayList<>();
		adaptadores.add(new Adaptador(10, "A45", "Anker", "Hub 7en1 Thunderbolt 3", 12.99f));
		adaptadores.add(new Adaptador(10, "A12345", "Amazon Basics", "USB-C a USB-A", 16.99f));
		adaptadores.add(new Adaptador(10, "A2345", "Apple", "USB-C a Ethernet", 20.99f));
		adaptadores.add(new Adaptador(10, "App2345", "Belkin", "USB-C a HDMI", 24.99f));
		adaptadores.add(new Adaptador(10, "Ae12345", "ViTech", "HDMI a VGA", 28.99f));

		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(adaptadores);
		tienda.agregarComponenteI(c);
	}

	/**********************************Bocina***************************************************************/
	public static void inicializarBocinas(TiendaDeComputadoras tienda) {
		ArrayList<Bocina> bocinas = new ArrayList<>();
		bocinas.add(new Bocina(20, "B12345", "Logitech", "Z333", 44.99f, "Inalámbrica"));
		bocinas.add(new Bocina(15, "B12346", "JBL", "Clip 4", 48.99f, "Inalámbrica"));
		bocinas.add(new Bocina(18, "B12347", "Sony", "SRS-XB13", 52.99f, "Inalámbrica"));
		bocinas.add(new Bocina(22, "B12348", "Sennheiser", "Momentum 3 Wireless", 38.99f, "Cable"));
		bocinas.add(new Bocina(25, "B12349", "Bose", "SoundLink Mini II", 36.99f, "Inalámbrica"));
		bocinas.add(new Bocina(20, "B12350", "Logitech", "Z625", 45.99f, "Cable"));
		bocinas.add(new Bocina(15, "B12351", "JBL", "Flip 6", 54.99f, "Inalámbrica"));
		bocinas.add(new Bocina(18, "B12352", "Sony", "SRS-XB33", 55.99f, "Inalámbrica"));
		bocinas.add(new Bocina(22, "B12353", "Bose", "SoundLink Revolve+", 39.99f, "Inalámbrica"));
		bocinas.add(new Bocina(25, "B12354", "Sennheiser", "Momentum True Wireless 3", 41.99f, "Cable"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(bocinas);
		tienda.agregarComponenteI(c);
	}

	/**********************************Chasis***************************************************************/
	public static void inicializarChasis(TiendaDeComputadoras tienda) {
		ArrayList<Chasis> chasis = new ArrayList<>();
		chasis.add(new Chasis(7, "C12345", "Cooler Master", "MasterBox Q300L", 57.99f, "Metal"));
		chasis.add(new Chasis(10, "C12346", "Thermaltake", "Versa H15", 71.99f, "Fibra de Carbono"));
		chasis.add(new Chasis(5, "C12347", "NZXT", "H510", 69.99f, "Metal"));
		chasis.add(new Chasis(8, "C12348", "Corsair", "iCUE 4000X", 76.99f, "Metal"));
		chasis.add(new Chasis(6, "C12349", "Fractal Design", "Meshify 2 XL", 71.99f, "Metal"));
		chasis.add(new Chasis(9, "C12350", "Cooler Master", "MasterCase H500", 66.99f, "Metal"));
		chasis.add(new Chasis(11, "C12351", "Thermaltake", "Core P5", 75.99f, "Aluminio"));
		chasis.add(new Chasis(7, "C12352", "NZXT", "H710i", 75.99f, "Metal"));
		chasis.add(new Chasis(10, "C12353", "Corsair", "iCUE 7000X RGB", 82.99f, "Metal"));
		chasis.add(new Chasis(8, "C12354", "Fractal Design", "Define 7", 80.99f, "Acero"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(chasis);
		tienda.agregarComponenteI(c);
	}

	/*********************************DiscoDuro*************************************************************/
	public static void inicializarDiscosDuros(TiendaDeComputadoras tienda) {
		ArrayList<DiscoDuro> discosDuros = new ArrayList<>();
		discosDuros.add(new DiscoDuro(10, "DD12345", "Toshiba", "Canvio Basics", 39.99f, false, 1, "IDE"));
		discosDuros.add(new DiscoDuro(8, "DD12346", "Samsung", "T5", 64.99f, false, 4, "SATA-3"));
		discosDuros.add(new DiscoDuro(12, "DD12347", "WD", "My Passport", 54.99f, false, 2, "SATA-3"));
		discosDuros.add(new DiscoDuro(9, "DD12348", "Seagate", "Backup Plus", 65.99f, false, 4, "SAS"));
		discosDuros.add(new DiscoDuro(11, "DD12349", "Toshiba", "Canvio Advance", 49.99f, false, 2, "SATA-3"));
		discosDuros.add(new DiscoDuro(10, "DD12350", "Samsung", "T7", 73.99f, false, 1, "SATA-3"));
		discosDuros.add(new DiscoDuro(8, "DD12351", "WD", "My Book", 58.99f, false, 8, "IDE"));
		discosDuros.add(new DiscoDuro(12, "DD12352", "Seagate", "Expansion", 63.99f, false, 4, "SATA-3"));
		discosDuros.add(new DiscoDuro(9, "DD12353", "Toshiba", "N300", 61.99f, false, 6, "SAS"));
		discosDuros.add(new DiscoDuro(11, "DD12354", "Samsung", "970 EVO Plus", 74.99f, false, 8, "SATA-3"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(discosDuros);
		tienda.agregarComponenteI(c);
	}	

	/**********************************Fuentes***************************************************************/
	public static void inicializarFuentes(TiendaDeComputadoras tienda) {
		ArrayList<Fuente> fuentes = new ArrayList<>();
		fuentes.add(new Fuente(10, "F12345", "Thermaltake", "Smart 500W", 57.99f, "Gold"));
		fuentes.add(new Fuente(8, "F12346", "Corsair", "CX550F RGB", 68.99f, "Silver"));
		fuentes.add(new Fuente(12, "F12347", "EVGA", "SuperNOVA 550 G3", 70.99f, "Platinum"));
		fuentes.add(new Fuente(9, "F12348", "Seasonic", "Focus GX-550", 74.99f, "Platinum"));
		fuentes.add(new Fuente(11, "F12349", "Be Quiet!", "System Power 9 500W", 61.99f, "Gold"));
		fuentes.add(new Fuente(10, "F12350", "Thermaltake", "Toughpower GF1 850W", 53.99f, "Bronze"));
		fuentes.add(new Fuente(8, "F12351", "Corsair", "RM750x", 71.99f, "Silver"));
		fuentes.add(new Fuente(12, "F12352", "EVGA", "SuperNOVA 1000 G3", 74.99f, "Gold"));
		fuentes.add(new Fuente(9, "F12353", "Seasonic", "Prime TX-1000", 83.99f, "Platinum"));
		fuentes.add(new Fuente(11, "F12354", "Be Quiet!", "Dark Power Pro 11 1200W", 62.99f, "Silver"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(fuentes);
		tienda.agregarComponenteI(c);
	} 

	/*********************************Microprocesadores*************************************************************/
	public static void inicializarMicroprocesador(TiendaDeComputadoras tienda) {
		ArrayList<Microprocesador> microprocesadores = new ArrayList<>();
		microprocesadores.add(new Microprocesador(5, "MP12345", "AMD", "Ryzen 5 5600X", 76.99f, "AM4", 3.5f));
		microprocesadores.add(new Microprocesador(4, "MP12346", "Intel", "Core i5-12600K", 93.99f, "LGA 1700", 3.5f));
		microprocesadores.add(new Microprocesador(6, "MP12347", "AMD", "Ryzen 7 5800X3D", 79.99f, "AM4", 3.5f));
		microprocesadores.add(new Microprocesador(7, "MP12348", "Intel", "Core i7-13700K", 96.99f, "LGA 1700", 3.5f));
		microprocesadores.add(new Microprocesador(5, "MP12349", "AMD", "Ryzen 9 5900X", 82.99f, "AM4", 3.5f));
		microprocesadores.add(new Microprocesador(4, "MP12350", "Intel", "Core i9-13900K", 150.99f, "LGA 1700", 4f));
		microprocesadores.add(new Microprocesador(6, "MP12351", "AMD", "Ryzen 9 7900X", 97.99f, "AM5", 4.0f));
		microprocesadores.add(new Microprocesador(7, "MP12352", "Intel", "Core i3-12100F", 101.99f, "LGA 1700", 4f));
		microprocesadores.add(new Microprocesador(5, "MP12353", "AMD", "Ryzen 5 5600X", 78.99f, "AM4", 4f));
		microprocesadores.add(new Microprocesador(4, "MP12354", "Intel", "Core i5-12600K", 95.99f, "LGA 1700", 4f));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(microprocesadores);
		tienda.agregarComponenteI(c);
	}

	/*********************************MemoriasRAM*************************************************************/
	public static void inicializarMemoriasRAM(TiendaDeComputadoras tienda) {
		ArrayList<MemoriaRam> memoriasRAM = new ArrayList<>();
		memoriasRAM.add(new MemoriaRam(20, "MR12345", "Crucial", "Ballistix Sport LT", 53.99f,  false, 16, "DDR-4"));
		memoriasRAM.add(new MemoriaRam(15, "MR12346", "Corsair", "Vengeance LPX", 69.99f, false, 16, "DDR-4"));
		memoriasRAM.add(new MemoriaRam(18, "MR12347", "G.Skill", "Trident Z Neo", 70.99f,  false,32, "DDR-4"));
		memoriasRAM.add(new MemoriaRam(22, "MR12348", "Kingston", "Kingston ValueRAM", 55.99f, false, 8, "DDR-4"));
		memoriasRAM.add(new MemoriaRam(25, "MR12349", "Crucial", "Ballistix Max", 61.99f,  false,32, "DDR-4"));
		memoriasRAM.add(new MemoriaRam(20, "MR12350", "Corsair", "Dominator Platinum RGB", 77.99f, false, 32, "DDR-4"));
		memoriasRAM.add(new MemoriaRam(15, "MR12351", "G.Skill", "Trident Z5", 78.99f,  false, 32, "DDR-5"));
		memoriasRAM.add(new MemoriaRam(18, "MR12352", "Kingston", "Kingston Fury Renegade", 65.99f,  false, 16, "DDR-5"));
		memoriasRAM.add(new MemoriaRam(22, "MR12353", "Crucial", "Ballistix 5600 MHz", 69.99f,  false, 32, "DDR-5"));
		memoriasRAM.add(new MemoriaRam(25, "MR12354", "Corsair", "Vengeance RGB Pro", 74.99f,  false, 32, "DDR-4"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(memoriasRAM);
		tienda.agregarComponenteI(c);
	}

	/**********************************Monitores***************************************************************/
	public static void inicializarMonitores(TiendaDeComputadoras tienda) {
		ArrayList<Monitor> monitores = new ArrayList<>();
		monitores.add(new Monitor(5, "MN12345", "Acer", "Nitro XV272U Pbmiiprzx", 62.99f, "1080p"));
		monitores.add(new Monitor(8, "MN12346", "Dell", "S2422H", 66.99f, "1080p"));
		monitores.add(new Monitor(6, "MN12347", "Samsung", "S95B", 92.99f, "4K"));
		monitores.add(new Monitor(7, "MN12348", "LG", "OLED48C1PUB", 88.99f, "4K"));
		monitores.add(new Monitor(9, "MN12349", "ASUS", "VG27AQ", 73.99f, "1080p"));	
		monitores.add(new Monitor(6, "MN12350", "Acer", "Predator XB273K Gbmiiprzx", 76.99f, "4K"));
		monitores.add(new Monitor(10, "MN12351", "Dell", "U2723QE", 74.99f, "4K"));
		monitores.add(new Monitor(7, "MN12352", "Samsung", "S95B", 87.99f, "1080p"));
		monitores.add(new Monitor(8, "MN12353", "LG", "27UL500-W", 84.99f, "5K"));
		monitores.add(new Monitor(11, "MN12354", "ASUS", "ROG Swift PG32UQ", 84.99f, "4K"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(monitores);
		tienda.agregarComponenteI(c);
	}

	/**********************************Mouses***************************************************************/
	public static void inicializarMouses(TiendaDeComputadoras tienda) {
		ArrayList<Mouse> mouses = new ArrayList<>();
		mouses.add(new Mouse(10, "R12345", "HyperX", "Pulsefire Core", 32.99f, "Inalámbrica"));
		mouses.add(new Mouse(15, "R12346", "Logitech", "G203 LIGHTSYNC", 36.99f, "Inalámbrica"));
		mouses.add(new Mouse(12, "R12347", "SteelSeries", "Rival 3", 35.99f, "Cable"));
		mouses.add(new Mouse(8, "R12348", "Corsair", "Harpoon RGB Wireless", 44.99f, "Inalámbrica"));
		mouses.add(new Mouse(20, "R12349", "Razer", "Viper Mini", 48.99f, "Inalámbrica"));
		mouses.add(new Mouse(11, "R12350", "HyperX", "Pulsefire Surge", 35.99f, "Inalámbrica"));
		mouses.add(new Mouse(16, "R12351", "Logitech", "G305 LIGHTSPEED", 34.99f, "Cable"));
		mouses.add(new Mouse(13, "R12352", "SteelSeries", "Rival 3 Wireless", 43.99f,"Inalámbrica"));
		mouses.add(new Mouse(9, "R12353", "Corsair", "Katar Pro XT", 47.99f, "Inalámbrica"));
		mouses.add(new Mouse(21, "R12354", "Razer", "Viper Ultimate", 51.99f, "Inalámbrica"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(mouses);
		tienda.agregarComponenteI(c);
	}

	/**********************************Motherboards***************************************************************/
	public static void inicializarTarjetasMadre(TiendaDeComputadoras tienda) {
		ArrayList<TarjetaMadre> tarjetasMadre = new ArrayList<>();
		TarjetaMadre tarjetaMadre1 = new TarjetaMadre(5, "TM12345", "ASUS", "Prime B660M-A", 94.99f, "LGA 1700");
		tarjetaMadre1.agregarMemoriaRAMCompatible(new MemoriaRam(20, "MR12345", "Crucial", "Ballistix Sport LT", 63.99f,  false, 16, "DDR-4"));
		tarjetaMadre1.agregarMemoriaRAMCompatible(new MemoriaRam(18, "MR12347", "G.Skill", "Trident Z Neo", 70.99f,  false,32, "DDR-4"));
		tarjetaMadre1.agregarDiscoDuroCompatible(new DiscoDuro(10, "DD12345", "Toshiba", "Canvio Basics", 39.99f, true, 1000, "IDE"));
		tarjetaMadre1.agregarDiscoDuroCompatible(new DiscoDuro(2, "DD12346", "WD", "My Passport", 54.99f, true, 2000, "SATA-3"));
		tarjetaMadre1.setProcesadorCompatible(new Microprocesador(4, "MP12346", "Intel", "Core i5-12600K", 95.99f, "LGA 1700", 4f));
		tarjetasMadre.add(tarjetaMadre1);

		TarjetaMadre tarjetaMadre2 = new TarjetaMadre(4, "TM12346", "Gigabyte", "X670E Aorus Elite AX", 97.99f, "AM4");
		tarjetaMadre2.agregarMemoriaRAMCompatible(new MemoriaRam(15, "MR12346", "Corsair", "Vengeance LPX", 69.99f,  false, 16, "DDR-4"));
		tarjetaMadre2.agregarDiscoDuroCompatible(new DiscoDuro(8, "DD12346", "Samsung", "T5", 64.99f, true, 4000, "SATA-3"));
		tarjetaMadre2.setProcesadorCompatible(new Microprocesador(5, "MP12345", "AMD", "Ryzen 5 5600X", 76.99f, "AM4", 3.5f));
		tarjetasMadre.add(tarjetaMadre2);

		TarjetaMadre tarjetaMadre3 = new TarjetaMadre(6, "TM12347", "MSI", "X670E Godlike", 104.99f, "AM4");
		tarjetaMadre3.agregarMemoriaRAMCompatible(new MemoriaRam(18, "MR12347", "G.Skill", "Trident Z Neo", 70.99f,  false, 32, "DDR-4"));
		tarjetaMadre3.agregarDiscoDuroCompatible(new DiscoDuro(12, "DD12347", "WD", "My Passport", 54.99f, true, 2000, "SATA-3"));
		tarjetaMadre3.setProcesadorCompatible(new Microprocesador(6, "MP12347", "AMD", "Ryzen 7 5800X3D", 79.99f, "AM4", 3.5f));
		tarjetasMadre.add(tarjetaMadre3);

		TarjetaMadre tarjetaMadre4 = new TarjetaMadre(7, "TM12348", "ASRock", "B660M-Pro RS", 90.99f, "AM4");
		tarjetaMadre4.agregarMemoriaRAMCompatible(new MemoriaRam(22, "MR12348", "Kingston", "Kingston Fury Renegade", 65.99f,  false, 16, "DDR-5"));
		tarjetaMadre4.agregarDiscoDuroCompatible(new DiscoDuro(9, "DD12348", "Seagate", "Backup Plus", 65.99f, true, 4000, "SAS"));
		tarjetaMadre4.setProcesadorCompatible(new Microprocesador(5, "MP12349", "AMD", "Ryzen 9 5900X", 82.99f, "AM4", 3.5f));
		tarjetasMadre.add(tarjetaMadre4);

		TarjetaMadre tarjetaMadre5 = new TarjetaMadre(5, "TM12349", "ASUS", "ROG Strix B660-G Gaming WiFi", 100.99f, "LGA 1700");
		tarjetaMadre5.agregarMemoriaRAMCompatible(new MemoriaRam(25, "MR12349", "Crucial", "Ballistix Max", 61.99f,  false, 32, "DDR-4"));
		tarjetaMadre5.agregarDiscoDuroCompatible(new DiscoDuro(11, "DD12349", "Toshiba", "Canvio Advance", 49.99f, true, 2000, "SATA-3"));
		tarjetaMadre5.setProcesadorCompatible(new Microprocesador(4, "MP12350", "Intel", "Core i9-13900K", 101.99f, "LGA 1700", 4f));
		tarjetasMadre.add(tarjetaMadre5);

		TarjetaMadre tarjetaMadre6 = new TarjetaMadre(6, "TM12350", "Gigabyte", "X670E Aorus Master", 95.99f, "LGA 1700");
		tarjetaMadre6.agregarMemoriaRAMCompatible(new MemoriaRam(20, "MR12350", "Corsair", "Dominator Platinum RGB", 77.99f,  false, 32, "DDR-4"));
		tarjetaMadre6.agregarDiscoDuroCompatible(new DiscoDuro(10, "DD12350", "Samsung", "T7", 63.99f, true, 1000, "SATA-3"));
		tarjetaMadre6.setProcesadorCompatible(new Microprocesador(6, "MP12351", "AMD", "Ryzen 9 7900X", 97.99f, "AM5", 4.0f));
		tarjetasMadre.add(tarjetaMadre6);

		TarjetaMadre tarjetaMadre7 = new TarjetaMadre(7, "TM12351", "MSI", "X670E Carbon WiFi", 91.99f, "LGA 1200");
		tarjetaMadre7.agregarMemoriaRAMCompatible(new MemoriaRam(15, "MR12351", "G.Skill", "Trident Z5", 78.99f,  false, 32, "DDR-5"));
		tarjetaMadre7.agregarDiscoDuroCompatible(new DiscoDuro(8, "DD12351", "WD", "My Book", 58.99f, true, 8000, "IDE"));
		tarjetaMadre7.setProcesadorCompatible(new Microprocesador(7, "MP12352", "Intel", "Core i3-12100F", 92.99f, "LGA 1700", 4f));
		tarjetasMadre.add(tarjetaMadre7);

		TarjetaMadre tarjetaMadre8 = new TarjetaMadre(5, "TM12352", "ASRock", "X670E Steel Legend", 96.99f, "AM4");
		tarjetaMadre8.agregarMemoriaRAMCompatible(new MemoriaRam(18, "MR12352", "Kingston", "Kingston ValueRAM", 55.99f,  false, 8, "DDR-4"));
		tarjetaMadre8.agregarDiscoDuroCompatible(new DiscoDuro(12, "DD12352", "Seagate", "Expansion", 63.99f, true, 4000, "SATA-3"));
		tarjetaMadre8.setProcesadorCompatible(new Microprocesador(6, "MP12347", "AMD", "Ryzen 7 5800X3D", 79.99f, "AM4", 3.5f));
		tarjetasMadre.add(tarjetaMadre8);

		TarjetaMadre tarjetaMadre9 = new TarjetaMadre(6, "TM12353", "Gigabyte", "B660M DS3H", 91.99f, "AM4");
		tarjetaMadre9.agregarMemoriaRAMCompatible(new MemoriaRam(22, "MR12348", "Crucial", "Balistix 5600 MHz", 69.99f,  false, 32, "DDR-5"));
		tarjetaMadre9.agregarDiscoDuroCompatible(new DiscoDuro(9, "DD12348", "Seagate", "Backup Plus", 65.99f, true, 4000, "SAS"));
		tarjetaMadre9.setProcesadorCompatible(new Microprocesador(5, "MP12349", "AMD", "Ryzen 9 5900X", 82.99f, "AM4", 3.5f));
		tarjetasMadre.add(tarjetaMadre9);

		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(tarjetasMadre);
		tienda.agregarComponenteI(c);
	}

	/*********************************TarjetasVideo*************************************************************/
	public static void inicializarTarjetasVideo(TiendaDeComputadoras tienda) {
		ArrayList<TarjetaDeVideo> tarjetasVideo = new ArrayList<>();
		tarjetasVideo.add(new TarjetaDeVideo(5, "TV12345", "AMD", "Radeon RX 6600", 132.99f, "Aire"));
		tarjetasVideo.add(new TarjetaDeVideo(4, "TV12346", "Gigabyte", "GeForce RTX 3070 Eagle OC", 147.99f, "Líquido"));
		tarjetasVideo.add(new TarjetaDeVideo(6, "TV12347", "AMD", "Radeon RX 6700 XT", 135.99f, "Aire"));
		tarjetasVideo.add(new TarjetaDeVideo(7, "TV12348", "MSI", "GeForce RTX 3070 Gaming X Trio", 161.99f, "Mixto"));
		tarjetasVideo.add(new TarjetaDeVideo(5, "TV12349", "AMD", "Radeon RX 6800 XT", 138.99f, "Aire"));
		tarjetasVideo.add(new TarjetaDeVideo(4, "TV12350", "Gigabyte", "GeForce RTX 3080 Gaming OC", 150.99f, "Líquido"));
		tarjetasVideo.add(new TarjetaDeVideo(6, "TV12351", "AMD", "Radeon RX 6900 XT", 141.99f, "Aire"));
		tarjetasVideo.add(new TarjetaDeVideo(7, "TV12352", "ASUS", "GeForce RTX 3080 TUF Gaming OC", 158.99f, "Líquido"));
		tarjetasVideo.add(new TarjetaDeVideo(5, "TV12353", "MSI", "GeForce GTX 1660 Super Ventus XS OC", 140.99f, "Aire"));
		tarjetasVideo.add(new TarjetaDeVideo(4, "TV12354", "NVIDIA", "GeForce RTX 4090", 172.99f, "Mixto"));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(tarjetasVideo);
		tienda.agregarComponenteI(c);
	}

	/**********************************Teclados***************************************************************/
	public static void inicializarTeclados(TiendaDeComputadoras tienda) {
		ArrayList<Teclado> teclados = new ArrayList<>();
		teclados.add(new Teclado(12, "TE12345", "HyperX", "Alloy Origins Core", 37.99f, 1));
		teclados.add(new Teclado(9, "TE12346", "Logitech", "G213 Prodigy", 44.99f, 1));
		teclados.add(new Teclado(10, "TE12347", "Razer", "BlackWidow Lite", 38.99f, 0));
		teclados.add(new Teclado(8, "TE12348", "Corsair", "K100 RGB", 58.99f, 1));
		teclados.add(new Teclado(7, "TE12349", "SteelSeries", "Apex Pro", 51.99f, 1));
		teclados.add(new Teclado(11, "TE12350", "HyperX", "Alloy Origins 60", 25.99f, 0));
		teclados.add(new Teclado(10, "TE12351", "Logitech", "G915 Lightspeed", 50.99f, 1));
		teclados.add(new Teclado(9, "TE12352", "Razer", "Huntsman Mini", 56.99f, 1));
		teclados.add(new Teclado(8, "TE12353", "Corsair", "K70 RGB MK.2", 55.99f, 1));
		teclados.add(new Teclado(7, "TE12354", "SteelSeries", "Apex 7", 54.99f, 1));
		ArrayList<ComponenteOrdenador> c = new ArrayList<ComponenteOrdenador>();
		c.addAll(teclados);
		tienda.agregarComponenteI(c);
	}

	/**************************************PARA LOS COMBOBOX**************************************************************/
	public static ArrayList<String> resolucionVideo(){
		ArrayList<String> resoluciones = new ArrayList<String>();
		resoluciones.add("1080p");
		resoluciones.add("4K");
		resoluciones.add("5K");
		return resoluciones;
	}
	public static ArrayList<String> nivelesEscolar(){
		ArrayList<String> nivel = new ArrayList<String>();
		nivel.add("Secundaria");
		nivel.add("Preuniversitario");
		nivel.add("Técnico Medio");
		nivel.add("Universitario");
		return nivel;
	}
	public static ArrayList<String> conexionesDiscoDuro(){
		ArrayList<String> conexiones= new ArrayList<String>();
		conexiones.add("IDE");
		conexiones.add("SATA-3");
		conexiones.add("SAS");
		return conexiones;
	}
	public static ArrayList<String> cargos(){
		ArrayList<String> cargo = new ArrayList<String>();
		cargo.add("Auxiliar de Limpieza");
		cargo.add("Cajero");
		cargo.add("Asistente");
		cargo.add("Técnico");
		cargo.add("Diseñador");
		cargo.add("Económico");
		cargo.add("Gerente");
		return cargo;
	}
	public static ArrayList<String> conexionesIntel(){
		ArrayList<String> conexion = new ArrayList<String>();
		conexion.add("LGA 1151"); //Intel
		conexion.add("LGA 1200");
		conexion.add("LGA 1700");

		return conexion;
	}
	public static ArrayList<String> conexionesAMD(){
		ArrayList<String> conexion = new ArrayList<String>();
		conexion.add("AM4");      //AMD
		conexion.add("AM3+");
		conexion.add("AM5");
		conexion.add("TR4");
		return conexion;
	}
	public static ArrayList<String> conectores(){
		ArrayList<String> conector = new ArrayList<String>();
		conector.add("LGA 1151");
		conector.add("LGA 1200");
		conector.add("LGA 1700");
		conector.add("AM4");
		conector.add("AM3+");
		conector.add("TR4");

		return conector;
	}
	public static ArrayList<String> conectividad(){
		ArrayList<String> c = new ArrayList<String>();
		c.add("Cable");
		c.add("Inalámbrica");
		return c;
	}

	public static ArrayList<String> refrigeracion(){
		ArrayList<String> refrigeraciones = new ArrayList<String>();
		refrigeraciones.add("Aire");
		refrigeraciones.add("Líquido");
		refrigeraciones.add("Pasivo");
		refrigeraciones.add("Mixto");
		return refrigeraciones;
	}

	public static void datosTienda(TiendaDeComputadoras tienda) {
		tienda.setNombre("S.A.D PC Store");
		tienda.setID("SAD");
		tienda.setDireccion("Calle 5 entre Orquidea y Binario");
		tienda.setTelefono("+ 53 10011011");
	}

	public static ArrayList<String> nameComponente() {
		ArrayList<String> names= new ArrayList<String>();
		names.add("Adaptador");	
		names.add("Bocina");		
		names.add("Chasis");
		names.add("Disco Duro");
		names.add("Fuente");
		names.add("Microprocesador");
		names.add("Memoria RAM");
		names.add("Monitor");
		names.add("Ratón");
		names.add("Tarjeta Madre");
		names.add("Tarjeta de Video");
		names.add("Teclado");
		return names;
	}
	/*********************  MARCAS ORGANIZADAS DE MENOR A MAYOR PRECIO (APROXIMADAMENTE) ********************************/

	public static ArrayList<String> marcasAdaptadores() {
		ArrayList<String> extension = new ArrayList<String>();
		extension.add("Anker");
		extension.add("Amazon Basics");
		extension.add("Apple");
		extension.add("Belkin");
		extension.add("ViTech");
		return extension;
	}

	public static ArrayList<String> marcasPantalla() {
		ArrayList<String> marcasP = new ArrayList<String>();
		marcasP.add("Acer");
		marcasP.add("Dell");
		marcasP.add("ASUS");
		marcasP.add("LG");
		marcasP.add("Samsung");
		return marcasP;
	}

	public static ArrayList<String> marcasBocinas() {
		ArrayList<String> marcasB = new ArrayList<String>();
		marcasB.add("Bose");
		marcasB.add("Sennheiser");
		marcasB.add("Logitech");
		marcasB.add("JBL");
		marcasB.add("Sony");
		return marcasB;
	}
	public static ArrayList<String> marcasTeclado() {
		ArrayList<String> marcasT = new ArrayList<String>();
		marcasT.add("HyperX");
		marcasT.add("Logitech");
		marcasT.add("SteelSeries");
		marcasT.add("Corsair");
		marcasT.add("Razer");
		return marcasT;
	}
	public static ArrayList<String> marcasChasis() {
		ArrayList<String> marcasC = new ArrayList<String>();
		marcasC.add("Cooler Master");
		marcasC.add("Thermaltake");
		marcasC.add("Fractal Design");
		marcasC.add("NZXT");
		marcasC.add("Corsair");
		return marcasC;
	}
	public static ArrayList<String> marcasFuente() {
		ArrayList<String> marcasF = new ArrayList<String>();
		marcasF.add("Thermaltake");
		marcasF.add("Be Quiet!");
		marcasF.add("EVGA");
		marcasF.add("Seasonic");
		marcasF.add("Corsair");
		return marcasF;
	}
	public static ArrayList<String> marcasTarjetaVideos() {
		ArrayList<String> marcasT = new ArrayList<String>();
		marcasT.add("AMD");
		marcasT.add("Gigabyte");
		marcasT.add("MSI");
		marcasT.add("ASUS");
		marcasT.add("NVIDIA");
		return marcasT;
	}
	public static ArrayList<String> marcasTarjetaMadre() {
		ArrayList<String> marcasTM = new ArrayList<String>();
		marcasTM.add("ASRock");
		marcasTM.add("Gigabyte");
		marcasTM.add("MSI");
		marcasTM.add("ASUS");
		marcasTM.add("EVGA");
		return marcasTM;
	}
	public static ArrayList<String> marcasMemoriasRAM() {
		ArrayList<String> marcasRAM = new ArrayList<String>();
		marcasRAM.add("Crucial");
		marcasRAM.add("Kingston");
		marcasRAM.add("HyperX");
		marcasRAM.add("G.Skill");
		marcasRAM.add("Corsair");
		return marcasRAM;
	}
	public static ArrayList<String> marcasDiscoD() {
		ArrayList<String> marcasDD = new ArrayList<String>();
		marcasDD.add("Toshiba");
		marcasDD.add("Crucial");
		marcasDD.add("WD");
		marcasDD.add("Seagate");
		marcasDD.add("Samsung");
		return marcasDD;
	}
	public static ArrayList<String> marcasMicroProcesadores() {
		ArrayList<String> marcasMP = new ArrayList<String>();
		marcasMP.add("AMD");
		marcasMP.add("Intel");
		return marcasMP;
	}
	public static ArrayList<String> marcasRaton() {
		ArrayList<String> marcasR = new ArrayList<String>();
		marcasR.add("HyperX");
		marcasR.add("Logitech");
		marcasR.add("SteelSeries");
		marcasR.add("Corsair");
		marcasR.add("Razer");
		return marcasR;
	}
	public static ArrayList<String> materialesChasis() {
		ArrayList<String> materiales= new ArrayList<String>();
		materiales.add("Metal");
		materiales.add("Aluminio");
		materiales.add("Fibra de Carbono");
		materiales.add("Acero");
		return materiales;
	}

	public static ArrayList<String> tiposDeMemoriaRAM(){
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("DDR-3");
		tipos.add("DDR-4");
		tipos.add("DDR-5");
		return tipos;
	}

	public static ArrayList<String> retroiluminacionTeclados(){
		ArrayList<String> retroiluminacion = new ArrayList<String>();
		retroiluminacion.add("NO");
		retroiluminacion.add("SÍ");
		return retroiluminacion;
	}

	/*********************************************************MODELOS X MARCAS *******************************************************************/
	/********************PANTALLAS*******************/
	public static ArrayList<String> pantallasAcer() {
		ArrayList<String> pantallasAcer = new ArrayList<String>();
		pantallasAcer.add("Nitro XV272U Pbmiiprzx");
		pantallasAcer.add("Nitro XV272UP bmiiprzx");
		pantallasAcer.add("Nitro XV272U Wbmiiprzx");
		pantallasAcer.add("Predator XB273K Gbmiiprzx");
		return pantallasAcer;
	}

	public static ArrayList<String> pantallasDell() {
		ArrayList<String> pantallasDell = new ArrayList<String>();
		pantallasDell.add("S2422H");
		pantallasDell.add("U2723QE");
		pantallasDell.add("S3223DZ");
		pantallasDell.add("Alienware AW3423DW");
		return pantallasDell;
	}

	public static ArrayList<String> pantallasASUS() {
		ArrayList<String> pantallasASUS = new ArrayList<String>();
		pantallasASUS.add("VP249QGR");
		pantallasASUS.add("VG27AQ");
		pantallasASUS.add("ROG Strix XG32VQ");
		pantallasASUS.add("ROG Swift PG32UQ");
		return pantallasASUS;
	}

	public static ArrayList<String> pantallasLG() {
		ArrayList<String> pantallasLG = new ArrayList<String>();
		pantallasLG.add("27UL500-W");
		pantallasLG.add("27GL83A-B");
		pantallasLG.add("27GN950-B");
		pantallasLG.add("OLED48C1PUB");
		return pantallasLG;
	}

	public static ArrayList<String> pantallasSamsung() {
		ArrayList<String> pantallasSamsung = new ArrayList<String>();
		pantallasSamsung.add("LS24BG500FNLXZA");
		pantallasSamsung.add("LS27AG550NWLXZA");
		pantallasSamsung.add("LS34A550WNLXZA");
		pantallasSamsung.add("S95B");
		return pantallasSamsung;
	}
	/********************BOCINAS*******************/
	public static ArrayList<String> bocinasLogitech() {
		ArrayList<String> bocinasLogitech = new ArrayList<String>();
		bocinasLogitech.add("Z333");
		bocinasLogitech.add("Z533");
		bocinasLogitech.add("Z625");
		bocinasLogitech.add("Z906");
		return bocinasLogitech;
	}

	public static ArrayList<String> bocinasJBL() {
		ArrayList<String> bocinasJBL = new ArrayList<String>();
		bocinasJBL.add("Clip 4");
		bocinasJBL.add("Charge 5");
		bocinasJBL.add("Flip 6");
		bocinasJBL.add("Pulse 5");
		return bocinasJBL;
	}

	public static ArrayList<String> bocinasSony() {
		ArrayList<String> bocinasSony = new ArrayList<String>();
		bocinasSony.add("SRS-XB13");
		bocinasSony.add("SRS-XB33");
		bocinasSony.add("SRS-XB43");
		bocinasSony.add("HT-G700");
		return bocinasSony;
	}

	public static ArrayList<String> bocinasSennheiser() {
		ArrayList<String> bocinasSennheiser = new ArrayList<String>();
		bocinasSennheiser.add("HD 206");
		bocinasSennheiser.add("Momentum 3 Wireless");
		bocinasSennheiser.add("Momentum True Wireless 3");
		return bocinasSennheiser;
	}

	public static ArrayList<String> bocinasBose() {
		ArrayList<String> bocinasBose = new ArrayList<String>();
		bocinasBose.add("SoundLink Mini II");
		bocinasBose.add("SoundLink Revolve+");
		return bocinasBose;
	}
	/********************TECLADOS*******************/
	public static ArrayList<String> tecladosHyperX() {
		ArrayList<String> tecladosHyperX = new ArrayList<String>();
		tecladosHyperX.add("Alloy Origins Core");
		tecladosHyperX.add("Alloy Origins 60");
		tecladosHyperX.add("Pulsefire Raid");
		tecladosHyperX.add("Cloud Stinger Core");
		return tecladosHyperX;
	}

	public static ArrayList<String> tecladosLogitech() {
		ArrayList<String> tecladosLogitech = new ArrayList<String>();
		tecladosLogitech.add("K120");
		tecladosLogitech.add("G213 Prodigy");
		tecladosLogitech.add("G413 Carbon");
		tecladosLogitech.add("G915 Lightspeed");
		return tecladosLogitech;
	}

	public static ArrayList<String> tecladosSteelSeries() {
		ArrayList<String> tecladosSteelSeries = new ArrayList<String>();
		tecladosSteelSeries.add("Apex 3");
		tecladosSteelSeries.add("Apex 5");
		tecladosSteelSeries.add("Apex Pro");
		tecladosSteelSeries.add("Arctis 7");
		return tecladosSteelSeries;
	}

	public static ArrayList<String> tecladosCorsair() {
		ArrayList<String> tecladosCorsair = new ArrayList<String>();
		tecladosCorsair.add("K55 RGB");
		tecladosCorsair.add("K65 RGB Mini");
		tecladosCorsair.add("K70 RGB MK.2");
		tecladosCorsair.add("K100 RGB");
		return tecladosCorsair;
	}

	public static ArrayList<String> tecladosRazer() {
		ArrayList<String> tecladosRazer = new ArrayList<String>();
		tecladosRazer.add("BlackWidow Lite");
		tecladosRazer.add("Huntsman Mini");
		tecladosRazer.add("Huntsman Tournament Edition");
		tecladosRazer.add("Razer Viper Ultimate");
		return tecladosRazer;
	}
	/********************CHASIS*******************/
	public static ArrayList<String> chasisCoolerMaster() {
		ArrayList<String> chasisCoolerMaster = new ArrayList<String>();
		chasisCoolerMaster.add("MasterBox Q300L");
		chasisCoolerMaster.add("MasterBox Lite 5");
		chasisCoolerMaster.add("MasterBox TD500 Mesh");
		chasisCoolerMaster.add("MasterCase H500");
		return chasisCoolerMaster;
	}

	public static ArrayList<String> chasisThermaltake() {
		ArrayList<String> chasisThermaltake = new ArrayList<String>();
		chasisThermaltake.add("Versa H15");
		chasisThermaltake.add("V200 TG RGB");
		chasisThermaltake.add("Level 20 GT");
		chasisThermaltake.add("Core P5");
		return chasisThermaltake;
	}

	public static ArrayList<String> chasisFractalDesign() {
		ArrayList<String> chasisFractalDesign = new ArrayList<String>();
		chasisFractalDesign.add("Define 7");
		chasisFractalDesign.add("Meshify 2 Compact");
		chasisFractalDesign.add("Meshify 2 XL");
		chasisFractalDesign.add("Torrent Compact");
		return chasisFractalDesign;
	}

	public static ArrayList<String> chasisNZXT() {
		ArrayList<String> chasisNZXT = new ArrayList<String>();
		chasisNZXT.add("H510");
		chasisNZXT.add("H510 Elite");
		chasisNZXT.add("H710i");
		chasisNZXT.add("S340 Elite");
		return chasisNZXT;
	}

	public static ArrayList<String> chasisCorsair() {
		ArrayList<String> chasisCorsair = new ArrayList<String>();
		chasisCorsair.add("Carbide Series 275R");
		chasisCorsair.add("iCUE 4000X RGB");
		chasisCorsair.add("iCUE 5000X RGB");
		chasisCorsair.add("iCUE 7000X RGB");
		return chasisCorsair;
	}
	/********************FUENTES*******************/
	public static ArrayList<String> fuentesThermaltake() {
		ArrayList<String> fuentesThermaltake = new ArrayList<String>();
		fuentesThermaltake.add("Smart 500W");
		fuentesThermaltake.add("Toughpower GF1 750W");
		fuentesThermaltake.add("Toughpower GF1 850W");
		fuentesThermaltake.add("Toughpower GF1 1000W");
		return fuentesThermaltake;
	}

	public static ArrayList<String> fuentesBeQuiet() {
		ArrayList<String> fuentesBeQuiet = new ArrayList<String>();
		fuentesBeQuiet.add("System Power 9 500W");
		fuentesBeQuiet.add("System Power 9 600W");
		fuentesBeQuiet.add("Dark Power Pro 11 1200W");
		return fuentesBeQuiet;
	}

	public static ArrayList<String> fuentesEVGA() {
		ArrayList<String> fuentesEVGA = new ArrayList<String>();
		fuentesEVGA.add("SuperNOVA 550 G3");
		fuentesEVGA.add("SuperNOVA 650 G3");
		fuentesEVGA.add("SuperNOVA 750 G3");
		fuentesEVGA.add("SuperNOVA 1000 G3");
		return fuentesEVGA;
	}

	public static ArrayList<String> fuentesSeasonic() {
		ArrayList<String> fuentesSeasonic = new ArrayList<String>();
		fuentesSeasonic.add("Focus GX-550");
		fuentesSeasonic.add("Focus GX-650");
		fuentesSeasonic.add("Focus GX-750");
		fuentesSeasonic.add("Prime TX-1000");
		return fuentesSeasonic;
	}

	public static ArrayList<String> fuentesCorsair() {
		ArrayList<String> fuentesCorsair = new ArrayList<String>();
		fuentesCorsair.add("CX550F RGB");
		fuentesCorsair.add("RMx 750");
		fuentesCorsair.add("HX1000i");
		fuentesCorsair.add("AX1600i");
		return fuentesCorsair;
	}
	/********************TARJETASVIDEO*******************/
	public static ArrayList<String> tarjetasVideoAMD() {
		ArrayList<String> tarjetasVideoAMD = new ArrayList<String>();
		tarjetasVideoAMD.add("Radeon RX 6600");
		tarjetasVideoAMD.add("Radeon RX 6700 XT");
		tarjetasVideoAMD.add("Radeon RX 6800 XT");
		tarjetasVideoAMD.add("Radeon RX 6900 XT");
		return tarjetasVideoAMD;
	}

	public static ArrayList<String> tarjetasVideoGigabyte() {
		ArrayList<String> tarjetasVideoGigabyte = new ArrayList<String>();
		tarjetasVideoGigabyte.add("GeForce GTX 1650 OC");
		tarjetasVideoGigabyte.add("GeForce RTX 3060 Eagle OC");
		tarjetasVideoGigabyte.add("GeForce RTX 3070 Eagle OC");
		tarjetasVideoGigabyte.add("GeForce RTX 3080 Gaming OC");
		return tarjetasVideoGigabyte;
	}

	public static ArrayList<String> tarjetasVideoMSI() {
		ArrayList<String> tarjetasVideoMSI = new ArrayList<String>();
		tarjetasVideoMSI.add("GeForce GTX 1660 Super Ventus XS OC");
		tarjetasVideoMSI.add("GeForce RTX 3060 Ti Ventus 2X OC");
		tarjetasVideoMSI.add("GeForce RTX 3070 Gaming X Trio");
		tarjetasVideoMSI.add("GeForce RTX 3080 Gaming X Trio");
		return tarjetasVideoMSI;
	}

	public static ArrayList<String> tarjetasVideoASUS() {
		ArrayList<String> tarjetasVideoASUS = new ArrayList<String>();
		tarjetasVideoASUS.add("GeForce GTX 1660 Super Dual Evo OC");
		tarjetasVideoASUS.add("GeForce RTX 3060 Dual OC");
		tarjetasVideoASUS.add("GeForce RTX 3070 TUF Gaming OC");
		tarjetasVideoASUS.add("GeForce RTX 3080 TUF Gaming OC");
		return tarjetasVideoASUS;
	}

	public static ArrayList<String> tarjetasVideoNVIDIA() {
		ArrayList<String> tarjetasVideoNVIDIA = new ArrayList<String>();
		tarjetasVideoNVIDIA.add("GeForce RTX 4060");
		tarjetasVideoNVIDIA.add("GeForce RTX 4070");
		tarjetasVideoNVIDIA.add("GeForce RTX 4080");
		tarjetasVideoNVIDIA.add("GeForce RTX 4090");
		return tarjetasVideoNVIDIA;
	}
	/********************TARJETASMADRES*******************/
	public static ArrayList<String> tarjetasMadreASRock() {
		ArrayList<String> tarjetasMadreASRock = new ArrayList<String>();
		tarjetasMadreASRock.add("B660M-HDV");
		tarjetasMadreASRock.add("B660M-Pro RS");
		tarjetasMadreASRock.add("X670E Taichi");
		tarjetasMadreASRock.add("X670E Steel Legend");
		return tarjetasMadreASRock;
	}

	public static ArrayList<String> tarjetasMadreGigabyte() {
		ArrayList<String> tarjetasMadreGigabyte = new ArrayList<String>();
		tarjetasMadreGigabyte.add("B660M DS3H");
		tarjetasMadreGigabyte.add("B660M Aorus Elite AX");
		tarjetasMadreGigabyte.add("X670E Aorus Elite AX");
		tarjetasMadreGigabyte.add("X670E Aorus Master");
		return tarjetasMadreGigabyte;
	}

	public static ArrayList<String> tarjetasMadreMSI() {
		ArrayList<String> tarjetasMadreMSI = new ArrayList<String>();
		tarjetasMadreMSI.add("B660M-A Pro");
		tarjetasMadreMSI.add("B660M Mortar Wifi");
		tarjetasMadreMSI.add("X670E Carbon WiFi");
		tarjetasMadreMSI.add("X670E Godlike");
		return tarjetasMadreMSI;
	}

	public static ArrayList<String> tarjetasMadreASUS() {
		ArrayList<String> tarjetasMadreASUS = new ArrayList<String>();
		tarjetasMadreASUS.add("Prime B660M-A");
		tarjetasMadreASUS.add("TUF Gaming B660M-Plus WiFi");
		tarjetasMadreASUS.add("ROG Strix B660-G Gaming WiFi");
		tarjetasMadreASUS.add("ROG Maximus Z790 Hero");
		return tarjetasMadreASUS;
	}

	public static ArrayList<String> tarjetasMadreEVGA() {
		ArrayList<String> tarjetasMadreEVGA = new ArrayList<String>();
		tarjetasMadreEVGA.add("Z790 FTW");
		tarjetasMadreEVGA.add("Z790 FTW3");
		return tarjetasMadreEVGA;
	}
	/********************MEMORIAS*******************/
	public static ArrayList<String> memoriasCrucial() {
		ArrayList<String> memoriasCrucial = new ArrayList<String>();
		memoriasCrucial.add("Ballistix Sport LT");
		memoriasCrucial.add("Ballistix 3200 MHz");
		memoriasCrucial.add("Ballistix Max");
		memoriasCrucial.add("Ballistix 5600 MHz");
		return memoriasCrucial;
	}

	public static ArrayList<String> memoriasKingston() {
		ArrayList<String> memoriasKingston = new ArrayList<String>();
		memoriasKingston.add("Kingston ValueRAM");
		memoriasKingston.add("Kingston Fury Renegade");
		memoriasKingston.add("Kingston Server Premier");		
		memoriasKingston.add("Kingston SO-DIMM");
		return memoriasKingston;
	}

	public static ArrayList<String> memoriasHyperX() {
		ArrayList<String> memoriasHyperX = new ArrayList<String>();
		memoriasHyperX.add("HyperX Fury");
		memoriasHyperX.add("HyperX Predator");
		memoriasHyperX.add("HyperX Fury Beast");
		memoriasHyperX.add("HyperX Predator");
		return memoriasHyperX;
	}

	public static ArrayList<String> memoriasGSkill() {
		ArrayList<String> memoriasGSkill = new ArrayList<String>();
		memoriasGSkill.add("Aegis");
		memoriasGSkill.add("Trident Z Neo");
		memoriasGSkill.add("Trident Z5");
		memoriasGSkill.add("Trident Z5 Neo");
		return memoriasGSkill;
	}

	public static ArrayList<String> memoriasCorsair() {
		ArrayList<String> memoriasCorsair = new ArrayList<String>();
		memoriasCorsair.add("Vengeance LPX");
		memoriasCorsair.add("Vengeance RGB Pro");
		memoriasCorsair.add("Dominator Platinum RGB");
		return memoriasCorsair;
	}
	/********************DISCOSDUROS*******************/
	public static ArrayList<String> discosToshiba() {
		ArrayList<String> discosToshiba = new ArrayList<String>();
		discosToshiba.add("Canvio Basics");
		discosToshiba.add("Canvio Advance");
		discosToshiba.add("N300");
		discosToshiba.add("MG08 Series");
		return discosToshiba;
	}

	public static ArrayList<String> discosCrucial() {
		ArrayList<String> discosCrucial = new ArrayList<String>();
		discosCrucial.add("MX500");
		discosCrucial.add("P1");
		discosCrucial.add("P5 Plus");
		return discosCrucial;
	}

	public static ArrayList<String> discosWD() {
		ArrayList<String> discosWD = new ArrayList<String>();
		discosWD.add("My Passport");
		discosWD.add("My Book");
		discosWD.add("Blue");
		discosWD.add("Black");
		return discosWD;
	}

	public static ArrayList<String> discosSeagate() {
		ArrayList<String> discosSeagate = new ArrayList<String>();
		discosSeagate.add("Backup Plus");
		discosSeagate.add("Expansion");
		discosSeagate.add("BarraCuda");
		discosSeagate.add("IronWolf");
		return discosSeagate;
	}
	public static ArrayList<String> discosSamsung() {
		ArrayList<String> discosSamsung = new ArrayList<String>();
		discosSamsung.add("T5");
		discosSamsung.add("T7");
		discosSamsung.add("970 EVO Plus");
		discosSamsung.add("990 PRO");
		return discosSamsung;
	}
	/********************MICROPROCESADORES*******************/
	public static ArrayList<String> microprocesadoresAMD() {
		ArrayList<String> microprocesadoresAMD = new ArrayList<String>();
		microprocesadoresAMD.add("Ryzen 5 5600X");
		microprocesadoresAMD.add("Ryzen 7 5800X3D");
		microprocesadoresAMD.add("Ryzen 9 5900X");
		microprocesadoresAMD.add("Ryzen 9 7900X");
		return microprocesadoresAMD;
	}

	public static ArrayList<String> microprocesadoresIntel() {
		ArrayList<String> microprocesadoresIntel = new ArrayList<String>();
		microprocesadoresIntel.add("Core i3-12100F");
		microprocesadoresIntel.add("Core i5-12600K");
		microprocesadoresIntel.add("Core i7-13700K");
		microprocesadoresIntel.add("Core i9-13900K");
		return microprocesadoresIntel;
	}
	/********************MOUSE*******************/
	public static ArrayList<String> mouseHyperX() {
		ArrayList<String> mouseHyperX = new ArrayList<String>();
		mouseHyperX.add("Pulsefire Core");
		mouseHyperX.add("Pulsefire Surge");
		mouseHyperX.add("Pulsefire Haste");
		mouseHyperX.add("Pulsefire Dart");
		return mouseHyperX;
	}

	public static ArrayList<String> mouseLogitech() {
		ArrayList<String> mouseLogitech = new ArrayList<String>();
		mouseLogitech.add("G203 LIGHTSYNC");
		mouseLogitech.add("G305 LIGHTSPEED");
		mouseLogitech.add("G502 LIGHTSPEED");
		mouseLogitech.add("G PRO X SUPERLIGHT");
		return mouseLogitech;
	}

	public static ArrayList<String> mouseSteelSeries() {
		ArrayList<String> mouseSteelSeries = new ArrayList<String>();
		mouseSteelSeries.add("Rival 3");
		mouseSteelSeries.add("Rival 3 Wireless");
		mouseSteelSeries.add("Rival 5");
		mouseSteelSeries.add("Aerox 3 Wireless");
		return mouseSteelSeries;
	}

	public static ArrayList<String> mouseCorsair() {
		ArrayList<String> mouseCorsair = new ArrayList<String>();
		mouseCorsair.add("Harpoon RGB Wireless");
		mouseCorsair.add("Katar Pro XT");
		mouseCorsair.add("IronClaw RGB");
		mouseCorsair.add("Dark Core RGB Pro SE");
		return mouseCorsair;
	}

	public static ArrayList<String> mouseRazer() {
		ArrayList<String> mouseRazer = new ArrayList<String>();
		mouseRazer.add("Viper Mini");
		mouseRazer.add("Viper Ultimate");
		mouseRazer.add("Basilisk Ultimate");
		mouseRazer.add("DeathAdder V3 Pro");
		return mouseRazer;
	}
	public static ArrayList<String> eficiencia() {
		ArrayList<String> eficiencias = new ArrayList<String>();
		eficiencias.add("80 PLUS");
		eficiencias.add("Bronze");
		eficiencias.add("Silver");
		eficiencias.add("Gold");
		eficiencias.add("Platinum");
		return eficiencias;
	}
}
