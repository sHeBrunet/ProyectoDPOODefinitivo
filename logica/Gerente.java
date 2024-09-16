package logica;

import java.time.LocalDate;

public class Gerente extends Trabajador {
	private LocalDate fechaOcupCargo;
	
	public Gerente(String string, String nombre, String apellidos, String cI, float salarioB, String nivelEscolar, String cargo,LocalDate fecha1) {
		super(string, nombre, apellidos, cI, salarioB, nivelEscolar, cargo);
		setFechaOcupCargo(fecha1);
	}

	public LocalDate getFechaOcupCargo() {
		return fechaOcupCargo;
	}

	public void setFechaOcupCargo(LocalDate fecha1) {
		this.fechaOcupCargo = fecha1;
	}

}
