package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Excursion {

	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMin;
	private int cupoMax;
	
	private List<Persona> listaDeInscriptos;
	
	private List<Persona> listaDeEspera;

	private ListState estado;

	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo,
			int cupoMin, int cupoMax) {
		this.nombre = nombre;
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
		this.setPuntoEncuentro(puntoEncuentro);
		this.setCosto(costo);
		this.cupoMin = cupoMin;
		this.cupoMax = cupoMax;
		this.actualizarEstado(new ListaProvisoria(this));
		this.listaDeInscriptos = new ArrayList<Persona>();
		this.listaDeEspera = new ArrayList<Persona>();
	}

	/*
	 * setEstado()
	 * */
	public void actualizarEstado(ListState estado) {
		this.estado = estado;
	}
	
	/*
	 * Se agregan personas a la lista de incriptos o de espera según el 
	 * estado en el que se encuentre la inscripción*/
	public void inscribirUsuario(Persona usuario) {
		this.estado.inscribirUsuario(usuario);
	}
	
	public String obtenerInformacion() {
		return this.estado.infoDeEstadoExcursion();
	}
	
	public String infoBasicaDeExcursion() {
		String info = "Nombre Excursión: " + this.getNombre() + "\n"
				+ " Costo: " + this.getCosto() + "\n"
				+ " Fecha de Inicio: " + this.getFechaInicio() + "\n" 
				+ " Fecha de Fin: " + this.getFechaFin() + "\n"
				+ " Punto de Encuentro: " + this.getPuntoEncuentro() + "\n";
		return info;
	}
	
	public List<String> emailsDeInscriptos() {
		return this.getListaDeInscriptos().stream()
				.map(inscripto -> inscripto.getEmail())
				.collect(Collectors.toList());	
	}
	
	public boolean cupoMinAlcanzado() {
		return this.listaDeInscriptos.size() > this.getCupoMin();
		
	}
	public boolean cupoMaxAlcanzado() {
		return this.listaDeInscriptos.size() > this.getCupoMax();
	}
	
	public List<Persona> getListaDeInscriptos() {
		return listaDeInscriptos;
	}

	public List<Persona> getListaDeEspera() {
		return listaDeEspera;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getPuntoEncuentro() {
		return puntoEncuentro;
	}

	public void setPuntoEncuentro(String puntoEncuentro) {
		this.puntoEncuentro = puntoEncuentro;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getCupoMin() {
		return cupoMin;
	}

	public int getCupoMax() {
		return cupoMax;
	}

	
}
