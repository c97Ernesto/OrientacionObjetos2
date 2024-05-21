package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTest {
	Empleado temporario;
	Empleado pasante;
	Empleado planta;
	double adicional;
	double basico;
	double descuento;
	double total;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEmpleadoPasante() {
		//
		pasante = new Pasante(4);

		basico = (20000);
		assertEquals(basico, pasante.basico());

		adicional = (2000 * 4);
		assertEquals(adicional, pasante.adicional());

		descuento = ((basico * 0.13) + (adicional * 0.05));
		assertEquals(descuento, pasante.descuento());

		total = basico + adicional - descuento;
		assertEquals(total, pasante.sueldo());
	}
	
	@Test
	void testEmpleadoPlanta() {
		//
		planta = new Planta(true, 7, 27);

		basico = (50000);
		assertEquals(basico, planta.basico());

		adicional = (5000 + (2000 * 7) + (2000 * 27));
		assertEquals(adicional, planta.adicional());

		descuento = ((basico * 0.13) + (adicional * 0.05));
		assertEquals(descuento, planta.descuento());

		total = basico + adicional - descuento;
		assertEquals(total, planta.sueldo());
	}

	@Test
	void testEmpleadoTemporario() {
		// casado, 2 hijos, 3 horas trabajadas
		temporario = new Temporario(true, 2, 3);

		basico = (20000 + (3 * 300));
		adicional = (5000 + (2000 * 2));
		descuento = ((basico * 0.13) + (adicional * 0.05));
		total = basico + adicional - descuento;

		assertEquals(total, temporario.sueldo());
	}

}
