package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Planta extends EmpleadoConFamilia{
	
	private static final int SUELDO_BASICO = 50000;
	private static final int MONTO_POR_ANIO = 2000;
	
	private int aniosAntiguedad;
	

	public Planta(boolean esCasado, int hijos, int aniosAntiguedad) {
		super(esCasado, hijos);
		
		this.aniosAntiguedad = aniosAntiguedad;
	}
	
	private int montoPorAntiguedad() {
		return this.aniosAntiguedad * Planta.MONTO_POR_ANIO; 
	}
	
	
	

	@Override
	public double basico() {
		return Planta.SUELDO_BASICO;
	}

	@Override
	public double adicional() {
		return super.montoPorCasado() + super.montoPorHijos() + this.montoPorAntiguedad();
	}


}
