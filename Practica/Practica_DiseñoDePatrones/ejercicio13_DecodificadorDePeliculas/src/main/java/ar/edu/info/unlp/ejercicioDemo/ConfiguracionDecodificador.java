package ar.edu.info.unlp.ejercicioDemo;

import java.util.List;

public abstract class ConfiguracionDecodificador {

	public List<Pelicula> sugerencias(Decodificador deco){
		return this.configuracion(deco);
	}
	
	public abstract List<Pelicula> configuracion(Decodificador deco);
	
}
