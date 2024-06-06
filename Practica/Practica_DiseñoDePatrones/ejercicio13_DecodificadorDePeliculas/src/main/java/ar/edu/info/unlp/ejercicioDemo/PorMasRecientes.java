package ar.edu.info.unlp.ejercicioDemo;

import java.util.List;
import java.util.stream.Collectors;


// ConcreteClass - ConcreteStrategy 
public class PorMasRecientes extends ConfiguracionDecodificador{

	@Override
	public List<Pelicula> configuracion(Decodificador deco) {
		return deco.getGrilla().stream()
				.sorted((peli1, peli2) -> peli1.getAnioEstreno().compareTo(peli2.getAnioEstreno()))
				.collect(Collectors.toList());
	}

	
}
