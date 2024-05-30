package ar.edu.unlp.info.oo2.accesobd;

public class DisplayPromedioF extends Decorador{

	public DisplayPromedioF(WeatherData componente) {
		super(componente);
	}
	
	public String displayData() {
		return super.displayData() + "Promedio en F: " + this.promedio() + "; ";
	}

	
}
