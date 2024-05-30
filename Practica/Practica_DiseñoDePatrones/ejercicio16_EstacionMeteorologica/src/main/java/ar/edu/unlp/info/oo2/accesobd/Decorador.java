package ar.edu.unlp.info.oo2.accesobd;

import java.util.List;

public abstract class Decorador implements WeatherData{

	private WeatherData componente;
	
	
	public Decorador(WeatherData componente) {
		this.componente = componente;
	}
	
	@Override
	public double getTemperatura() {
		return componente.getTemperatura();
	}

	@Override
	public double getPresion() {
		return componente.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		return componente.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturas() {
		return componente.getTemperaturas();
	}

	@Override
	public String displayData() {
		return componente.displayData();
	}
	
	protected double promedio() {
		double prom = this.getTemperaturas().stream()
				.mapToDouble(d -> d)
				.average()
				.orElse(0.0);
		return Math.round(prom);
	}
	
	protected double tempMax() {
		return this.getTemperaturas().stream()
				.max((t1, t2) -> Double.compare(t1, t2))
				.orElse(null);
	}
	
	protected double tempMin() {
		return this.getTemperaturas().stream()
				.min((t1, t2) -> Double.compare(t1, t2))
				.orElse(null);
	}
	
}
