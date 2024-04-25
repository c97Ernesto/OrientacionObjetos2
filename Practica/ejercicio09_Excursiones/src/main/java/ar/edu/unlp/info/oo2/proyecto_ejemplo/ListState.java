package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public abstract class ListState {

	protected Excursion excursion;
	
	public ListState(Excursion excursion) {
		this.excursion = excursion;
	}

	public Excursion getExcursion() {
		return excursion;
	}

	public abstract void inscribirUsuario(Persona persona);
	
	public abstract String infoDeEstadoExcursion();
}
