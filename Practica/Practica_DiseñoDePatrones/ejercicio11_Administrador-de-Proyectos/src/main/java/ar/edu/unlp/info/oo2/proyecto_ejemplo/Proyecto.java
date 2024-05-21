package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Proyecto {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String objetivo;
	private int numeroDeIntegrantes;
	private double montoPorIntegrante;
	private double margenDeGanancia;
	private Etapa etapaDelProyecto;
	
	public Proyecto(LocalDate fechaInicio, LocalDate fechaFin, String objetivo, int cantIntegrantes, double montoPorIntegrante) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.setObjetivo(objetivo);
		this.setMargenDeGanancia(7);
		this.numeroDeIntegrantes = cantIntegrantes;
		this.montoPorIntegrante = montoPorIntegrante;
		
		setEtapaDelProyecto(new EnConstruccion(this));
	}
	
	//actualizarEstado(), changeState()
	public void setEtapaDelProyecto(Etapa nuevaEtapa) {
		this.etapaDelProyecto = nuevaEtapa;
	}
	
	//APROBAR ETAPA
	public void aprobarEtapa() {
		this.etapaDelProyecto.aprobarEtapa();
	}

	//COSTO DEL PROYECTO
	public double costoDelProyecto() {
		return this.etapaDelProyecto.costoDelProyecto();
	}

	//PRECIO DEL PROYECTO
	public double precioDelProyecto() {
		return this.etapaDelProyecto.precioDelProyecto();
	}
	
	//MODIFICAR MARGEN DE GANANCIA
	public void modificarMargenDeGanancia(double nuevoMargenDeGanancia) {
		this.etapaDelProyecto.modificarMargenDeGanancia(nuevoMargenDeGanancia);
	}
	
	//CANCELAR PROYECTO
	public void cancelarProyecto() {
		this.etapaDelProyecto.cancelarProyecto();
	}
	
	public long duracionDelProyecto() {
		return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
	}
	
	public double costoEnPersonal() {
		return this.montoPorIntegrante * this.numeroDeIntegrantes;
	}
	
	public double getMargenDeGanancia() {
		return margenDeGanancia;
	}

	public void setMargenDeGanancia(double margenDeGanancia) {
		this.margenDeGanancia = margenDeGanancia;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
}

