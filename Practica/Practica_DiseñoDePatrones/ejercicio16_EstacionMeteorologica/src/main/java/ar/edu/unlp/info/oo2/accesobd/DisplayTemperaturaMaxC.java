package ar.edu.unlp.info.oo2.accesobd;

public class DisplayTemperaturaMaxC extends Decorador{

	public DisplayTemperaturaMaxC(WeatherData componente) {
		super(componente);
	}

	public String displayData() {
		return super.displayData() + "Máximo en C: " + this.tempMax()+ "; ";
	}
	
}
