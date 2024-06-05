package ar.edu.info.unlp.ejercicioDemo;

public class ArmaEspada implements Arma{

	@Override
	public int golpearArmadura(Armadura armadura) {
		return armadura.recibirAtaqueConEspada();
	}

}
