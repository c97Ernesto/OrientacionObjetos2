package ar.edu.info.unlp.ejercicioDemo;

public class GuerreroProduct extends PersonajeProduct{

	public GuerreroProduct(String nombre) {
		super(nombre);
		this.setArma(new ArmaEspada());
		this.setArmadura(new ArmaduraAcero());
		this.getHabilidades().add(new HabilidadCuerpoCuepo());
	}

}
