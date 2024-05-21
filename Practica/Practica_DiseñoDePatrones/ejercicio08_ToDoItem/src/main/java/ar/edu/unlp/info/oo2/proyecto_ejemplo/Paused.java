package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.Duration;

public class Paused extends ToDoItemState{
	private static final String NOMBRE_ESTADO = "Paused";

	public Paused(ToDoItem state) {
		super(state, getNombreEstado());
	}
	
	public static String getNombreEstado() {
		return NOMBRE_ESTADO;
	}

	@Override
	public void start() {
	}

	@Override
	public void togglePaused() {
		this.tarea.actualizarEstado(new InProgress(tarea));
		
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
}
