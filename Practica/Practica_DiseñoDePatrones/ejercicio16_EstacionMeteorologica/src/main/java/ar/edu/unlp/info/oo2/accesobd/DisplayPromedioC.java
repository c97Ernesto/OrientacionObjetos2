package ar.edu.unlp.info.oo2.accesobd;

public class DisplayPromedioC extends Decorador{

	public DisplayPromedioC(WeatherData componente) {
		super(componente);
	}
	
	public String displayData() {
		return super.displayData() + "Promedio en C: " + this.promedio()+ "; ";
	}
	
	
	
}
