package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class EnConstruccion extends Etapa{

	
	public EnConstruccion(Proyecto proyecto) {
		super(proyecto);
	}

	/*
	 * El proyecto pasa a etapa “En evaluación“ siempre y cuando su 
	 * precio no sea 0 (cero). De lo contrario genera un error.
	 * */
	@Override
	public void aprobarEtapa() {
		if (this.proyecto.precioDelProyecto() != 0)
			this.proyecto.setEtapaDelProyecto(new EnEvaluacion(this.proyecto));
	}
	
	/*
	 * Actualiza el margen de ganancia si se encuentra en los siguientes 
	 * valores: Para “En construcción” -> valores entre 8% y 10%.
	 */
	@Override
	public void modificarMargenDeGanancia(double nuevoMargen) {
		if (this.proyecto.getMargenDeGanancia() < 8 && this.proyecto.getMargenDeGanancia() > 10) {
			throw new RuntimeException("El margen de ganancias del proyecto no se encuentra "
					+ "dentro del rango para actualizar el valor");
		} else
			this.proyecto.setMargenDeGanancia(nuevoMargen);
	}
}
