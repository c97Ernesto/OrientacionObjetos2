package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class ListaCompleta extends ListState {

	public ListaCompleta(Excursion excursion) {
		super(excursion);
	}

	
	/*
	 * Con la lista completa se seguirán agregando personas pero a la 
	 * lista de espera.
	 * */
	@Override
	public void inscribirUsuario(Persona persona) {
		this.excursion.getListaDeEspera().add(persona);
	}


	@Override
	public String infoDeEstadoExcursion() {
		return this.excursion.infoBasicaDeExcursion();
	}

}
