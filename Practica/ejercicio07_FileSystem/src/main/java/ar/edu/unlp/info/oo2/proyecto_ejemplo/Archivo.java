package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.LocalDate;
import java.util.List;


//Leaf
public class Archivo extends FileSystem{
	private int tamanio;
	
	public Archivo(String nombre, LocalDate fechaCreacion, int tamanio) {
		super(nombre, fechaCreacion);
		this.setTamanio(tamanio);
	}

	@Override
	public int tamanoTotalOcupado() {
		return getTamanio();
	}

	@Override
	public Archivo archivoMasGrande() {
		return this;
	}

	@Override
	public Archivo archivoMasNuevo() {
		return this;
	}

	@Override
	public FileSystem buscar(String nombre) {
		if (this.nombre.equals(nombre))
			return this;
		else
			return null;

	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	@Override
	public void buscarTodos(String nombre, List<FileSystem> archivos) {
		if (this.nombre.equals(nombre))
			archivos.add(this);
	}
}
