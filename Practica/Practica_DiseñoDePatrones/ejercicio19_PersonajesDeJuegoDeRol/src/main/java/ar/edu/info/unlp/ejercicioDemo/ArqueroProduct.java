package ar.edu.info.unlp.ejercicioDemo;

public class ArqueroProduct extends PersonajeProduct{

	public ArqueroProduct(String nombre) {
		super(nombre);
		this.setArma(new ArmaArco());
		this.setArmadura(new ArmaduraCuero());
		this.getHabilidades().add(new HabilidadDisparo());
	}

}
