package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugarTest {
	
	Juego juego;
	Jugada jugador1;
	Jugada jugador2;
	Jugada jugador3;

	@BeforeEach
	void setUp() throws Exception{
		juego = new Juego();
	}
	
	@Test
	void testGanaPiedra() {
		jugador1 = new Piedra();
		
		jugador2 = new Tijera();
		jugador3 = new Lagarto();
		
		
		assertEquals("Gana Piedra", juego.comenzar(jugador1, jugador2));
		assertEquals("Gana Piedra", juego.comenzar(jugador1, jugador3));
		
	}
	
	@Test
	void testPierdePiedra() {
		jugador1 = new Piedra();
		
		jugador2 = new Papel();
		jugador3 = new Spock(); 
		
		assertEquals("Gana Papel", juego.comenzar(jugador1, jugador2));
		assertEquals("Gana Spock", juego.comenzar(jugador1, jugador3));
		
	}
	
}
