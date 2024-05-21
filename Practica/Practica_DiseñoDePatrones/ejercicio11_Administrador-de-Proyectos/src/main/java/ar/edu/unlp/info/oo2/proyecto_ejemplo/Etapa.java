package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public abstract class Etapa {
	
	protected Proyecto proyecto;
	
	
	public Etapa(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public abstract void aprobarEtapa();
	
	public double costoDelProyecto(){
		return this.proyecto.costoEnPersonal();
	}
	
	public double precioDelProyecto() {
		return  this.costoDelProyecto() + this.proyecto.getMargenDeGanancia();
	}
	
	public abstract void modificarMargenDeGanancia(double nuevoMargen);

	public void cancelarProyecto() {
		if (!this.proyecto.getObjetivo().equals("Cancelado"))
			this.proyecto.setObjetivo("Cancelado");
	}
}
