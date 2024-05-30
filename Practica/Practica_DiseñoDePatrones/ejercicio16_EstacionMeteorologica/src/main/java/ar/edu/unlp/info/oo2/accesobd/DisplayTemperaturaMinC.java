package ar.edu.unlp.info.oo2.accesobd;

public class DisplayTemperaturaMinC extends Decorador {

	public DisplayTemperaturaMinC(WeatherData componente) {
		super(componente);
	}

	public String displayData() {
		return super.displayData() + "Mínimo en C: " + this.tempMin()+ "; ";
	}
	
}
