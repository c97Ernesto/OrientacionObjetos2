package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.Duration;
import java.time.LocalDate;

public class InProgress extends ToDoItemState{
	private static final String NOMBRE_ESTADO = "InProgress";

	public InProgress(ToDoItem state) {
		super(state, getNombreEstado());
		state.setFechaInicio(LocalDate.now());
	}
	
	public static String getNombreEstado() {
		return NOMBRE_ESTADO;
	}

	@Override
	public void togglePaused() {
		this.tarea.actualizarEstado(new Paused(this.tarea));
	}

	@Override
	public void finish() {
		this.tarea.actualizarEstado(new Finished(tarea));
	}

	@Override
	public Duration workedTime() {
		return super.workedTime();
	}

	@Override
	public void addComment(String comment) {
		this.tarea.addComment(comment);
	}

	@Override
	public void start() {
		
	}

}
