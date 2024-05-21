package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Papel implements Jugada {

	@Override
	public String jugarContra(Jugada otraJugada) {
		return otraJugada.contraPapel();
	}

	@Override
	public String contraPiedra() {
		return "Gana Papel";
	}

	@Override
	public String contraPapel() {
		return "Empate";
	}

	@Override
	public String contraTijera() {
		return "Gana Tijera";
	}

	@Override
	public String contraLagarto() {
		return "Gana Lagarto";
	}

	@Override
	public String contraSpock() {
		return "Gana Papel";
	}

}
