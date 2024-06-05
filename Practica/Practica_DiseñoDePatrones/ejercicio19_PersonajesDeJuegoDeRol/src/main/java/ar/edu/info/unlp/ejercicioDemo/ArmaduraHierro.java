package ar.edu.info.unlp.ejercicioDemo;

public class ArmaduraHierro implements Armadura{

	@Override
	public int recibirAtaqueConArco() {
		return 3;
	}

	@Override
	public int recibirAtaqueConBaston() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int recibirAtaqueConEspada() {
		// TODO Auto-generated method stub
		return 5;
	}

}
