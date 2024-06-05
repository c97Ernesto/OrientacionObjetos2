package ar.edu.info.unlp.ejercicioDemo;

public class MagoProduct extends PersonajeProduct{

	public MagoProduct(String nombre) {
		super(nombre);
		this.setArmadura(new ArmaduraCuero());
		this.setArma(new ArmaBaston());
		this.getHabilidades().add(new HabilidadMagia());
		this.getHabilidades().add(new HabilidadCuerpoCuepo());
	}

}
