package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Composite
public class Directorio extends FileSystem{
	private final int TAMANIO_DIR = 32;
	
	protected List<FileSystem> archivos; 
	
	public Directorio(String nombre, LocalDate fechaCreacion) {
		super(nombre, fechaCreacion);
		this.archivos = new ArrayList<FileSystem>();
	}
	
	public List<FileSystem> getArchivos() {
		return archivos;
	}

	public void setArchivos(List<FileSystem> archivos) {
		this.archivos = archivos;
	}
	
	public void addFile(FileSystem file) {
		getArchivos().add(file);
	}

	@Override
	public int tamanoTotalOcupado() {
		return this.getArchivos().stream()
				.mapToInt(dir -> dir.tamanoTotalOcupado())
				.sum() + this.TAMANIO_DIR;
	}

	@Override
	public Archivo archivoMasGrande() {
		return this.getArchivos().stream()
				.map(file -> file.archivoMasGrande())
				.max((archivo_x, archivo_y) -> Integer.compare(archivo_x.tamanoTotalOcupado(), archivo_y.tamanoTotalOcupado()))
				.orElse(null);
	}
	

	@Override
	public Archivo archivoMasNuevo() {
		return this.getArchivos().stream()
				.map(file -> file.archivoMasNuevo())
				.max((a1, a2) -> a1.getFechaCreacion().compareTo(a2.getFechaCreacion()))
				.orElse(null);
	}

	@Override
	public FileSystem buscar(String nombre) {
	    if (this.nombre.equals(nombre)) 
	        return this; 
	    else {
	    	FileSystem file;
	        for (FileSystem archivo : archivos) {
	            file = archivo.buscar(nombre);
	            if (file != null && file.nombre.equals(nombre)) {
	                return file;
	            }
	        }
	    }
		return null;
	}

	@Override
	public void buscarTodos(String nombre, List<FileSystem> archivos) {
		if (this.nombre.equals(nombre))
			archivos.add(this);
		for (FileSystem archivo: this.archivos) {
			archivo.buscarTodos(nombre, archivos);
		}
//		this.getArchivos().stream().forEach(archivo -> archivo.buscarTodos(nombre, archivos));
	}
}