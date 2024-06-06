package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {

	private String titulo;
	private String anioEstreno;
	private List<Pelicula> similares;
	private int puntaje;
	
	
	public Pelicula (String titulo, String anioEstreno){
		this.titulo = titulo;
		this.anioEstreno = anioEstreno;
		this.similares = new ArrayList<Pelicula>();
	}
	
	public List<Pelicula> getSimilares() {
		return similares;
	}

	public String getAnioEstreno() {
		return anioEstreno;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
	
}
