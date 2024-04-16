package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Agua extends Topografia{

	@Override
	public double proporcionDeAgua() {
		return 1;
	}

	@Override
	public boolean sonIguales(Topografia otraTopografia) {
		return otraTopografia.igualAgua();
	}
	
	@Override
	public boolean igualAgua() {
		return true;
	}
	
	@Override
	public boolean igualTierra() {
		return false;
	}


	@Override
	public boolean igualMixta(Mixta topografiaMixta) {
		return false;
	}

	@Override
	public boolean igualPantano() {
		return false;
	}
	
}
