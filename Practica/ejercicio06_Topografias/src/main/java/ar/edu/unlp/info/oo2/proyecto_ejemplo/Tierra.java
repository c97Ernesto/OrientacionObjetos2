package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Tierra extends Topografia{

	
	@Override
	public double proporcionDeAgua() {
		return 0;
	}

	@Override
	public boolean sonIguales(Topografia otraTopografia) {
		return otraTopografia.igualTierra();
	}
	
	@Override
	public boolean igualAgua() {
		return false;
	}
	
	@Override
	public boolean igualTierra() {
		return true;
	}

	@Override
	public boolean igualMixta(Mixta topografiaMixta) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
