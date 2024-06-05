package ar.edu.info.unlp.ejercicioDemo;

public class MagoCreator extends PersonajeCreator {

	@Override
	public PersonajeProduct factoryMethod(String nombreDelMago) {
		return new MagoProduct(nombreDelMago);
	}

}
