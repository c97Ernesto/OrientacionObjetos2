package ar.edu.unlp.info.oo2.accesobd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherDataTest {

	HomeWeatherStation homeWeatherStation;
	WeatherData homeWeatherStationAdapter;
	WeatherData homeWeatherData;
	

	@BeforeEach
	void setUp() throws Exception {

		homeWeatherStation = new HomeWeatherStation(86, 1008, 200);
		
		homeWeatherStation.agregarTemp(81);
		homeWeatherStation.agregarTemp(90);
		
		homeWeatherStationAdapter = new HomeWeatherStationAdapter(homeWeatherStation);
	}

	@Test
	void testAdapter() {
		assertEquals("Temperatura F: 86.0; Presión atmosf: 1008.0; Radiación solar: 200.0; ", homeWeatherStation.displayData());
		
		assertEquals("Temperatura C: 30.0; Presión atmosf: 1008.0; Radiación solar: 200.0; ", homeWeatherStationAdapter.displayData());
	}
	
	@Test
	void testDecoratorC() {
		
		WeatherData promedioC = new DisplayPromedioC(homeWeatherStationAdapter);
		assertEquals("Temperatura C: 30.0; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio en C: 30.0; ", promedioC.displayData());
		
		
		WeatherData maximoC = new DisplayTemperaturaMaxC(promedioC);
		assertEquals("Temperatura C: 30.0; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio en C: 30.0; Máximo en C: 32.0; ", maximoC.displayData());
		
		WeatherData minimoC = new DisplayTemperaturaMinC(maximoC);
		assertEquals("Temperatura C: 30.0; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio en C: 30.0; Máximo en C: 32.0; Mínimo en C: 27.0; ", minimoC.displayData());
		
		
	}
	
	@Test
	void testDecoratorF() {

		WeatherData promediof = new DisplayPromedioF(homeWeatherStation);
		assertEquals("Temperatura F: 86.0; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio en F: 86.0; ", promediof.displayData());
		
		
		WeatherData maximof = new DisplayTemperaturaMaxF(promediof);
		assertEquals("Temperatura F: 86.0; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio en F: 86.0; Máximo en F: 90.0; ", maximof.displayData());
		
		WeatherData minimof = new DisplayTemperaturaMinF(maximof);
		assertEquals("Temperatura F: 86.0; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio en F: 86.0; Máximo en F: 90.0; Mínimo en F: 81.0; ", minimof.displayData());
	}

}



