package ar.edu.info.unlp.ejercicioDemo;

public class ArmaBaston implements Arma{

	@Override
	public int golpearArmadura(Armadura armadura) {
		return armadura.recibirAtaqueConBaston();
	}

}
