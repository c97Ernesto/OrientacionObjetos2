package ar.edu.info.unlp.ejercicioDemo;

public class ArmaArco implements Arma{

	@Override
	public int golpearArmadura(Armadura armadura) {
		return armadura.recibirAtaqueConArco();
	}

}
