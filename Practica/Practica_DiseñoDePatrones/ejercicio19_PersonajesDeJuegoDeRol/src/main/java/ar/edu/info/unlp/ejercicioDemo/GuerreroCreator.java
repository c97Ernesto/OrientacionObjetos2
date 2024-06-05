package ar.edu.info.unlp.ejercicioDemo;

public class GuerreroCreator extends PersonajeCreator{

	@Override
	public PersonajeProduct factoryMethod(String nombrePersonaje) {
		return new GuerreroProduct(nombrePersonaje);
	}

}
