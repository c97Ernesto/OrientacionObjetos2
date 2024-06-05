package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class PersonajeProduct {
	
	private String nombre;
	private int salud;
	private Arma arma;
	private Armadura armadura;
	private List<Habilidad> habilidades = new ArrayList<Habilidad>();
	
	public PersonajeProduct(String nombre) {
		this.salud = 100;
	}

	public void atacar(PersonajeProduct otroPersonaje) {
		if (this.getSalud() > 0) {
			otroPersonaje.setSalud(this.getSalud() - this.getArma().golpearArmadura(otroPersonaje.getArmadura()));	
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalud() {
		return salud;
	}

	private void setSalud(int salud) {
		this.salud = salud;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}
	
	
}
