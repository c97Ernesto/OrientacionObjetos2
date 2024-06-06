package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {

	private List<Pelicula> grilla;
	
	private List<Pelicula> reproducidas;
	
	private ConfiguracionDecodificador strategy;
	
	public Decodificador() {
		grilla = new ArrayList<Pelicula>();
		reproducidas = new ArrayList<Pelicula>();
	}
	
	public List<Pelicula> getGrilla() {
		return grilla;
	}

	public List<Pelicula> getReproducidas() {
		return reproducidas;
	}

	public ConfiguracionDecodificador getStrategy() {
		return strategy;
	}

	//Por lo general se puede cargar una estrategia a través del constructor
	//ademàs de agregar tener el setter para cambiar la configuración en
	//tiempo de ejecución
	public void cambiarConfiguracion(ConfiguracionDecodificador strategy) {
		this.strategy = strategy;
	}
	
	
	//Se delega parte del trabajo al objeto de strategia en lugar
	//de implementar varias versiones del algoritmo por cuenta propia
	public List<Pelicula> sugerencias(){
		return this.strategy.sugerencias(this);
	}
	
}
