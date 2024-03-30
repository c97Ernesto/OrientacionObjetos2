package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Temporario extends EmpleadoConFamilia{
	
	private static final int SUELDO_BASICO = 20000;
	private static final int MONTO_HORA = 300;
	
	private int horasTrabajadas;
	
	
	public Temporario(boolean estaCasado, int hijos, int horasTrabajadas) {
		super(estaCasado, hijos);
		
		this.horasTrabajadas = horasTrabajadas;
	}
	
	private int montoPorHorasTrabajadas() {
		return Temporario.MONTO_HORA * this.horasTrabajadas;
	}
	
	public double basico() {
		return Temporario.SUELDO_BASICO + this.montoPorHorasTrabajadas();
	}

	@Override
	public double adicional() {
		return super.montoPorCasado() + super.montoPorHijos();
	}

	

}
