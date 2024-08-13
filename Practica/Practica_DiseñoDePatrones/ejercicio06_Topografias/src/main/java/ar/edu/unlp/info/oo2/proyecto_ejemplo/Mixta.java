package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.util.ArrayList;
import java.util.List;

public class Mixta extends Topografia{
	
	List<Topografia> partes;
	
	public Mixta(List<Topografia> partes) {
		partes = new ArrayList<Topografia>(partes);
	}
	
	@Override
	public double proporcionDeAgua() {
		return this.totalDeAgua() / partes.size();
	}
	
	
	private double totalDeAgua() {
		return partes.stream().mapToDouble(parte -> parte.proporcionDeAgua()).sum();
	}

	@Override
	public boolean sonIguales(Topografia otraTopografia) {
		// TODO Auto-generated method stub
		return otraTopografia.igualMixta(this);
	}
	
	@Override
	public boolean igualMixta(Mixta topografiaMixta) {
		
		for (int i = 0; i < this.partes.size(); i++) {
			
			if (!this.partes.get(i).sonIguales(topografiaMixta.partes.get(i))) {
				return false;
			}
		}
		return true;
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
	public boolean igualPantano() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
