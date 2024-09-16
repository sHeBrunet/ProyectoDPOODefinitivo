package logica;
import java.util.ArrayList;

import inicializaciones.InicializacionDeDatos;
public class Trabajador {
	private String id;
	private String nombre;
	private String apellidos;
	private String CI;
	private float salarioBasico;
	private String nivelEscolar;
	private String cargo;


	public Trabajador(String id,String nombre, String apellidos, String cI, float salarioBasico, String nivelEscolar,
			String cargo) {
		this.id = id;
		setNombre(nombre);
		setApellidos(apellidos);
		setCI(cI);
		setSalarioBasico(salarioBasico);
		setNivelEscolar(nivelEscolar);
		setCargo(cargo);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre != null && nombre != "") {
			this.nombre = nombre;
		}
		else {
			throw new IllegalArgumentException("El nombre del trabajador no puede estar vacio");
		}	
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		if(apellidos != null && apellidos != "") {
			this.apellidos = apellidos;
		}
		else {
			throw new IllegalArgumentException("Los apellidos del trabajador no pueden estar vacio");
		}
	}
	public String getCI() {
		return CI;
	}
	public void setCI(String cI) {
		int anioNacimiento = Integer.parseInt(cI.substring(0, 2));
		int mesNacimiento = Integer.parseInt(cI.substring(2, 4));
		int diaNacimiento = Integer.parseInt(cI.substring(4, 6));

		if(!cI.equals(null)) {
			if (cI.length() == 11) {
				if (validarAnio(cI.substring(0, 2).toCharArray())) {
					if (mesNacimiento >= 1 || mesNacimiento <= 12) {
						if (validarDia(anioNacimiento, mesNacimiento, diaNacimiento)) {
							this.CI = cI;
						}
						else {
							throw new IllegalArgumentException("El día de nacimiento no es válido para el mes y año dados.");	
						}
					}

					else {
						throw new IllegalArgumentException("El mes de nacimiento debe estar entre 01 y 12.");
					}
				}
				else{
					throw new IllegalArgumentException("Solo se admiten trabajadores nacidos entre 1960 y 2005.");
				}
			}
			else {
				throw new IllegalArgumentException("El carnet debe tener exactamente 11 dígitos numéricos.");
			}
		}
		else {
			throw new IllegalArgumentException("El carnet del trabajador no pueden estar vacíos");

		}
	}

	public boolean validarDia(int anio, int mes, int dia) {
		// Días por mes
		int diasPorMes = 0;
		switch (mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			diasPorMes = 31;
			break;
		case 4: case 6: case 9: case 11:
			diasPorMes = 30;
			break;
		case 2:
			// Verificar si es año bisiesto
			if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
				diasPorMes = 29; // Año bisiesto
			}
			else {
				diasPorMes = 28; // No es bisiesto
			}
			break;
		default:
			break;
		}
		return dia >= 1 && dia <= diasPorMes; // Validar el rango del día
	}
	
	public boolean validarAnio(char anio[]) {
		boolean valido = true;
		if(anio[0] > '0' && anio[0] <= '5') {
			valido = false;
		} else if(anio[0] == '0' && anio[1] >= '6') {
			valido = false;
		}		
		return valido;
	}

	public String getNumero() {
		return id;
	}

	public float getSalarioBasico() {
		return salarioBasico;
	}
	public  void setSalarioBasico(float salarioBasicoN) {
		if(salarioBasicoN > 0) {
			salarioBasico = salarioBasicoN;
		}
		else {
			throw new IllegalArgumentException("El salario básico debe de ser mayor que cero");
		}
	}
	public String getNivelEscolar() {
		return nivelEscolar;
	}
	public void setNivelEscolar(String nivelEscolar) {
		boolean correcto = false;
		ArrayList<String> niveles = new ArrayList<String>();
		niveles = InicializacionDeDatos.nivelesEscolar();
		for(String r: niveles) {
			if(nivelEscolar.equalsIgnoreCase(r)) {
				correcto = true;
				this.nivelEscolar = nivelEscolar;
			}
		}
		if(!correcto) {
			throw new IllegalArgumentException("El nivel escolar debe de ser de tipo (Primaria, Secundaria, Técnico Medio, Bachillerato, Universitario)");
		}
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		boolean correcto = false;
		ArrayList<String> cargos = new ArrayList<String>();
		cargos = InicializacionDeDatos.cargos();
		for(String r: cargos) {
			if(cargo.equalsIgnoreCase(r)) {
				correcto = true;
				this.cargo = cargo;
			}
		}
		if(!correcto) {
			throw new IllegalArgumentException("El cargo debe de ser de tipo (Auxiliar de Limpieza, , Cajero, Asistente, Técnico, Diseñador, Economico, Gerente)");
		}

	}


}
