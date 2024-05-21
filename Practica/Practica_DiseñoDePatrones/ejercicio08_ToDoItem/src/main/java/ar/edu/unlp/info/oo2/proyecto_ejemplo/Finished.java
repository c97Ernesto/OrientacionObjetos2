package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.Duration;
import java.time.LocalDate;

public class Finished extends ToDoItemState{
	private static final String NOMBRE_ESTADO = "Finished"; 

	public Finished(ToDoItem state) {
		super(state, getNombreEstado());
		state.setFechaFin(LocalDate.now());
	}
	
	public static String getNombreEstado() {
		return NOMBRE_ESTADO;
	}
	
	@Override
	public void togglePaused() {
		throw new RuntimeException("La tarea se encuentra Finalizada, no se puede pausar.");
		
	}

	@Override
	public Duration workedTime() {
		return Duration.between(this.tarea.getFechaInicio(), this.tarea.getFechaFin());
	}

	@Override
	public void addComment(String comment) {
		
	}

	@Override
	public void start() {
		
	}

	@Override
	public void finish() {
		
	}

}
