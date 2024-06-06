package ar.edu.info.unlp.ejercicioDemo;

import java.util.List;

// ConcreteClass - ConcreteStrategy
public class PorSimilaridad extends ConfiguracionDecodificador{

	@Override
	public List<Pelicula> configuracion(Decodificador deco) {
		return deco.getReproducidas().stream()
				.flatMap(peli -> peli.getSimilares().stream())
				.distinct()
				.toList();
	}

	

}
