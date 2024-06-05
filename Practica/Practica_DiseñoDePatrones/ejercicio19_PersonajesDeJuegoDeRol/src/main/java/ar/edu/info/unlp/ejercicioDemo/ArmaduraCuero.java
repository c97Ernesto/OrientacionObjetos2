package ar.edu.info.unlp.ejercicioDemo;

public class ArmaduraCuero implements Armadura{

	@Override
	public int recibirAtaqueConArco() {
		return 5;
	}

	@Override
	public int recibirAtaqueConBaston() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int recibirAtaqueConEspada() {
		// TODO Auto-generated method stub
		return 8;
	}

}
