package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExcursionTest {

	Excursion excursion = new Excursion("Dos días en kayak bajando el Paraná", LocalDate.of(2001, 1, 1), LocalDate.of(2001, 1, 3), 
			"Balneario", 30000, 1, 2);
	
	Persona p1 = new Persona("Marco", "Polo", "marcoPolo@gmail.com");
	Persona p2 = new Persona("Lalo", "Landa", "LaloLanda@gmail.com");
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testListaProvisoria() {
		System.out.println(excursion.obtenerInformacion());
		System.out.println();
		
		excursion.inscribirUsuario(p1);
		
		System.out.println(excursion.obtenerInformacion());
		System.out.println();

		excursion.inscribirUsuario(p2);
		
		System.out.println(excursion.obtenerInformacion());
		System.out.println();
		
		excursion.inscribirUsuario(new Persona("Edinson", "Cavani", "ÉL9@gamil.com"));
		
		System.out.println(excursion.obtenerInformacion());
	}

}
