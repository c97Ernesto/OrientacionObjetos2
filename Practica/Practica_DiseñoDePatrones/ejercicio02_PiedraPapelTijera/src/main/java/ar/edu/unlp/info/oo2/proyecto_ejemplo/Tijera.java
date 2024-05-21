package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Tijera implements Jugada {

	@Override
	public String jugarContra(Jugada otraJugada) {
		return otraJugada.contraTijera();
	}

	@Override
	public String contraPiedra() {
		return "Gana Piedra";
	}

	@Override
	public String contraPapel() {
		return "Gana Tijera";
	}

	@Override
	public String contraTijera() {
		return "Empate";
	}

	@Override
	public String contraLagarto() {
		return "Gana Tijera";
	}

	@Override
	public String contraSpock() {
		return "Gana Spock";
	}

}
