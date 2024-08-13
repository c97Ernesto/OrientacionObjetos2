package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.Duration;

public class Pending extends ToDoItemState{
	private static final String NOMBRE_ESTADO = "Pending";

	public Pending(ToDoItem tarea) {
		super(tarea, getNombreEstado());
		// TODO Auto-generated constructor stub
	}
	
	public static String getNombreEstado() {
		return NOMBRE_ESTADO;
	}

	@Override
	public void start() {
		//pasamos la terea que estaba en modo Pendiente, al nuevo modo EnProgresso.
		this.tarea.actualizarEstado(new InProgress(this.tarea));
	}
	
	@Override
	public void togglePaused() {
		throw new RuntimeException("La tarea se encuentra en estado 'Pendiente' no se puede pausar.");
		
	}

	@Override
	public Duration workedTime() {
		throw new RuntimeException("La tarea se encuentra en estado Pendiente, nunca se inició.");	
	}

	@Override
	public void finish() {
		
	}

	@Override
	public void addComment(String comment) {
		this.tarea.addComment(comment);
	}	
	
}
