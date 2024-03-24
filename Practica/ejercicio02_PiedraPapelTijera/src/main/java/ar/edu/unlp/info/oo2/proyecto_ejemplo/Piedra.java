package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Piedra implements Jugada {

	@Override
	public String jugarContra(Jugada otraJugada) {
		return otraJugada.contraPiedra();
	}

	@Override
	public String contraPiedra() {
		return "Empate";
	}

	@Override
	public String contraPapel() {
		return "Gana Papel";
	}

	@Override
	public String contraTijera() {
		return "Gana Piedra";
	}

	@Override
	public String contraLagarto() {
		return "Gana Piedra";
	}

	@Override
	public String contraSpock() {
		return "Gana Spock";
	}

}
