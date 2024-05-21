package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class EnEvaluacion extends Etapa{

	
	public EnEvaluacion(Proyecto proyecto) {
		super(proyecto);
	}


	/*
	 * El Proyecto pasa a etapa confirmada
	 * */
	@Override
	public void aprobarEtapa() {
		this.proyecto.setEtapaDelProyecto(new Confirmado(this.proyecto));
	}

	
	/*
	 * Actualiza el margen de ganancia si se encuentra en los siguientes 
	 * valores: Para “En evaluación” -> valores entre 11% y 15%
	 * */
	@Override
	public void modificarMargenDeGanancia(double nuevoMargen) {
		if (this.proyecto.getMargenDeGanancia() < 11 && this.proyecto.getMargenDeGanancia() > 15) {
			throw new RuntimeException("El margen de ganancias del proyecto no se encuentra "
					+ "dentro del rango para actualizar el valor");
		} else
			this.proyecto.setMargenDeGanancia(nuevoMargen);
	}
	
	
}
