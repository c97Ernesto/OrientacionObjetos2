package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Lagarto implements Jugada {

	@Override
	public String jugarContra(Jugada otraJugada) {
		return otraJugada.contraLagarto();
	}

	@Override
	public String contraPiedra() {
		return "Gana Piedra";
	}

	@Override
	public String contraPapel() {
		return "Gana Lagarto";
	}

	@Override
	public String contraTijera() {
		return "Gana Tijera";
	}

	@Override
	public String contraLagarto() {
		return "Empate";
	}

	@Override
	public String contraSpock() {
		return "Gana Lagarto";
	}

}
