package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public abstract class EmpleadoConFamilia extends Empleado {
	
	private static final int MONTO_HIJO = 2000;
	private static final int MONTO_CASADO = 5000;
	
	private boolean esCasado;
	private int cantHijos;
	

	public EmpleadoConFamilia(boolean esCasado, int hijos) {
		this.esCasado = esCasado;
		this.cantHijos = hijos;
	}
	
	protected int montoPorHijos() {
		return EmpleadoConFamilia.MONTO_HIJO * this.cantHijos;
	}
	
	protected int montoPorCasado() {
		if (this.esCasado)
			return EmpleadoConFamilia.MONTO_CASADO;
		return 0;
	}
	
}
