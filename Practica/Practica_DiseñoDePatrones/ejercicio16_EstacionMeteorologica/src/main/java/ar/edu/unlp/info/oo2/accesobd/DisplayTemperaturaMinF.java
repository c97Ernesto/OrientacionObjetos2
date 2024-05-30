package ar.edu.unlp.info.oo2.accesobd;

public class DisplayTemperaturaMinF extends Decorador {

	public DisplayTemperaturaMinF(WeatherData componente) {
		super(componente);
		// TODO Auto-generated constructor stub
	}

	public String displayData() {
		return super.displayData() + "Mínimo en F: " + this.tempMin()+ "; ";
	}
}
