package ar.edu.unlp.info.oo2.accesobd;

import java.util.List;

// Target/Component
public interface WeatherData {

	//retorna la temperatura en grados Fahrenheit.
	public abstract double getTemperatura();
	
	//retorna la presión atmosférica en hPa
	public abstract double getPresion();
	
	//retorna la radiación solar
	public abstract double getRadiacionSolar();
	
	
	//retorna una lista con todas las temperaturas sensadas hasta
	//el momento, en grado Fahrenheit
	public abstract List<Double> getTemperaturas();
	
	//retorna un reporte de todos los datos: temperatura, presión,
	//y radiación solar.
	public String displayData();
	
}
