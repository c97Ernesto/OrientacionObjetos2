package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.util.stream.Collectors;

public class ListaDefinitiva extends ListState{

	public ListaDefinitiva(Excursion excursion) {
		super(excursion);
	}

	
	/*
	 * Si no se alcanza el cupo máximo de personar, se seguirán agreando
	 * personas a la lista definitiva. 
	 * Si se alcanza el cupo máximo de personas, la lista estará completa
	 * */
	@Override
	public void inscribirUsuario(Persona persona) {
		this.excursion.getListaDeInscriptos().add(persona);
		if (this.excursion.cupoMaxAlcanzado())
			this.excursion.actualizarEstado(new ListaCompleta(this.excursion));
	}


	/*
	 * Si se alcanza el cupo mínimo la información es la siguiente:
	 * */
	@Override
	public String infoDeEstadoExcursion() {
		
		String emails = this.excursion.emailsDeInscriptos().stream()
				.collect(Collectors.joining(", "));
		
		String info = this.excursion.infoBasicaDeExcursion();
		info+= "Email de los inscriptos: " + emails + "\n"
				+ "Faltantes para el cupo máximo: " 
				+ (this.excursion.getCupoMax() - this.excursion.getListaDeInscriptos().size());
		
		return info;
	}
}
