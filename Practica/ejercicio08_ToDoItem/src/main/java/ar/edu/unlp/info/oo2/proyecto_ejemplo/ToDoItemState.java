package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Interface común a todos lo estados.
 */

public abstract class ToDoItemState {

	protected ToDoItem tarea;
	
    /**
     * Context se pasa a si mismo a través del contructor de State. 
     */
	public ToDoItemState(ToDoItem tarea, String nameState) {
		this.tarea = tarea;
		this.tarea.setNameState(nameState);
	}
	
	// si la tarea a la cual le asignamos el método start() no estaba en estado pendiente, generamos un error
	// también se puede dejar como método abstracto y que no haga absolutamente nada.
	public abstract void start();
	
	public abstract void togglePaused();
	
	public abstract void finish();
	
	public Duration workedTime() {
		return Duration.between(this.tarea.getFechaInicio(), LocalDate.now());
	}
	
	public abstract void addComment(String comment);
}