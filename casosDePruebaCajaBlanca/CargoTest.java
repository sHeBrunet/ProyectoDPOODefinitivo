package casosDePruebaCajaBlanca;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import inicializaciones.InicializacionDeDatos;
import logica.Trabajador;

public class CargoTest {

    @Test
    public void testSetCargoValido() {
        Trabajador trabajador = new Trabajador("MG93", "María", "Gómez Gónzalez", "93052789095", 4000,"Preuniversitario", "Asistente");
        trabajador.setCargo("Cajero");
        assertEquals("Cajero", trabajador.getCargo());
    }

    @Test
    public void testSetCargoInvalido() {
        Trabajador trabajador = new Trabajador("MG93", "María", "Gómez Gónzalez", "93052789095", 4000,"Preuniversitario", "Asistente");
        trabajador.setCargo("Cajero");
        assertEquals("Cajero", trabajador.getCargo());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            trabajador.setCargo("Desarrollador");
        });

        String expectedMessage = "El cargo debe de ser de tipo (Auxiliar de Limpieza, , Cajero, Asistente, Técnico, Diseñador, Economico, Gerente)";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
