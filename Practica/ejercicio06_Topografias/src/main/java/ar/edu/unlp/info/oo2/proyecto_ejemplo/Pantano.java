package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Pantano extends Topografia{

	@Override
	public double proporcionDeAgua() {
		return 0;
	}

	@Override
	public boolean sonIguales(Topografia topografia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean igualAgua() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean igualTierra() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public boolean igualMixta(Mixta topografiaMixta) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
