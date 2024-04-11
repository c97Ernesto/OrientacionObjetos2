package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public abstract class Topografia {

	
	public abstract double proporcionDeAgua();

	public abstract boolean sonIguales(Topografia topografia);
	
	public abstract boolean igualAgua();
	
	public abstract boolean igualTierra();

	
	//establezco método solo para Topografía Mixta
	public abstract boolean igualMixta(Mixta topografiaMixta);
	
}
