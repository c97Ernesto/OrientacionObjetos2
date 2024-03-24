package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Spock implements Jugada {

	@Override
	public String jugarContra(Jugada otraJugada) {
		return otraJugada.contraSpock();
	}

	@Override
	public String contraPiedra() {
		return "Gana Spock";
	}

	@Override
	public String contraPapel() {
		return "Gana Papel";
	}

	@Override
	public String contraTijera() {
		return "Gana Spock";
	}

	@Override
	public String contraLagarto() {
		return "Gana Lagarto";
	}

	@Override
	public String contraSpock() {
		return "Empate";
	}

}
