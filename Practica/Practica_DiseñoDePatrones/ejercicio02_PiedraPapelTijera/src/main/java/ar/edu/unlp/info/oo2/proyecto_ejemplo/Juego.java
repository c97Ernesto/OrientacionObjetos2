package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Juego {

	
	public Juego() {
		// TODO Auto-generated constructor stub
	}
	

	public String comenzar(Jugada jugador1, Jugada jugador2) {
		return jugador1.jugarContra(jugador2);
	}
	
}
