package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Pasante extends Empleado{
	
	private static final int SUELDO_BASICO = 20000;
	private static final int MONTO_EXAMEN = 2000;
	
	private int cantExamenes;
	
	public Pasante(int examenesRendidos) {
		this.cantExamenes = examenesRendidos;
	}

	

	
	private int montoPorExamenes() {
		return Pasante.MONTO_EXAMEN * this.cantExamenes;
	}
	
	public double adicional() {
		return this.montoPorExamenes();
	}

	@Override
	public double basico() {
		return Pasante.SUELDO_BASICO;
	}

}
