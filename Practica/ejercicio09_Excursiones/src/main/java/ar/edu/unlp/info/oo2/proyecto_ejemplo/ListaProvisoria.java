package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class ListaProvisoria extends ListState{

	public ListaProvisoria(Excursion excursion) {
		super(excursion);
	}

	
	/*
	 * Si no se alcanzó el cupo mínimo de personas la lista 
	 * seguirá siendo provisoria, hasta que se alcance el cupo
	 * y pasará a ser una lista Definitiva.
	 * */
	@Override
	public void inscribirUsuario(Persona persona) {
		this.excursion.getListaDeInscriptos().add(persona);
		if (this.excursion.cupoMinAlcanzado())
			this.excursion.actualizarEstado(new ListaDefinitiva(this.excursion));
	}


	@Override
	public String infoDeEstadoExcursion() {
		String info = this.excursion.infoBasicaDeExcursion();
		info+= "Cantidad de Usuarios: " + this.excursion.getListaDeInscriptos().size() + "\n"
				+ "Faltantes para el cupo mínimo: " 
				+ (this.excursion.getCupoMin() - this.excursion.getListaDeInscriptos().size());
		return info;
	}
}
