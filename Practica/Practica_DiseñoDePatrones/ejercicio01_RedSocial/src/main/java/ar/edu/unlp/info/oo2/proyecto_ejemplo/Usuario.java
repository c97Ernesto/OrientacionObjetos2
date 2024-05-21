package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String screenName;
	
	private List<Tuit> tuits;
	
	public Usuario (String screenName) {
		this.screenName = screenName;
		this.tuits = new ArrayList<Tuit>();
	}
	
	public Tuit postearTuit(String texto) {
		Tuit tuit = new Tuit();
		if (verificarTexto(texto)) {
			tuit.setText(texto);
			this.agregarTuit(tuit);
		}
		return tuit;
	}
	
	public void agregarTuit(Tuit tuit) {
		this.tuits.add(tuit);
	}
	
	public boolean verificarTexto(String texto) {
		return texto.length() > 1 && texto.length() < 281;
	}
	
}
