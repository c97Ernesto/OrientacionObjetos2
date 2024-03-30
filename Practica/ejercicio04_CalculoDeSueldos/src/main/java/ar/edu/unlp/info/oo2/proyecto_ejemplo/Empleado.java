package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public abstract class Empleado {
	
	
	public double sueldo() {
		return this.basico() + this.adicional() - this.descuento();
	}
	
	protected abstract double basico();
	
	protected abstract double adicional();
	
	protected double descuento() {
		return this.basico()*0.13 + this.adicional()*0.05;
	}
	
}
