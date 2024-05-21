package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Confirmado extends Etapa{
	
	public Confirmado(Proyecto proyecto) {
		super(proyecto);
	}

	//No produce efecto alguno
	@Override
	public void aprobarEtapa() {
	}

	//No produce efecto alguno
	@Override
	public void modificarMargenDeGanancia(double nuevoMargen) {
		throw new RuntimeException("No produce efecto en el proyecto debido a que se encuentra"
				+ "en etapa 'CONFIRMADO'");
	}
	
}
