package ar.edu.unlp.info.oo2.accesobd;

import java.util.List;
import java.util.stream.Collectors;

// Adapter/ConcreteComponent
public class HomeWeatherStationAdapter implements WeatherData {
	
	private HomeWeatherStation homeWeatherStation;
	
	public HomeWeatherStationAdapter(HomeWeatherStation homeWeatherStation) {
		this.homeWeatherStation = homeWeatherStation;
	}
	
	//retorna la temperatura en grados Fahrenheit.
	public double getTemperatura() {
		return convertirTemperatura(homeWeatherStation.getTemperatura());
	}
	
	private double convertirTemperatura(double t) {
		return Math.round((t-32)/1.8);
	}

	//retorna la presión atmosférica en hPa
	public double getPresion() {
		return this.homeWeatherStation.getPresion();
	}
	
	//retorna la radiación solar
	public double getRadiacionSolar() {
		return this.homeWeatherStation.getRadiacionSolar();
	}
	
	//retorna una lista con todas las temperaturas sensadas hasta
	//el momento, en grado Fahrenheit
	public List<Double> getTemperaturas(){
		return this.homeWeatherStation.getTemperaturas().stream()
				.map(real -> convertirTemperatura(real))
				.collect(Collectors.toList());
	}
	
	//retorna un reporte de todos los datos: temperatura, presión,
	//y radiación solar.
	public String displayData(){
		return "Temperatura C: " + this.getTemperatura() + "; " +
				"Presión atmosf: " + this.getPresion() + "; " +
				"Radiación solar: " + this.getRadiacionSolar() + "; ";
	}
	
}
