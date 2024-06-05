package ar.edu.info.unlp.ejercicioDemo;

public class ArqueroCreator extends PersonajeCreator {

	@Override
	public PersonajeProduct factoryMethod(String nombreArquero) {
		return new MagoProduct(nombreArquero);
	}

}
