package ar.edu.info.unlp.ejercicioDemo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PorPuntaje extends ConfiguracionDecodificador{

	@Override
	public List<Pelicula> configuracion(Decodificador deco) {
		return deco.getGrilla().stream()
				.sorted(Comparator.comparingInt(peli -> peli.getPuntaje()))
//				.sorted(Comparator.comparingInt(Pelicula::getPuntaje))
				.collect(Collectors.toList());
	}


}
