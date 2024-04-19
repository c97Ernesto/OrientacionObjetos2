package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//Context
public class ToDoItem {
	
	private String nameTask;
	
	private ToDoItemState state;
	
	private String nameState;
	
	private LocalDate fechaInicio;
	
	private LocalDate fechaFin;
	
	private List<String> comments;

	/**
	* Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
	*/
	public ToDoItem(String nameTask) {
		this.state = new Pending(this);
		this.nameTask = nameTask;
		this.setNameState(nameState);
		
		this.comments = new ArrayList<String>();
	}
	
	//setState(), changeState()
	public void actualizarEstado(ToDoItemState nuevoEstado) {
		this.state = nuevoEstado;
	}
	
	/**
	* Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
	* pending. Si se encuentra en otro estado, no hace nada.
	*/
	public void start() {
		this.state.start();
	}

	/**
	 * Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress si
	 * estado es paused. Caso contrario (pending o finished) genera un error
	 * informando la causa específica del mismo.
	*/
	public void togglePause() {
		this.state.togglePaused();
	}
	
	/**
	* Pasa el ToDoItem a finished, siempre y cuando su estado actual sea
	* in-progress o paused. Si se encuentra en otro estado, no hace nada.
	*/
	public void finish() {
		this.state.finish();
	}

	/**
	* Retorna el tiempo que transcurrió desde que se inició el ToDoItem (start)
	* hasta que se finalizó. En caso de que no esté finalizado, el tiempo que
	* haya transcurrido hasta el momento actual. Si el ToDoItem no se inició,
	* genera un error informando la causa específica del mismo.
	*/
	public Duration workedTime() {
		return this.state.workedTime();
	}
	
	/**
	* Agrega un comentario al ToDoItem siempre y cuando no haya finalizado.
	* Caso contrario no hace nada."
	*/
	public void addComment(String comment) {
		
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNameTask() {
		return nameTask;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}
	
}
