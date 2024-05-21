package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public interface Jugada {

	public String jugarContra(Jugada otraJugada);
	
	public String contraPiedra();
	
	public String contraPapel();
	
	public String contraTijera();
	
	public String contraLagarto();
	
	public String contraSpock();
	
}
