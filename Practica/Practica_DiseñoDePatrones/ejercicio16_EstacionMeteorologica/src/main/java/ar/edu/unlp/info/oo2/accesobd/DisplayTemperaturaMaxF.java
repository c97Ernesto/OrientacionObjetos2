package ar.edu.unlp.info.oo2.accesobd;

public class DisplayTemperaturaMaxF extends Decorador{

	public DisplayTemperaturaMaxF(WeatherData componente) {
		super(componente);
		// TODO Auto-generated constructor stub
	}

	public String displayData() {
		return super.displayData() + "Máximo en F: " + this.tempMax()+ "; ";
	}
}
